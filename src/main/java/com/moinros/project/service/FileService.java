package com.moinros.project.service;

import com.moinros.project.model.pojo.FileData;
import com.moinros.project.tool.PageBean;

import java.util.List;

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

    /**
     * 查询指定页码的文件数据
     *
     * @param pageNo   指定页码数
     * @param dataSize 每页显示的数据条数
     * @return PageBean<FileData>封装了分页数据和查询出来的文件数据
     */
    PageBean<FileData> findFileByPage(int pageNo, int dataSize);

    /**
     * 根据快速检索码查询文件数据
     *
     * @param fastCode 检索码
     * @return List<FileData>文件数据集合
     */
    List<FileData> findFileByFastCode(String fastCode);

    /**
     * 根据文件类型查询文件
     *
     * @param fileType 文件类型(例如image/jpg、image/png)
     * @return List<FileData>文件数据集合
     */
    List<FileData> findFileByType(String fileType);

    /**
     * 根据文件后缀查询文件
     *
     * @param postfix 文件后缀名
     * @return List<FileData>文件数据集合
     */
    List<FileData> findFileByPostfix(String postfix);

    /**
     * 指定多个条件查询文件数据
     *
     * @param fileData 文件信息
     * @return List<FileData>文件数据集合
     */
    List<FileData> findFileList(FileData fileData);

    /**
     * 根据指定的文件属性查询文件详细数据
     *
     * @param data file属性
     * @return FileData文件详细数据
     */
    FileData findFile(FileData data);

}
