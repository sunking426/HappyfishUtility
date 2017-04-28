package cc.happyfish.utility.java.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * 作者:汪阳 <br>
 * 部门:计算机应用开发室 <br>
 * 联系:0553-8399022  <br>
 * 时间:2017/3/6 <br>
 * 说明:
 */
public class Md5Utility {

    protected static Logger logger = LoggerFactory.getLogger(Md5Utility.class);

    public static String getHash(String str) throws Exception {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes("UTF-8"));
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            String errorMsg = "MD5加密出现错误";
            logger.error(errorMsg);
            throw new Exception(errorMsg);
        }
    }
}
