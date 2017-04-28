package cc.happyfish.utility.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

/**
 * 作者:汪阳
 * 部门:计算机应用开发室
 * 联系:0553-8399022
 * 时间:2016-09-01
 * 说明:无
 */
public class ContentTag extends BodyTagSupport {

    private String contentPlaceHolderId;

    public String getContentPlaceHolderId() {
        return contentPlaceHolderId;
    }

    public void setContentPlaceHolderId(String contentPlaceHolderId) {
        this.contentPlaceHolderId = contentPlaceHolderId;
    }

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
        String content = this.bodyContent.getString();
        try {
            this.pageContext.getRequest().setAttribute(this.getContentPlaceHolderId(), content);
            this.bodyContent.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;//default
    }

}
