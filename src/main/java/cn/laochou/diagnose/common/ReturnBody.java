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

    private int status;

    private String message;

    private T result;

    public ReturnBody(int status, String message) {
        this(status, message, null);
    }

    public static ReturnBody<Object> getSuccessReturnBody(String message) {
        return new ReturnBody<>(200, message);
    }

    public static <T> ReturnBody<T> getSuccessReturnBody(String message, T result) {
        return new ReturnBody<>(200, message, result);
    }

    public static ReturnBody<Object> getErrorReturnBody(String message) {
        return new ReturnBody<>(500, message);
    }


    public static <T> ReturnBody<T> getErrorReturnBody(String message, T result) {
        return new ReturnBody<>(500, message, result);
    }


    public static ReturnBody<Object> getParamErrorReturnBody(String message) {
        return new ReturnBody<>(300, message);
    }

}
