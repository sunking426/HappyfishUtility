package cc.happyfish.utility.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

/**
 * 作者:汪阳
 * 部门:计算机应用开发室
 * 联系:0553-8399022
 * 时间:2016-09-01
 * 说明:无
 */
public class MasterPageTag extends BodyTagSupport {

    @Override
    public int doAfterBody() throws JspException {
        return SKIP_BODY;
    }

    @Override
    public int doStartTag() throws JspException {
        return EVAL_BODY_BUFFERED;
    }

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        if (bodyContent != null) {
            if (out instanceof BodyContent) {
                out = ((BodyContent) out).getEnclosingWriter();
            }
        }
        String content = this.bodyContent.getString();
        try {
            bodyContent.clear();
            out.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_PAGE;
    }
}
