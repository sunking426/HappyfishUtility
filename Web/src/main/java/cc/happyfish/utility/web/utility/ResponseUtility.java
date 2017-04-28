package cc.happyfish.utility.web.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者:汪阳 <br>
 * 部门:计算机应用开发室 <br>
 * 联系:0553-8399022  <br>
 * 时间:2017/4/26 <br>
 * 说明:
 */
public class ResponseUtility {

    private static Logger logger = LoggerFactory.getLogger(ResponseUtility.class);

    /**
     * 客户端返回字符串
     *
     * @param response
     * @param string
     * @return
     */
    protected void renderJson(HttpServletResponse response,
                              String string,
                              String type) {
        try {
            response.reset();
            response.setContentType(type);
            response.setCharacterEncoding("utf-8");
            //解决跨域问题
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.getWriter().print(string);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }
}
