package com.sepbf.smartwarehouse.config;

/**
 * 统一返回结果类
 * @param <T> 返回结果的数据类型
 */
public class Result<T> {
    private String code;  // 结果编码
    private String msg;   // 成功或失败的提示
    private T data;       // 返回的数据

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }

    /**
     * 构造函数
     * @param data 返回结果的数据
     */
    public Result(T data) {
        this.data = data;
    }

    /**
     * 成功时的静态工厂方法，不带数据
     * @return Result<?> 返回结果
     */
    public static Result<?> success() {
        Result<?> result = new Result<>();
        result.setCode("0");   // 成功时的结果编码
        result.setMsg("成功");  // 成功时的提示信息
        return result;
    }

    /**
     * 成功时的静态工厂方法，带数据
     * @param data 返回结果的数据
     * @param <T> 返回结果的数据类型
     * @return Result<T> 返回结果
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(data);
        result.setCode("0");   // 成功时的结果编码
        result.setMsg("成功");  // 成功时的提示信息
        return result;
    }

    /**
     * 失败时的静态工厂方法
     * @param code 失败时的结果编码
     * @param msg 失败时的提示信息
     * @return Result<?> 返回结果
     */
    public static Result<?> error(String code, String msg) {
        Result<?> result = new Result<>();
        result.setCode(code);  // 失败时的结果编码
        result.setMsg(msg);    // 失败时的提示信息
        return result;
    }
}
