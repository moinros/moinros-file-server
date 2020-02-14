package com.moinros.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 注释:
 *
 * @Author moinros
 * @Date 2020/2/14 16:00
 * @Verison 1.0
 */
@Controller
public class PageController {

    @GetMapping
    String index() {
        return "index";
    }
}
