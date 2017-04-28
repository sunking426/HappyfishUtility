package cc.happyfish.utility.web.utility;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 作者:汪阳
 * 部门:计算机应用开发室
 * 联系:0553-8399022
 * 时间:2016-07-15
 * 说明:无
 */
public class FileUtility {

    private static Logger logger = LoggerFactory.getLogger(FileUtility.class);

    private static Integer getRandom(int max, int min) {
        return (int) (min + Math.random() * (max - min + 1));
    }

    /**
     * 文件上传
     *
     * @param request
     * @param formName
     * @param fileName
     * @param filePath
     * @throws IOException
     * @throws ServletException
     */
    public static void upload(HttpServletRequest request, String formName, String fileName, String filePath) throws IOException, ServletException {
        Part part = request.getPart(formName);
        String header = part.getHeader("content-disposition");

        String path = request.getServletContext().getRealPath("/") + filePath;
        String name = fileName.length() != 0 ? fileName : header.substring(header.lastIndexOf("\\") + 1, header.lastIndexOf("\""));

        part.write(path + "/" + name);
    }

    /**
     * 文件下载
     *
     * @param response
     * @param filePath
     * @param fileName
     * @throws IOException
     */
    public static void download(HttpServletResponse response, String filePath, String fileName) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] b = new byte[fileInputStream.available()];
        fileInputStream.read(b);
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + "");
        ServletOutputStream out = response.getOutputStream();
        out.write(b);
        out.flush();
        out.close();
    }

}
