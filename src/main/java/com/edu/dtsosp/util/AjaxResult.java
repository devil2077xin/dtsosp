package com.edu.dtsosp.util;

import java.util.Map;

/**
 * @Classname AjaxResult
 * @Description ajax json 返回数据
 */
public class AjaxResult {
    private boolean success;
    private String message;
    private String imgurl;
    private String type;
    private Map data;
    private String status;
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg() { return msg; }

    public void setMsg(String msg) { this.msg = msg; }

    public Map getData() { return data; }

    public void setData(Map data) { this.data = data; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

}
