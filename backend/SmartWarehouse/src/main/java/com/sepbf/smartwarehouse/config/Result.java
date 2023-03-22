package com.sepbf.smartwarehouse.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/**
 * 统一返回结果类，用于包装API接口的响应数据、状态码和提示信息
 *
 * @param <T> 返回结果的数据类型
 */
@Getter
@AllArgsConstructor
public class Result<T> {
    private final ResultCode code; // 结果编码
    private final String message;  // 提示信息
    private final T data;          // 返回的数据

    /**
     * 创建一个成功的结果对象
     *
     * @param data 返回的数据
     * @param <T>  数据类型
     * @return 成功的结果对象
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS, Messages.SUCCESS, data);
    }

    /**
     * 创建一个不包含数据的成功结果对象
     *
     * @return 成功的结果对象
     */
    public static Result<Void> success() {
        return new Result<>(ResultCode.SUCCESS, Messages.SUCCESS, null);
    }

    /**
     * 创建一个错误的结果对象
     *
     * @param code    结果编码
     * @param message 提示信息
     * @param data    返回的数据
     * @param <T>     数据类型
     * @return 错误的结果对象
     */
    public static <T> Result<T> error(ResultCode code, String message, T data) {
        return new Result<>(code, message, data);
    }

    /**
     * 创建一个不包含数据的错误结果对象
     *
     * @param code    结果编码
     * @param message 提示信息
     * @return 错误的结果对象
     */
    public static Result<Void> error(ResultCode code, String message) {
        return new Result<>(code, message, null);
    }



    /**
     * 结果编码枚举类，包含了常见的HTTP状态码
     */
    public enum ResultCode {
        SUCCESS(0),
        BAD_REQUEST(400),
        UNAUTHORIZED(401),
        FORBIDDEN(403),
        NOT_FOUND(404),
        INTERNAL_SERVER_ERROR(500);

        private final int code;

        ResultCode(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

}

    
