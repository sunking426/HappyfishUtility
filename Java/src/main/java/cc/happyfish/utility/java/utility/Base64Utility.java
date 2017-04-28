package cc.happyfish.utility.java.utility;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * 作者:汪阳
 * 部门:计算机应用开发室
 * 联系:0553-8399022
 * 时间:2016-09-02
 * 说明:JDK1.8版本以后可以使用
 */
@SuppressWarnings("unchecked")
public class Base64Utility {
    /**
     * 编码
     *
     * @param str
     * @return String
     */
    public static String encode(String str) {
        try {
            return Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解码
     *
     * @param str
     * @return string
     */
    public static String decode(String str) {
        byte[] asBytes = Base64.getDecoder().decode(str);
        try {
            return new String(asBytes, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
