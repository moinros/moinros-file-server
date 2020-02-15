package com.moinros.project.controller;

import com.moinros.project.tool.NetworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
    String index(HttpServletRequest request) throws IOException {
        LOG.debug("连接测试页面！ IP=" + NetworkUtil.getIpAddress(request) + ";\t OS=" + request.getHeader("User-Agent"));
        return "index";
    }
}
