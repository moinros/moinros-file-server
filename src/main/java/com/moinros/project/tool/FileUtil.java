package com.moinros.project.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 注释:
 *
 * @Author moinros
 * @Date 2020/2/14 21:54
 * @Verison 1.0
 */
public class FileUtil {
    private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 读取 InputStream 流中的二进制数据并存到byte[]数组中
     *
     * @param inputStream IO流
     * @return byte[]读取完成的二进制数据
     * @throws IOException 读取数据时可能发生异常
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    /**
     * 将指定的 byte[] 格式的二进制数据,写入磁盘的指定路径
     *
     * @param contents byte[] 格式的二进制数据
     * @param filePath 文件完整路径(包括文件名和后缀)
     * @return boolean 文件写入完成后返回true,否则返回false
     */
    public static boolean byteToFile(byte[] contents, String filePath) {
        boolean flag = false;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream output = null;
        try {
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(contents);
            bis = new BufferedInputStream(byteInputStream);
            File file = new File(filePath);
            // 获取文件的父路径字符串
            File path = file.getParentFile();
            if (!path.exists()) {
                LOG.debug("文件夹不存在！ 创建 - path=" + path);
                boolean isCreated = path.mkdirs();
                if (!isCreated) {
                    LOG.error("创建文件夹失败！ 创建 - path=" + path);
                }
            }
            fos = new FileOutputStream(file);
            // 实例化OutputString 对象
            output = new BufferedOutputStream(fos);
            byte[] buffer = new byte[1024];
            int length = bis.read(buffer);
            while (length != -1) {
                output.write(buffer, 0, length);
                length = bis.read(buffer);
            }
            output.flush();
            flag = true;
        } catch (Exception e) {
            LOG.error("输出文件流时抛异常！ filePath=" + filePath);
            LOG.error(e.toString());
        } finally {
            try {
                bis.close();
                fos.close();
                output.close();
            } catch (IOException e0) {
                // e0.printStackTrace();
                LOG.error("文件处理失败！ filePath=" + filePath);
                LOG.error(e0.toString());
            }
        }
        return flag;
    }

    /**
     * 读取指定路径下的所有文件
     *
     * @param path 文件路径
     * @return File[]
     */
    public static File[] readFiles(String path) {
        File file = new File(path);
        File[] temp = file.listFiles();
        if (temp == null || temp.length <= 0) {
            return null;
        }
        return temp;
    }

}
