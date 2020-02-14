package com.moinros.project.model.dao;

import com.moinros.project.model.dao.provider.FileDataSqlProvider;
import com.moinros.project.model.pojo.FileData;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *
 * @作者: moinros  https://www.moinros.com
 *
 * 注释: 根据JavaBean生成的mMapper接口
 *
 * @Title: FileDataMapper
 * @author: Administrator
 * @date 2020-01-08 02:51:48
 */
@Mapper
public interface FileDataMapper {

	@SelectProvider(method = "selectAllFileDataSQL", type = FileDataSqlProvider.class)
	public List<FileData> selectAllFileData();

	@SelectProvider(method = "selectFileDataSQL", type = FileDataSqlProvider.class)
	public List<FileData> selectFileData(FileData fileData);

	@InsertProvider(method = "insertFileDataSQL", type = FileDataSqlProvider.class)
	public Integer insertFileData(FileData fileData);

	@UpdateProvider(method = "updateFileDataSQL", type = FileDataSqlProvider.class)
	public Integer updateFileData(FileData fileData);

	@Delete(value = { "DELETE FROM file_data WHERE file_id = #{fid}" })
	public Integer deleteFileData(Integer fid);

}