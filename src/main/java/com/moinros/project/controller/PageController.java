package com.moinros.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOG = LoggerFactory.getLogger(PageController.class);
    @GetMapping
    String index() {
        LOG.debug("连接测试页面！");
        return "index";
    }
}
