package com.moinros.project.tool;

import com.moinros.project.controller.ParamBinary;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 注释:
 *
 * @Author moinros
 * @Date 2020/2/14 21:53
 * @Verison 1.0
 */
public class WebUtil {

    public static List<ParamBinary> getParameter(HttpServletRequest request) throws IOException, ServletException {
        // Servlet3.0新增了request.getParts()/getPart(String filename) api，
        // 用于获取使用multipart/form-data格式传递的http请求的请求体，通常用于获取上传文件。
        Collection<Part> parts = request.getParts();
        // 使用Iterator迭代器的方式迭代Collection<Part>集合中的数据
        Iterator<Part> iterator = parts.iterator();
        // hasNext()方法没有指针下移操作，用于判断是否存在下一个元素

        List<ParamBinary> list = null;

        while (iterator.hasNext()) {

            // next()方法指针下移，并返回该指针所指向的元素
            Part part = iterator.next();

            // part.getName() 获取的是表单中 input的 name属性
            // part.getContentType() 如果表单中有文件，这个方法就可以获取文件的类型，如果只是普通的字符串那么此方法返回null
            // part.getSubmittedFileName() 获取的是文件名字，如果只是普通的字符串那么此方法返回null
            // part.getInputStream() 流数据，表单中的文件或者字符串值都在通过这个方法读取到

            ParamBinary param = new ParamBinary();

            param.setParamName(part.getName()); // 获取参数名
            param.setFileType(part.getContentType());// 获取文件类型
            param.setFileName(part.getSubmittedFileName());// 获取文件名

            // 将 readInputStream 中的二进制数据读取到 byte[] 数组中
            byte[] value = FileUtil.readInputStream(part.getInputStream());
            param.setValue(value);

            // 通过 fileType 和 fileName 的值判断当前迭代的元素是否为文件
            if (param.getFileType() != null && param.getFileName() != null) {
                param.setIsFile(true);
            } else {
                param.setIsFile(false);
            }

            if (list == null) list = new ArrayList<>();
            list.add(param);
        }

        return list;

    }

}
