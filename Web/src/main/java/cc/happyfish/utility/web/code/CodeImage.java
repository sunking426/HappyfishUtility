package cc.happyfish.utility.web.code;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 作者:汪阳 <br>
 * 部门:计算机应用开发室 <br>
 * 联系:0553-8399022  <br>
 * 时间:2017/4/26 <br>
 * 说明:
 */
public class CodeImage {
    public final static String SECURITY_CODE_IMAGE = "_SECURITY_CODE_IMAGE_";//在Session中验证码名称

    public final static Integer WIDTH = 60;//图像宽度

    public final static Integer HEIGHT = 20;//图像高度

    /**
     * 直接在jsp页面生成验证码图片，并将结果写入到Session中
     *
     * @param session
     * @param response
     * @throws IOException
     */
    public static void getSecurityCodeImage(HttpSession session, HttpServletResponse response) throws IOException {
        //设置页面响应内容格式
        response.setContentType("image/jpeg");
        //设置页面不缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //获取验证码
        CodeImage securityCodeImage = new CodeImage();
        CodeResult securityCodeResult = securityCodeImage.getResult();
        //设置返回值
        session.setAttribute(SECURITY_CODE_IMAGE, securityCodeResult.getSecurityCode());
        response.resetBuffer();
        ImageIO.write(securityCodeResult.getBufferedImage(), "JPEG", response.getOutputStream());

    }

    private Color getRandColor(int fc, int bc) {//给定范围获得随机颜色
        Random random = new Random();
        if (fc > 255) fc = 255;
        if (bc > 255) bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    public CodeResult getResult() {
        // 在内存中创建图象
        int width = WIDTH, height = HEIGHT;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文
        Graphics g = image.getGraphics();
        //生成随机类
        Random random = new Random();
        // 设定背景色
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        //设定字体
        g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        //画边框
        //g.setColor(new Color());
        //g.drawRect(0,0,width-1,height-1);
        //随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        // 取随机产生的认证码(4位数字)
        //String rand = request.getParameter("rand");
        //rand = rand.substring(0,rand.indexOf("."));
        String sRand = "";
        for (int i = 0; i < 4; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
            // 将认证码显示到图象中
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));//调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
            g.drawString(rand, 13 * i + 6, 16);
        }
        // 图象生效
        g.dispose();
        // 返回数据
        CodeResult securityCodeResult = new CodeResult();
        securityCodeResult.setBufferedImage(image);
        securityCodeResult.setSecurityCode(sRand);
        return securityCodeResult;
    }
}
