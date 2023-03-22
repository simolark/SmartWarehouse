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
        return new Result<>(ResultCode.SUCCESS, Messages.SUCCESS.getMessage(), data);
    }

    /**
     * 创建一个不包含数据的成功结果对象
     *
     * @return 成功的结果对象
     */
    public static Result<Void> success() {
        return new Result<>(ResultCode.SUCCESS, Messages.SUCCESS.getMessage(), null);
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
     * 根据异常创建一个错误的结果对象
     *
     * @param e   异常
     * @param <T> 数据类型
     * @return 错误的结果对象
     */
    public static <T> Result<T> error(Exception e) {
        return new Result<>(ResultCode.INTERNAL_SERVER_ERROR, e.getMessage(), null);
    }

    /**
     * 根据异常和结果编码创建一个错误的结果对象
     *
     * @param code 结果编码
     * @param e    异常
     * @param <T>  数据类型
     * @return 错误的结果对象
     */
    public static <T> Result<T> error(ResultCode code, Exception e) {
        return new Result<>(code, e.getMessage(), null);
    }

    /**
     * 根据结果编码、语言环境和参数创建一个错误的结果对象
     *
     * @param code   结果编码
     * @param locale 语言环境
     * @param args   参数
     * @param <T>    数据类型
     * @return 错误的结果对象
     */
    public static <T> Result<T> error(ResultCode code, Locale locale, Object... args) {
        String message = Messages.getMessage(code, locale, args);
        return new Result<>(code, message, null);  
    }

    /**
     * 创建一个通用的失败结果对象
     *
     * @param <T> 数据类型
     * @return 失败的结果对象
     */
    public static <T> Result<T> failure() {
        return new Result<>(ResultCode.INTERNAL_SERVER_ERROR, Messages.INTERNAL_SERVER_ERROR.getMessage(), null);
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

/**
 * 提示信息枚举类，用于管理和获取提示信息
 */
static class Messages {
    static final String SUCCESS = "result.success";
    static final String BAD_REQUEST = "result.bad_request";
    static final String UNAUTHORIZED = "result.unauthorized";
    static final String FORBIDDEN = "result.forbidden";
    static final String NOT_FOUND = "result.not_found";
    static final String INTERNAL_SERVER_ERROR = "result.internal_server_error";

    private static final MessageSource MessageSource = new ResourceBundleMessageSource();

    static {
        ((ResourceBundleMessageSource) MessageSource).setBasenames("messages");
    }

    /**
     * 根据结果编码、语言环境和参数获取提示信息
     *
     * @param code   结果编码
     * @param locale 语言环境
     * @param args   参数
     * @return 提示信息
     */
    public static String getMessage(ResultCode code, Locale locale, Object... args) {
        return MessageSource.getMessage(code.name().toLowerCase(), args, locale);
    }

    /**
     * 根据键和语言环境获取提示信息
     *
     * @param key    提示信息键
     * @param locale 语言环境
     * @return 提示信息
     */
    public static String getMessage(String key, Locale locale) {
        return MessageSource.getMessage(key, null, key, locale);
    }
}

    
