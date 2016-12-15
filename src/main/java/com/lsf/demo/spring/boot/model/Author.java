package com.lsf.demo.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by lishenfei on 2016-12-08.
 */
@ApiModel(value = "Author", description = "作者信息")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data // 包括 @ToString, @EqualsAndHashCode, @RequiredArgsConstructor, 和@Getter / @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    @ApiModelProperty(value = "姓名", example = "lishenfei", required = true)
    @NotEmpty
    @Length(max = 20)
    private String name;

    @ApiModelProperty(value = "邮箱", example = "lishenfei@foxmail.com", required = true)
    @NotEmpty
    @Length(max = 100)
    private String email;

}
