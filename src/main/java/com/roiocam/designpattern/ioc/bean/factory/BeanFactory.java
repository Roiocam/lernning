package com.roiocam.designpattern.ioc.bean.factory;

import com.roiocam.designpattern.ioc.bean.exception.NoSuchBeanDefinitionException;

/**
 * 生产和管理Bean
 * <p>
 *     解释为方法则是获取Bean的各种信息
 * </p>
 *
 * @author Andy Chen
 * @date 2020/1/7 下午5:53
 */
public interface BeanFactory {
    /**
     * 获取名称Bean
     * @param var
     * @return
     */
    Object getBean(String var);

    /**
     * 根据类型获取Bean
     * @param var1
     * @param var2
     * @param <T>
     * @return
     */
    <T> T getBean(String var1, Class<T> var2);

    /**
     * 容器是否包含Bean
     * @param var1
     * @return
     * @throws NoSuchBeanDefinitionException
     */
    boolean containsBean(String var1) throws NoSuchBeanDefinitionException;

    /**
     * 是否为单例
     * @param var1
     * @return
     * @throws NoSuchBeanDefinitionException
     */
    boolean isSingleton(String var1) throws NoSuchBeanDefinitionException;

    /**
     * 是否多例
     * @param var1
     * @return
     * @throws NoSuchBeanDefinitionException
     */
    boolean isPrototype(String var1) throws NoSuchBeanDefinitionException;
}
