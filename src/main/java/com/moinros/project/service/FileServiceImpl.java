package com.moinros.project.service;

import com.moinros.project.model.dao.FileDataMapper;
import com.moinros.project.model.pojo.FileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 注释:
 *
 * @Author moinros
 * @Date 2020/2/14 22:48
 * @Verison 1.0
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDataMapper mapper;

    @Override
    public boolean saveFile(FileData fileData) {
       Integer num =   mapper.insertFileData(fileData);
        return  num!=null&& num.intValue()>0 ? true:false;
    }
}
