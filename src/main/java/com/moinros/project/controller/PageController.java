package com.moinros.project.controller;

import com.moinros.project.result.sub.KeyValue;
import com.moinros.project.tool.FileUtil;
import com.moinros.project.tool.NetworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * 查询指定路径下的所有日志文件
     *
     * @return
     */
    @GetMapping("/server/find/logs")
    String findLogs(HttpServletRequest request, Model model) throws IOException {
        LOG.debug("查询日志文件！ IP=" + NetworkUtil.getIpAddress(request) + ";\t OS=" + request.getHeader("User-Agent"));
        File[] files = FileUtil.readFiles(FileController.LOG_FILE_PATH);
        List li = new ArrayList();
        for (File file : files) {
            if (file.isFile())
                li.add(new KeyValue(file.getName(), FileController.SERVER_URL + "/server/file/download/log?name=" + file.getName()));
        }
        model.addAttribute("download_links", li);
        return "logs";
    }

}
