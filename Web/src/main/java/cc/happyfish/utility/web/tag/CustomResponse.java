package cc.happyfish.utility.web.tag;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 作者:汪阳
 * 部门:计算机应用开发室
 * 联系:0553-8399022
 * 时间:2016-09-01
 * 说明:无
 */
public class CustomResponse extends HttpServletResponseWrapper {

    private StringWriter strWriter = new StringWriter();

    private PrintWriter out = new PrintWriter(strWriter);

    public CustomResponse(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return out;
    }

    public String getContent() {
        return strWriter.toString();
    }
}
