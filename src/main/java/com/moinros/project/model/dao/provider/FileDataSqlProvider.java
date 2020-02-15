package com.moinros.project.model.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import com.moinros.project.model.pojo.FileData;

/**
 * @说明: 自动生成的与Dao层FileDataMapper接口对应的Provider类。
 * @作者: moinros  https://www.moinros.com
 * <p>
 * 注释: 根据FileData生成与Mapper接口对应的动态SQL的Provider.Java类
 * @Title: FileDataSqlProvider
 * @author: Administrator
 * @date 2020-02-14 19:17:26
 */
public class FileDataSqlProvider {

    public static final String SELECT_SQL =
            "`fd`.`fid` AS `fid`, "
			+ "`fd`.`fast_code` AS `fastCode`, "
			+ "`fd`.`file_name` AS `fileName`, "
			+ "`fd`.`file_type` AS `fileType`, "
			+ "`fd`.`postfix` AS `postfix`, "
			+ "`fd`.`network_path` AS `networkPath`, "
			+ "`fd`.`disk_path` AS `diskPath`, "
			+ "`fd`.`file_path` AS `filePath`, "
			+ "`fd`.`file_md5` AS `fileMd5`, "
			+ "`fd`.`client_ip` AS `clientIp`, "
			+ "`fd`.`client_os` AS `clientOs`, "
			+ "`fd`.`upload_time` AS `uploadTime`";

    public String selectFileByLimit() {
        return new SQL() {
            {
                SELECT(SELECT_SQL);
                FROM("`file_data` AS `fd`");
                ORDER_BY("`fd`.`upload_time` DESC");
                LIMIT("#{start}, #{end}");
            }
        }.toString();
    }

    public String selectFileDataSQL(FileData fileData) {
        return new SQL() {
            {
                SELECT(SELECT_SQL);
                FROM("`file_data` AS `fd`");
                if (fileData.getFid() != null) {
                    WHERE("`fd`.`fid` = #{fid}");
                }
                if (fileData.getFastCode() != null) {
                    WHERE("`fd`.`fast_code` = #{fastCode}");
                }
                if (fileData.getFileName() != null) {
                    WHERE("`fd`.`file_name` = #{fileName}");
                }
                if (fileData.getFileType() != null) {
                    WHERE("`fd`.`file_type` = #{fileType}");
                }
                if (fileData.getPostfix() != null) {
                    WHERE("`fd`.`postfix` = #{postfix}");
                }
                if (fileData.getNetworkPath() != null) {
                    WHERE("`fd`.`network_path` = #{networkPath}");
                }
                if (fileData.getDiskPath() != null) {
                    WHERE("`fd`.`disk_path` = #{diskPath}");
                }
                if (fileData.getFilePath() != null) {
                    WHERE("`fd`.`file_path` = #{filePath}");
                }
                if (fileData.getFileMd5() != null) {
                    WHERE("`fd`.`file_md5` = #{fileMd5}");
                }
                if (fileData.getClientIp() != null) {
                    WHERE("`fd`.`client_ip` = #{clientIp}");
                }
                if (fileData.getClientOs() != null) {
                    WHERE("`fd`.`client_os` = #{clientOs}");
                }
                if (fileData.getUploadTime() != null) {
                    WHERE("`fd`.`upload_time` = #{uploadTime}");
                }
            }
        }.toString();
    }

    public String insertFileDataSQL(FileData fileData) {
        return new SQL() {
            {
                INSERT_INTO("`file_data`");
                if (fileData.getFid() != null) {
                    VALUES("`fid`", "#{fid}");
                }
                if (fileData.getFastCode() != null) {
                    VALUES("`fast_code`", "#{fastCode}");
                }
                if (fileData.getFileName() != null) {
                    VALUES("`file_name`", "#{fileName}");
                }
                if (fileData.getFileType() != null) {
                    VALUES("`file_type`", "#{fileType}");
                }
                if (fileData.getPostfix() != null) {
                    VALUES("`postfix`", "#{postfix}");
                }
                if (fileData.getNetworkPath() != null) {
                    VALUES("`network_path`", "#{networkPath}");
                }
                if (fileData.getDiskPath() != null) {
                    VALUES("`disk_path`", "#{diskPath}");
                }
                if (fileData.getFilePath() != null) {
                    VALUES("`file_path`", "#{filePath}");
                }
                if (fileData.getFileMd5() != null) {
                    VALUES("`file_md5`", "#{fileMd5}");
                }
                if (fileData.getClientIp() != null) {
                    VALUES("`client_ip`", "#{clientIp}");
                }
                if (fileData.getClientOs() != null) {
                    VALUES("`client_os`", "#{clientOs}");
                }
                if (fileData.getUploadTime() != null) {
                    VALUES("`upload_time`", "#{uploadTime}");
                }
            }
        }.toString();
    }

    public String updateFileDataSQL(FileData fileData) {
        return new SQL() {
            {
                UPDATE("file_data");
                if (fileData.getFastCode() != null) {
                    SET("`fast_code` = #{fastCode}");
                }
                if (fileData.getFileName() != null) {
                    SET("`file_name` = #{fileName}");
                }
                if (fileData.getFileType() != null) {
                    SET("`file_type` = #{fileType}");
                }
                if (fileData.getPostfix() != null) {
                    SET("`postfix` = #{postfix}");
                }
                if (fileData.getNetworkPath() != null) {
                    SET("`network_path` = #{networkPath}");
                }
                if (fileData.getDiskPath() != null) {
                    SET("`disk_path` = #{diskPath}");
                }
                if (fileData.getFilePath() != null) {
                    SET("`file_path` = #{filePath}");
                }
                if (fileData.getFileMd5() != null) {
                    SET("`file_md5` = #{fileMd5}");
                }
                if (fileData.getClientIp() != null) {
                    SET("`client_ip` = #{clientIp}");
                }
                if (fileData.getClientOs() != null) {
                    SET("`client_os` = #{clientOs}");
                }
                if (fileData.getUploadTime() != null) {
                    SET("`upload_time` = #{uploadTime}");
                }
                WHERE("`fid` = #{fid}");
            }
        }.toString();
    }

}