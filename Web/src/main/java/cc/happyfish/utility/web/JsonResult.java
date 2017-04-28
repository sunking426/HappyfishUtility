package cc.happyfish.utility.web;

/**
 * 作者:汪阳 <br>
 * 部门:计算机应用开发室 <br>
 * 联系:0553-8399022  <br>
 * 时间:2017/4/26 <br>
 * 说明:
 */
public class JsonResult<T> {
    private T data = null;
    private long dataLength = 1;//在分页时候使用
    private String message = "无";
    private String code = "000000";

    public JsonResult() {
    }

    public JsonResult(T data, long dataLength, String message, String code) {
        this.data = data;
        this.dataLength = dataLength;
        this.message = message;
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getDataLength() {
        return dataLength;
    }

    public void setDataLength(long dataLength) {
        this.dataLength = dataLength;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
