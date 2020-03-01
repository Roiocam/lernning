package com.roiocam.designpattern.ioc.bean.factory;

import com.roiocam.designpattern.ioc.bean.exception.BeansException;

/**
 * 管理Bean的生命周期（创建，依赖注入，销毁）
 *
 * @author Andy Chen
 * @date 2020/1/7 下午6:15
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    int AUTOWIRE_NO = 0;
    int AUTOWIRE_BY_NAME = 1;
    int AUTOWIRE_BY_TYPE = 2;
    int AUTOWIRE_CONSTRUCTOR = 3;
    String ORIGINAL_INSTANCE_SUFFIX = ".ORIGINAL";

    /**
     * 创建Bean
     *
     * @param var1
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T createBean(Class<T> var1) throws BeansException;

    /**
     * 自动装配bean
     *
     * @param var1
     * @throws BeansException
     */
    void autowireBean(Object var1) throws BeansException;

    /**
     * 配置Bean
     *
     * @param var1
     * @param var2
     * @return
     * @throws BeansException
     */
    Object configureBean(Object var1, String var2) throws BeansException;

    /**
     * 自动装配
     *
     * @param var1
     * @param var2
     * @param var3
     * @return
     * @throws BeansException
     */
    Object autowire(Class<?> var1, int var2, boolean var3) throws BeansException;

    /**
     * 自动装配Bean的配置信息
     *
     * @param var1
     * @param var2
     * @param var3
     * @throws BeansException
     */
    void autowireBeanProperties(Object var1, int var2, boolean var3) throws BeansException;

    /**
     * 应用bean的配置值
     *
     * @param var1
     * @param var2
     * @throws BeansException
     */
    void applyBeanPropertyValues(Object var1, String var2) throws BeansException;

    /**
     * 初始化Bean
     *
     * @param var1
     * @param var2
     * @return
     * @throws BeansException
     */
    Object initializeBean(Object var1, String var2) throws BeansException;

    Object applyBeanPostProcessorsBeforeInitialization(Object var1, String var2) throws BeansException;

    Object applyBeanPostProcessorsAfterInitialization(Object var1, String var2) throws BeansException;

    /**
     * 销毁Bean
     *
     * @param var1
     */
    void destroyBean(Object var1);
    /**
     * 解析依赖：通过反射解析类信息获取
     */
    //
    // Object resolveBeanByName(String var1, DependencyDescriptor var2) throws BeansException;
    //
    // Object resolveDependency(DependencyDescriptor var1,  String var2) throws BeansException;
    //
    // Object resolveDependency(DependencyDescriptor var1, String var2, Set<String> var3, TypeConverter var4) throws BeansException;
}