package com.moinros.project.model.dao;

import com.moinros.project.model.dao.provider.FileDataSqlProvider;
import com.moinros.project.model.pojo.FileData;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @作者: moinros  https://www.moinros.com
 * <p>
 * 注释: 根据JavaBean生成的mMapper接口
 * @Title: FileDataMapper
 * @author: Administrator
 * @date 2020-01-08 02:51:48
 */
@Mapper
public interface FileDataMapper {

    /**
     * 查询总记录数
     */
    @Select("SELECT count(*) FROM `file_data`")
    Integer selectTotalCount();

    /**
     * 分页查询文件数据
     *
     * @param start 开始数据编号
     * @param end   结束编码
     * @return List<FileData>文件数据集合
     */
    @SelectProvider(method = "selectFileByLimit", type = FileDataSqlProvider.class)
    public List<FileData> selectFileByLimit(int start, int end);

//    /**
//     * 根据'快速检索码'查询文件数据
//     *
//     * @param fastCode 快速检索码
//     * @return List<FileData>文件数据集合
//     */
//    @Select(FileDataSqlProvider.SELECT_SQL + " FROM `file_data` AS `fd` WHERE `fd`.`fast_code` = #{fastCode}")
//    List<FileData> selectFileByFastCode(String fastCode);
//
//    /**
//     * 根据'文件类型'查询文件数据
//     *
//     * @param file_type 文件类型
//     * @return List<FileData>文件数据集合
//     */
//    @Select(FileDataSqlProvider.SELECT_SQL + " FROM `file_data` AS `fd` WHERE `fd`.`file_type` = #{fileType}")
//    List<FileData> selectFileByFileType(String file_type);
//
//    /**
//     * 根据'文件后缀'查询文件数据
//     *
//     * @param postfix 文件后缀
//     * @return List<FileData>文件数据集合
//     */
//    @Select(FileDataSqlProvider.SELECT_SQL + " FROM `file_data` AS `fd` WHERE `fd`.`postfix` = #{postfix}")
//    List<FileData> selectFileByPostfix(String postfix);

    /**
     * 指定条件查询文件数据
     *
     * @param fileData 文件数据
     * @return List<FileData>文件数据集合
     */
    @SelectProvider(method = "selectFileDataSQL", type = FileDataSqlProvider.class)
    List<FileData> selectFileList(FileData fileData);

    /**
     * 指定文件数据查询文件详细信息
     *
     * @param fileData 文件数据
     * @return FileData文件详细数据
     */
    @SelectProvider(method = "selectFileDataSQL", type = FileDataSqlProvider.class)
    FileData selectFileData(FileData fileData);

    @InsertProvider(method = "insertFileDataSQL", type = FileDataSqlProvider.class)
    Integer insertFileData(FileData fileData);

    @UpdateProvider(method = "updateFileDataSQL", type = FileDataSqlProvider.class)
    Integer updateFileData(FileData fileData);

    @Delete(value = {"DELETE FROM file_data WHERE file_id = #{fid}"})
    Integer deleteFileData(Integer fid);

}