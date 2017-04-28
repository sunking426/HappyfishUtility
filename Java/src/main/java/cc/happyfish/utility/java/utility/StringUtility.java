package cc.happyfish.utility.java.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;


/**
 * 作者:汪阳
 * 部门:计算机应用开发室
 * 联系:0553-8399022
 * 时间:2016-03-30
 * 说明:无
 */
public class StringUtility {

    private static Logger logger = LoggerFactory.getLogger(StringUtility.class);

    /**
     * 判断字符串是否为空
     *
     * @param text
     * @return
     */
    public static boolean isEmpty(String text) {
        return (text == null || "".equals(text));
    }


    /**
     * 如果为空，返回默认值
     *
     * @param object
     * @param defaultValue
     * @return
     */
    public static String getDefault(Object object, String defaultValue) {
        if (object == null || isEmpty(object.toString())) {
            return defaultValue;
        } else {
            return object.toString();
        }
    }

    /**
     * 生成UUID字符串
     *
     * @return 32位的UUID密钥
     */
    public static String getUUID() throws Exception {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.substring(0, 8) + uuid.substring(9, 13) + uuid.substring(14, 18) + uuid.substring(19, 23) + uuid.substring(24);
        return uuid;
    }

}
