package com.lsf.demo.spring.boot.controller;

import com.lsf.demo.spring.boot.model.Author;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by lishenfei on 2016-12-07.
 */
@Api(value = "authors")
@RestController
@RequestMapping("authors")
@Slf4j
public class AuthorController {

    @Value("${author}")
    private String author;

    @ApiOperation(value = "查询作者信息")
    @RequestMapping(method = RequestMethod.GET)
    public Author author() {
        log.debug("request get author");
        return new Author(author, "lishenfei@foxmail.com");
    }

    @ApiOperation("添加作者")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "操作成功")})
    @RequestMapping(method = RequestMethod.POST)
    public void addAuthor(@Valid @RequestBody Author author) {  // 使用@RequestBody, POST提交整个JSON字符串
        System.out.println(author);
    }

    @ApiOperation(value = "查询指定作者信息")
    @ApiResponses(value = {@ApiResponse(code = 204, message = "查询无数据")})
    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public Author getAuthor(@Valid @ModelAttribute Author author) {
        return author;
    }

    @ApiOperation(value = "查询指定作者信息")
    @ApiResponses(value = {@ApiResponse(code = 204, message = "查询无数据")})
    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public Author getAuthor(
            @ApiParam(value = "姓名", required = true) @NotEmpty @PathVariable("name") String name,
            @ApiParam(value = "邮箱", required = true) @NotEmpty @RequestParam("email") String email) {
        return new Author(name, email);
    }
}
