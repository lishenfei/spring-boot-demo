package com.lsf.demo.spring.boot.controller;

import com.lsf.demo.spring.boot.entity.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lishenfei on 2016-12-15.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", Msg.builder()
                .content("测试内容")
                .title("测试标题")
                .etraInfo("测试附加信息")
                .build());
        return "home";
    }
}
