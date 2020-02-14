package com.moinros.project.model.pojo;

import java.io.Serializable;

/**
 * 类注释:
 *
 * @Title: FileData
 * @Author Administrator
 * @Blog https://www.moinros.com
 * @Date 2020-02-14 19:17:26
 * @Version 1.0
 */
public class FileData implements Serializable {

    // 实现序列化接口
    private static final long serialVersionUID = 1L;

    /**
     * 注释：文件ID
     */
    private Integer fid;

    /**
     * 注释：快速检索码
     */
    private String fastCode;

    /**
     * 注释：文件名
     */
    private String fileName;

    /**
     * 注释：文件类型
     */
    private String fileType;

    /**
     * 注释：文件后缀
     */
    private String postfix;

    /**
     * 注释：网络访问路径
     */
    private String networkPath;

    /**
     * 注释：文件磁盘路径
     */
    private String diskPath;

    /**
     * 注释：文件完整路径
     */
    private String filePath;

    /**
     * 注释：文件MD5
     */
    private String fileMd5;

    /**
     * 注释：上传客户端IP地址
     */
    private String clientIp;

    /**
     * 注释：上传客户端操作系统
     */
    private String clientOs;

    /**
     * 注释：上传时间
     */
    private String uploadTime;

    // 构造方法
    public FileData() {
    }

    /**
     * 注释：获取 文件ID
     */
    public Integer getFid() {
        return fid;
    }

    /**
     * 注释：设置 文件ID
     */
    public void setFid(Integer fid) {
        this.fid = fid;
    }

    /**
     * 注释：获取 快速检索码
     */
    public String getFastCode() {
        return fastCode;
    }

    /**
     * 注释：设置 快速检索码
     */
    public void setFastCode(String fastCode) {
        this.fastCode = fastCode;
    }

    /**
     * 注释：获取 文件名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 注释：设置 文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 注释：获取 文件类型
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 注释：设置 文件类型
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * 注释：获取 文件后缀
     */
    public String getPostfix() {
        return postfix;
    }

    /**
     * 注释：设置 文件后缀
     */
    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }

    /**
     * 注释：获取 网络访问路径
     */
    public String getNetworkPath() {
        return networkPath;
    }

    /**
     * 注释：设置 网络访问路径
     */
    public void setNetworkPath(String networkPath) {
        this.networkPath = networkPath;
    }

    /**
     * 注释：获取 文件磁盘路径
     */
    public String getDiskPath() {
        return diskPath;
    }

    /**
     * 注释：设置 文件磁盘路径
     */
    public void setDiskPath(String diskPath) {
        this.diskPath = diskPath;
    }

    /**
     * 注释：获取 文件完整路径
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 注释：设置 文件完整路径
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 注释：获取 文件MD5
     */
    public String getFileMd5() {
        return fileMd5;
    }

    /**
     * 注释：设置 文件MD5
     */
    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    /**
     * 注释：获取 上传客户端IP地址
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * 注释：设置 上传客户端IP地址
     */
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    /**
     * 注释：获取 上传客户端操作系统
     */
    public String getClientOs() {
        return clientOs;
    }

    /**
     * 注释：设置 上传客户端操作系统
     */
    public void setClientOs(String clientOs) {
        this.clientOs = clientOs;
    }

    /**
     * 注释：获取 上传时间
     */
    public String getUploadTime() {
        return uploadTime;
    }

    /**
     * 注释：设置 上传时间
     */
    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }
}