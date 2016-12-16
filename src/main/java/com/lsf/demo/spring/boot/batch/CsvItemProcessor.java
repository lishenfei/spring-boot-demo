package com.lsf.demo.spring.boot.batch;

import com.lsf.demo.spring.boot.entity.People;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

/**
 * 自定义数据处理器
 * Created by lishenfei on 2016-12-15.
 */
public class CsvItemProcessor extends ValidatingItemProcessor<People> {

    @Override
    public People process(People item) throws ValidationException {
        super.process(item); // 必须调用

        item.setNation(item.getNation().equals("汉族") ? "01" : "02");
        return item;
    }
}
