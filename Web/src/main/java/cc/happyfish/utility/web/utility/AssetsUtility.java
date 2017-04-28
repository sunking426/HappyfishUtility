package cc.happyfish.utility.web.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 作者: 汪阳 <br>
 * 部门: 计算机应用开发室 <br>
 * 联系: 0553-8399022 <br>
 * 时间: 2016-10-09 <br>
 * 说明: 网站资源文件读取。网站根目录:
 */
public class AssetsUtility {

    private static Logger logger = LoggerFactory.getLogger(AssetsUtility.class);

    /**
     * 获取root目录
     *
     * @return
     */
    public static String getRootPath(HttpServletRequest request) {
        return request.getSession().getServletContext().getRealPath("");
    }

    /**
     * 获取classes目录
     *
     * @return
     */
    public static String getClassesPath(HttpServletRequest request) {
        return getRootPath(request) + "WEB-INF/classes/";
    }

    /**
     * 把txt文本转成字符串
     *
     * @param path
     * @return
     */
    public static String convertTxt2String(String path) {
        File file = new File(path);
        StringBuilder result = new StringBuilder();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader br = new BufferedReader(inputStreamReader);//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

}
