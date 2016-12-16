package com.lsf.demo.spring.boot.batch;

import com.lsf.demo.spring.boot.entity.People;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class TriggerBatchConfig {

    @Bean
    @StepScope
    public FlatFileItemReader<People> reader2(@Value("#{jobParameters['input.file.name']}") String pathToFile) throws Exception {
        FlatFileItemReader<People> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource(pathToFile));
        reader.setLineMapper(new DefaultLineMapper<People>() {{ // 数据映射
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"name", "age", "nation", "address"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<People>() {{
                setTargetType(People.class);
            }});
        }});

        return reader;
    }

    @Bean
    public ItemProcessor<People, People> processor2() {
        CsvItemProcessor processor = new CsvItemProcessor(); //1 自定义数据处理器
        processor.setValidator(batchBeanValidator()); //2 自定义数据校验器
        return processor;
    }


    @Bean
    public ItemWriter<People> writer2(DataSource dataSource) {//1
        JdbcBatchItemWriter<People> writer = new JdbcBatchItemWriter<>(); //2
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        String sql = "insert into people " + "(name,age,nation,address) "
                + "values( :name, :age, :nation,:address)";
        writer.setSql(sql); //3
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public Step step2(StepBuilderFactory stepBuilderFactory, ItemReader<People> reader2, ItemWriter<People> writer2,
                      ItemProcessor<People, People> processor2) {
        return stepBuilderFactory
                .get("step2")
                .<People, People>chunk(1) //1 每次提交数据量
                .reader(reader2)
                .processor(processor2)
                .writer(writer2)
                .build();
    }

    @Bean
    public JobRepository jobRepository(DataSource dataSource, PlatformTransactionManager transactionManager)
            throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(dataSource);
        jobRepositoryFactoryBean.setTransactionManager(transactionManager);
        jobRepositoryFactoryBean.setDatabaseType("mysql");
        return jobRepositoryFactoryBean.getObject();
    }

    @Bean
    public SimpleJobLauncher jobLauncher(DataSource dataSource, PlatformTransactionManager transactionManager)
            throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository(dataSource, transactionManager));
        return jobLauncher;
    }

    @Bean
    public Job importJob(JobBuilderFactory jobs, Step step2) {
        return jobs.get("importJob")
                .incrementer(new RunIdIncrementer())
                .flow(step2) //1 绑定Step
                .end()
                .listener(batchJobListener()) //2 绑定监听器
                .build();
    }

    @Bean
    public BatchJobListener batchJobListener() {
        return new BatchJobListener();
    }

    @Bean
    public Validator<Object> batchBeanValidator() {
        return new BatchBeanValidator<>();
    }

}
