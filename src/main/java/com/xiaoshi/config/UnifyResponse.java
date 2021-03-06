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
    private T message;

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private int status;

    @Override
    public String toString() {
        return "{" +
                "message=" + message +
                ", code=" + code +
                ", status=" + status +
                '}';
    }

    public UnifyResponse(T message, int code, int status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public UnifyResponse(int code, int status) {
        this.code = code;
        this.status = status;
    }

    public static <T> UnifyResponse<T> success() {
        return success(null);
    }

    public static <T> UnifyResponse<T> success(T message) {
        return new UnifyResponse<T>(message, 0, 200);
    }

    public static <T> UnifyResponse<T> error(T message) {
        return new UnifyResponse<T>(message, -1, 500);
    }
}
