package cc.happyfish.utility.web.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 作者:汪阳
 * 部门:计算机应用开发室
 * 联系:0553-8399022
 * 时间:2016-03-30
 * 说明:无
 */
@SuppressWarnings("unchecked")
public class CookieUtility {

    private static final String CODE = "UTF-8";
    private static Logger logger = LoggerFactory.getLogger(CookieUtility.class);

    public static void removeCookie(HttpServletResponse response, String name) {
        Cookie userCookie = new Cookie(name, null);
        userCookie.setMaxAge(0);
        userCookie.setPath("/");
        response.addCookie(userCookie);
    }

    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String name, String value, int expire) {
        String encode = null;//使用base64编码
        try {
            encode = URLEncoder.encode(value, CODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Cookie userCookie = new Cookie(name, encode);
        userCookie.setMaxAge(expire);
        userCookie.setPath(request.getContextPath() + "/");
        response.addCookie(userCookie);
    }

    public static String getCookie(HttpServletRequest request, String name, boolean isBase64) {
        Map<String, Cookie> cookieMap = CookieUtility.readCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = cookieMap.get(name);
            if (isBase64 != true) return cookie.getValue();
            String decode = null;//使用base64解码
            try {
                decode = URLDecoder.decode(cookie.getValue(), CODE);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return decode;
        } else {
            return null;
        }
    }

    public static Map readCookieMap(HttpServletRequest request) {
        Map cookieMap = new HashMap();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    public static String encodeCookieValue(String text) {
        try {
            return URLEncoder.encode(text, CODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
