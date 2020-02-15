package com.moinros.project.result.vo;

/**
 * 注释: 封装用于回显的文件数据
 *
 * @Author moinros
 * @Date 2020/2/15 17:14
 * @Verison 1.0
 */
public class WebFileInfo {

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
     * 注释：文件MD5
     */
    private String fileMd5;

    /**
     * 注释：上传时间
     */
    private String uploadTime;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFastCode() {
        return fastCode;
    }

    public void setFastCode(String fastCode) {
        this.fastCode = fastCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getPostfix() {
        return postfix;
    }

    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }

    public String getNetworkPath() {
        return networkPath;
    }

    public void setNetworkPath(String networkPath) {
        this.networkPath = networkPath;
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }
}
