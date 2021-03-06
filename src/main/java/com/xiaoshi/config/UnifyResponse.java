package com.xiaoshi.config;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName UnifyResponse
 * @Author xiaoshi
 * @Date 2021/1/4 14:02
 * @Description
 **/
public class UnifyResponse<T> implements Serializable {

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private int status;

    @Getter
    @Setter
    private T data;

    @Override
    public String toString() {
        return "{" +
                "message=" + message +
                ", code=" + code +
                ", status=" + status +
                ", data=" + data +
                '}';
    }

    public UnifyResponse(String message, int code, int status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public UnifyResponse(String message, int code, int status, T data) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public UnifyResponse(int code, int status) {
        this.code = code;
        this.status = status;
    }

    public static <T> UnifyResponse<T> success() {
        return new UnifyResponse<T>("成功",0, 200);
    }

    public static <T> UnifyResponse<T> success(T data) {
        return new UnifyResponse<T>("成功", 0, 200,data);
    }

    public static <T> UnifyResponse<T> error(String message) {
        return new UnifyResponse<T>(message, -1, 500);
    }
}
