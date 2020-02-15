package com.moinros.project.service;

import com.moinros.project.model.dao.FileDataMapper;
import com.moinros.project.model.pojo.FileData;
import com.moinros.project.tool.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private static final Logger LOG = LoggerFactory.getLogger(FileServiceImpl.class);

    @Autowired
    private FileDataMapper mapper;

    @Override
    public boolean saveFile(FileData fileData) {
        Integer num = mapper.insertFileData(fileData);
        if (num != null && num.intValue() > 0) {
            LOG.info("保存文件数据 - 成功！ FilePath=" + fileData.getFilePath() + ";\tNetworkPath=" + fileData.getNetworkPath());
            return true;
        } else {
            LOG.info("保存文件数据 - 失败！ FilePath=" + fileData.getFilePath() + ";\tNetworkPath=" + fileData.getNetworkPath());
            return false;
        }
    }

    @Override
    public PageBean<FileData> findFileByPage(int pageNo, int dataSize) {
        if (dataSize > 0) {
            Integer count = mapper.selectTotalCount();
            if (count != null && count.intValue() > 0) {
                PageBean<FileData> bean = new PageBean(pageNo, dataSize, count);
                List<FileData> li = mapper.selectFileByLimit(bean.getStartNo(), bean.getEndNo());
                if (li != null && li.size() > 0) {
                    bean.setList(li);
                    return bean;
                } else {
                    return null;
                }
            }
        } else {
            LOG.error("分页查询数据！ DataSize小于OR等于0！");
        }
        return null;
    }

    @Override
    public List<FileData> findFileByFastCode(String fastCode) {
        FileData data = new FileData();
        data.setFastCode(fastCode);
        List li = mapper.selectFileList(data);
        return li != null && li.size() > 0 ? li : null;
    }

    @Override
    public List<FileData> findFileByType(String fileType) {
        FileData data = new FileData();
        data.setFileType(fileType);
        List li = mapper.selectFileList(data);
        return li != null && li.size() > 0 ? li : null;
    }

    @Override
    public List<FileData> findFileByPostfix(String postfix) {
        FileData data = new FileData();
        data.setPostfix(postfix);
        List li = mapper.selectFileList(data);
        return li != null && li.size() > 0 ? li : null;
    }

    @Override
    public List<FileData> findFileList(FileData fileData) {
        return mapper.selectFileList(fileData);
    }

    @Override
    public FileData findFile(FileData data) {
        return mapper.selectFileData(data);
    }
}
