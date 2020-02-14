package com.moinros.project.controller;

/**
 * 注释: 封装了客户端的参数基本信息的实体类
 *
 * @Author moinros
 * @Date 2020/2/14 21:59
 * @Verison 1.0
 */
public class ParamBinary {

    private String paramName; // 参数名
    private String fileType; // 文件类型
    private String fileName; // 文件名
    private boolean isFile; // 是否是文件
    private byte[] value; // 参数的二进制数据

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setIsFile(boolean file) {
        isFile = file;
    }

    public byte[] getValue() {
        return value;
    }

    public void setValue(byte[] value) {
        this.value = value;
    }
}
