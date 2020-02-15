package com.moinros.project.controller;

import com.moinros.project.common.ParamIsNull;
import com.moinros.project.model.pojo.FileData;
import com.moinros.project.result.Reply;
import com.moinros.project.result.enums.Status;
import com.moinros.project.result.vo.WebFileInfo;
import com.moinros.project.result.vo.WebReply;
import com.moinros.project.result.vo.WebResult;
import com.moinros.project.service.FileService;
import com.moinros.project.tool.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public static String RESOURCES_PATH;

    static {
        // 根据OS,使用不同路径
        if (SystemUtil.isWindows()) {
            SERVER_PATH = "http://127.0.0.1/";
            RESOURCES_PATH = "D:/Java/project/server/files/";
        } else {
            SERVER_PATH = "https://www.server-file.com/backups/files/";
            RESOURCES_PATH = "/usr/local/server/tomcat/webapps/backups/files/";
        }
    }

    private Status SUCCESS = Status.success;
    private Status ERROR = Status.error;

    /**
     * 查询'USER_FACE_IMAGE'用户头像数据
     *
     * @return Reply 结果集
     */
    @GetMapping("/find/list/face")
    public Reply findFaceImage() {
        Reply reply = new WebReply();
        try {
            List li = service.findFileByFastCode("USER_FACE_IMAGE");
            reply.setState(SUCCESS);
            reply.setContent(sort(li));
        } catch (Exception e) {
            reply.setState(ERROR);
            reply.setContent("查询失败！");
            LOG.error(e.toString());
        }
        return reply;
    }

    /**
     * 查询数据集合,可指定条件
     *
     * @param type     文件类型
     * @param postfix  文件后缀
     * @param fastCode 快速检索码
     * @return Reply 结果集
     */
    @GetMapping("/find/list")
    @ParamIsNull(paramName = {"type", "postfix", "fastCode"})
    public Reply findFileList(String type, String postfix, String fastCode) {
        Reply reply = new WebReply();
        try {
            FileData data = new FileData();
            if (type != null) {
                data.setFileType(type);
            }
            if (postfix != null) {
                data.setPostfix(postfix);
            }
            if (fastCode != null) {
                data.setFastCode(fastCode);
            }
            List li = service.findFileList(data);
            reply.setState(SUCCESS);
            reply.setContent(sort(li));
        } catch (Exception e) {
            reply.setState(ERROR);
            reply.setContent("查询失败！");
            LOG.error(e.toString());
        }
        return reply;
    }

    /**
     * 分页查询文件数据
     *
     * @param page 页码
     * @param size 每页显示条数
     * @return Reply 结果集
     */
    @GetMapping("/find/list/page")
    public Reply findPageList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Reply reply = new WebReply();
        try {
            PageBean bean = service.findFileByPage(page, size);
            reply.setState(SUCCESS);
            reply.setContent(sort(bean));
        } catch (Exception e) {
            reply.setState(ERROR);
            reply.setContent("查询失败！");
            LOG.error(e.toString());
        }
        return reply;
    }

    /**
     * 以二进制的形式上传用户头像
     *
     * @param request HttpServletRequest
     * @return Reply 响应结果集
     */
    @PostMapping(value = "/upload/binary/face")
    public Reply uploadUserImage(HttpServletRequest request) {
        return saveFile(request, "USER_FACE_IMAGE", "face");
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
        LOG.info("==================== 上传文件 LOG START ====================\n时间: " + DateFormatUtil.getDateTime());
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
                        result.add(sort(data));
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
        LOG.info("==================== 上传文件 LOG END ====================");
        return reply;
    }

    /**
     * 将文件数据整理到 WebFileInfo 中
     *
     * @param bean 分页数据
     * @return Map<String, Object>
     */
    Map<String, Object> sort(PageBean<FileData> bean) {
        Map<String, Object> result = new HashMap();
        if (bean != null) {
            List list = sort(bean.getList());
            result.put("page", bean.getPageNo()); // 当前页码数
            result.put("size", bean.getDataSize()); // 每页显示的记录数
            result.put("totalCount", bean.getTotalCount()); // 总记录数
            result.put("totalPage", bean.getTotalPage()); // 总页码数
            result.put("pageNumber", bean.getPageNumber()); // 前后页码数组
            result.put("result", list);
            return result;
        }
        return null;
    }

    /**
     * 将文件数据整理到 WebFileInfo 中
     *
     * @param list 多个文件数据的集合
     * @return List<WebFileInfo>
     */
    List<WebFileInfo> sort(List<FileData> list) {
        if (list != null && list.size() > 0) {
            List<WebFileInfo> item = new ArrayList();
            for (FileData fileData : list) {
                item.add(sort(fileData));
            }
            return item;
        } else {
            return null;
        }
    }

    /**
     * 将文件数据整理到 WebFileInfo 中,用于回显使用,相对 FileData 少了文件的磁盘路径等服务器相关信息
     *
     * @param data 文件数据
     * @return WebFileInfo
     */
    WebFileInfo sort(FileData data) {
        WebFileInfo info = new WebFileInfo();
        info.setFid(data.getFid());
        info.setFileType(data.getFileType());
        info.setFastCode(data.getFastCode());
        info.setPostfix(data.getPostfix());
        info.setFileName(data.getFileName());
        info.setNetworkPath(data.getNetworkPath());
        info.setFileMd5(data.getFileMd5());
        info.setUploadTime(data.getUploadTime());
        return info;
    }

}