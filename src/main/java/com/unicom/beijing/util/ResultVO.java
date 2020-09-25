package com.unicom.beijing.util;

public class ResultVO {
    private String message;
    private String code;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultVO(){

    }

    public ResultVO(String message,String code,Object data){
        this.message = message;
        this.code = code;
        this.data = data;
    }

    @Override
    public String toString(){
        return "ResultVO{"+
                "message" + message + '\'' +
                ",code" + code + '\'' +
                ",data" + data + '\'' +
                "}";
    }
}
