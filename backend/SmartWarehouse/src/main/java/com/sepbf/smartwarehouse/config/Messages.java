package com.sepbf.smartwarehouse.config;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;


public class Messages {
    static final String SUCCESS = "result.success";
    static final String BAD_REQUEST = "result.bad_request";
    static final String UNAUTHORIZED = "result.unauthorized";
    static final String FORBIDDEN = "result.forbidden";
    static final String NOT_FOUND = "result.not_found";
    static final String INTERNAL_SERVER_ERROR = "result.internal_server_error";

    private static final org.springframework.context.MessageSource MessageSource = new ResourceBundleMessageSource();

    static {
        ((ResourceBundleMessageSource) MessageSource).setBasenames("messages");
    }

}
