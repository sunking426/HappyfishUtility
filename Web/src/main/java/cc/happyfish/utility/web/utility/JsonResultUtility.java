package cc.happyfish.utility.web.utility;

import cc.happyfish.utility.web.JsonResult;

/**
 * 作者:汪阳 <br>
 * 部门:计算机应用开发室 <br>
 * 联系:0553-8399022  <br>
 * 时间:2017/4/26 <br>
 * 说明:
 */
@SuppressWarnings("unchecked")
public class JsonResultUtility {

    /**
     * 返回JsonResult
     *
     * @param t
     * @param dataLength
     * @param <T>
     * @return
     */
    public static <T> JsonResult renderJsonResult(T t,
                                                  long dataLength) {
        JsonResult jsonResult = new JsonResult<T>();
        jsonResult.setData(t);
        jsonResult.setDataLength(dataLength);
        return jsonResult;
    }

    /**
     * 返回JsonResult
     *
     * @param t
     * @param dataLength
     * @param message
     * @param code
     * @param <T>
     * @return
     */
    public static <T> JsonResult renderJsonResult(T t,
                                                  long dataLength,
                                                  String message,
                                                  String code) {
        JsonResult<T> jsonResult = new JsonResult<T>();
        jsonResult.setData(t);
        jsonResult.setDataLength(dataLength);
        jsonResult.setMessage(message);
        jsonResult.setCode(code);
        return jsonResult;
    }
}
