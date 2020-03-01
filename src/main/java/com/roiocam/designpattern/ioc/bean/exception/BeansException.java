package com.roiocam.designpattern.ioc.bean.exception;

/**
 * Bean异常
 *
 * @author Andy Chen
 * @date 2020/1/7 下午6:02
 */
public class BeansException extends RuntimeException {
    public BeansException(String message) {
        super(message);
    }
}
