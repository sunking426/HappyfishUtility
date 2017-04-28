package cc.happyfish.utility.web.tag;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 作者:汪阳
 * 部门:计算机应用开发室
 * 联系:0553-8399022
 * 时间:2016-09-01
 * 说明:无
 */
public class ContentPageTag extends BodyTagSupport {

    private final String MASTER_FOLDER_PATH = "/";

    private final String MASTER_PAGE_SUFFIX = ".jsp";

    private String contentPlaceHolderId;

    private String materPageId;

    public String getMaterPageId() {
        return materPageId;
    }

    public void setMaterPageId(String materPageId) {
        this.materPageId = materPageId;
    }

    @Override
    public void doInitBody() throws JspException {
        try {
            this.pageContext.getRequest().setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        super.doInitBody();
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
        JspWriter out = pageContext.getOut();
        CustomResponse bufferedResponse = new CustomResponse((HttpServletResponse) this.pageContext.getResponse());
        try {
            //System.out.println("master url :"+this.getMasterPageUrl());
            //渲染页面
            this.pageContext.getServletContext().getRequestDispatcher(this.getMasterPageUrl()).include(this.pageContext.getRequest(), bufferedResponse);
            //System.out.println("master page content : " + bufferedResponse.getContent());
            out.clearBuffer();
            out.write(bufferedResponse.getContent());
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SKIP_PAGE;
    }

    private String getMasterPageUrl() {
        return this.MASTER_FOLDER_PATH + this.materPageId + this.MASTER_PAGE_SUFFIX;
    }
}
