package com.roiocam.designpattern.ioc.bean.exception;

/**
 * 找不到类似信息的Bean
 *
 * @author Andy Chen
 * @date 2020/1/7 下午6:02
 */
public class NoSuchBeanDefinitionException extends BeansException {
    private final String beanName;

    public NoSuchBeanDefinitionException(String name) {
        super("No bean named '" + name + "' available");
        this.beanName = name;
    }
}
