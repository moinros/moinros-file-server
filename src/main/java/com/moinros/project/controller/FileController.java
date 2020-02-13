package com.moinros.project.controller;

import com.moinros.project.model.pojo.FileData;
import com.moinros.project.result.Reply;
import com.moinros.project.tool.SystemUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 注释:
 *
 * @Author moinros
 * @Date 2020/2/14 1:14
 * @Verison 1.0
 */
@RestController
@RequestMapping("/file/server")
public class FileController {

    /**
     * SERVER_PATH : 服务器访问路径
     */
    public static String SERVER_PATH;

    /**
     * RESOURCES_PATH : 文件资源路径
     */
    public static final String RESOURCES_PATH = "/file-server/files/";

    static {
        if (SystemUtil.isWindows()) {
            SERVER_PATH = "http://127.0.0.1";
        } else {
            SERVER_PATH = "https://www.server-file.com";
        }
    }

    @PostMapping(value = "/upload")
    public Reply upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {

        return null;
    }

    /**
     * 注释: 将上传的文件保存到磁盘
     *
     * @param file     文件
     * @param filedata 文件信息
     */
    public FileData saveFileDisk(MultipartFile file, FileData filedata, HttpServletRequest request) {

        return null;
    }

    public boolean isType(String[] arr, String postfix) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(postfix)) {
                return true;
            }
        }
        return false;
    }
}
