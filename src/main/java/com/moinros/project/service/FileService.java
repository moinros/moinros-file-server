package com.moinros.project.service;

import com.moinros.project.model.pojo.FileData;

/**
 * 注释: 关于文件的业务处理层
 *
 * @Author moinros
 * @Date 2020/2/14 15:56
 * @Verison 1.0
 */
public interface FileService {

    /**
     * 保存文件数据到数据库
     *
     * @param fileData 文件数据
     * @return boolean
     */
    boolean saveFile(FileData fileData);

}
