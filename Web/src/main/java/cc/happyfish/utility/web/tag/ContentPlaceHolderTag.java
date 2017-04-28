package cc.happyfish.utility.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * 作者:汪阳
 * 部门:计算机应用开发室
 * 联系:0553-8399022
 * 时间:2016-09-01
 * 说明:无
 */
public class ContentPlaceHolderTag extends TagSupport {
    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        Object obj = this.pageContext.getRequest().getAttribute(this.getId());
        try {
            if (obj != null)
                out.write(obj.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

}
