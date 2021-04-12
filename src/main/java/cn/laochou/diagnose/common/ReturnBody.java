package cn.laochou.diagnose.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义返回体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnBody<T> {

    private int code;

    private String msg;

    private T data;

    public ReturnBody(int code, String msg) {
        this(code, msg, null);
    }

    public static ReturnBody<Object> getSuccessReturnBody(String msg) {
        return new ReturnBody<>(0, msg);
    }

    public static <T> ReturnBody<T> getSuccessReturnBody(String msg, T data) {
        return new ReturnBody<>(0, msg, data);
    }

    public static ReturnBody<Object> getErrorReturnBody(String message) {
        return new ReturnBody<>(500, message);
    }


    public static <T> ReturnBody<T> getErrorReturnBody(String msg, T data) {
        return new ReturnBody<>(500, msg, data);
    }


    public static ReturnBody<Object> getParamErrorReturnBody(String msg) {
        return new ReturnBody<>(300, msg);
    }
    
}
