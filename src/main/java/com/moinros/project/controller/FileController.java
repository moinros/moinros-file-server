package com.moinros.project.controller;

import com.moinros.project.model.pojo.FileData;
import com.moinros.project.result.Reply;
import com.moinros.project.result.enums.Status;
import com.moinros.project.result.vo.WebReply;
import com.moinros.project.result.vo.WebResult;
import com.moinros.project.service.FileService;
import com.moinros.project.tool.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.*;

/**
 * 注释:
 *
 * @Author moinros
 * @Date 2020/2/14 1:14
 * @Verison 1.0
 */
@RestController
@RequestMapping("/server/file")
public class FileController {

    private static final Logger LOG = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService service;

    /**
     * SERVER_PATH : 服务器访问路径
     */
    public static String SERVER_PATH;

    /**
     * RESOURCES_PATH : 文件资源路径
     */
    public static String RESOURCES_PATH = "/file-server/files/";

    static {
        if (SystemUtil.isWindows()) {
            SERVER_PATH = "http://127.0.0.1/";
            RESOURCES_PATH = "D:/Java/project/server/files/";
        } else {
            SERVER_PATH = "https://www.server-file.com/";
            RESOURCES_PATH = "/file-server/files/";
        }
    }

    private Status SUCCESS = Status.success;
    private Status ERROR = Status.error;

    @PostMapping(value = "/upload")
    public Reply uploadTest(HttpServletRequest request) throws IOException, ServletException {
        Reply reply = new WebReply();
        reply.setState(Status.success);
        Collection<Part> parts = request.getParts();
        Iterator<Part> iterator = parts.iterator();
        while (iterator.hasNext()) {
            Part part = iterator.next();
            System.out.println("-----类型名称------->" + part.getName());
            System.out.println("-----类型------->" + part.getContentType());
            System.out.println("-----提交的类型名称------->" + part.getSubmittedFileName());
            System.out.println("---- -------->" + part.getInputStream());
            byte[] arr = FileUtil.readInputStream(part.getInputStream());
            System.out.println(Arrays.toString(arr));
            FileUtil.byteToFile(arr, RESOURCES_PATH + part.getSubmittedFileName());
        }
        reply.setContent(null);
        return reply;
    }

    /**
     * 以二进制的形式上传用户头像
     *
     * @param request HttpServletRequest
     * @return Reply 响应结果集
     */
    @PostMapping(value = "/upload/binary/user")
    public Reply uploadUserImage(HttpServletRequest request) {
        return saveFile(request, "[USER_IMAGE]", "user");
    }

    /**
     * 以二进制的形式读取上传文件的控制器
     *
     * @param request HttpServletRequest
     * @return Reply 响应结果集
     */
    @PostMapping(value = "/upload/binary")
    public Reply upload(HttpServletRequest request) {
        return saveFile(request, null, null);
    }

    /**
     * 保存文件
     *
     * @param request  HttpServletRequest
     * @param fastCode 快速检索码,没有传null
     * @param path     文件路径,不指定则根据文件后缀分类存放
     * @return 响应结果集
     */
    public Reply saveFile(HttpServletRequest request, String fastCode, String path) {
        LOG.info("上传文件！");
        WebResult reply = new WebResult();
        List result = new ArrayList();
        reply.setResult(result);
        try {
            List<ParamBinary> list = WebUtil.getParameter(request);
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    // 判断是否是文件
                    if (list.get(i).isFile()) {
                        FileData data = new FileData();
                        // 文件MD5
                        data.setFileMd5(DigestUtils.md5Hex(list.get(i).getValue()));
                        // 文件后缀
                        data.setPostfix(FileStringUtil.getFilePostfix(list.get(i).getFileName()));
                        // 为文件重命名
                        data.setFileName(System.currentTimeMillis() + "-" + data.getFileMd5() + "." + data.getPostfix());
                        // 文件类型
                        data.setFileType(list.get(i).getFileType());
                        // 上传时间
                        data.setUploadTime(DateFormatUtil.getDateTime());
                        // 文件磁盘路径
                        data.setDiskPath(RESOURCES_PATH + (path != null ? path : data.getPostfix()));
                        // 文件网络访问路径
                        data.setNetworkPath(SERVER_PATH + (path != null ? path : data.getPostfix()) + "/" + data.getFileName());
                        // 文件完整磁盘路径
                        data.setFilePath(data.getDiskPath() + "/" + data.getFileName());
                        // 客户端IP
                        data.setClientIp(NetworkUtil.getIpAddress(request));
                        // 客户端OS
                        data.setClientOs(request.getHeader("User-Agent"));
                        // 快速检索码
                        if (fastCode != null) {
                            data.setFastCode(fastCode);
                        } else {
                            data.setFastCode(DateFormatUtil.getDate() + " [" + data.getFileType() + "]");
                        }
                        // 将二进制文件数据写入磁盘指定位置
                        FileUtil.byteToFile(list.get(i).getValue(), data.getFilePath());
                        // 将文件详细数据保存到数据库
                        service.saveFile(data);
                        result.add(data);
                    }
                }
            }
            reply.setState(SUCCESS);
            reply.setContent("文件上传成功！");
        } catch (IOException e) {
            LOG.error(e.toString());
            reply.setState(ERROR);
            reply.setContent(e);
        } catch (ServletException e) {
            LOG.error(e.toString());
            reply.setState(ERROR);
            reply.setContent(e);
        }
        return reply;
    }

}