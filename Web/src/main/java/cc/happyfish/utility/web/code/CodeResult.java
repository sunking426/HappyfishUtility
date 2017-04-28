package cc.happyfish.utility.web.code;

import java.awt.image.BufferedImage;

/**
 * 作者:汪阳 <br>
 * 部门:计算机应用开发室 <br>
 * 联系:0553-8399022  <br>
 * 时间:2017/4/26 <br>
 * 说明:
 */
public class CodeResult {

    private BufferedImage bufferedImage;//图像缓存

    private String securityCode;//验证码

    public CodeResult() {
    }

    public CodeResult(BufferedImage bufferedImage, String securityCode) {
        this.bufferedImage = bufferedImage;
        this.securityCode = securityCode;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }
}
