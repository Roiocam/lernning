package com.roiocam.designpattern.ioc.bean.factory;

import java.util.Map;

/**
 * BeanFactory有关获取集合Bean信息的方法.
 *
 * @author Andy Chen
 * @date 2020/1/7 下午6:05
 */
public interface ListableBeanFactory extends BeanFactory {
    /**
     * 获取所有的Bean定义名称
     * @return
     */
    String[] getBeanDefinitionNames();

    /**
     * 根据类型获取所有的Bean 以Map形式返回(BeanName,bean实例)
     * @param var1
     * @param <T>
     * @return
     */
    <T> Map<String, T> getBeansOfType(Class<T> var1);

    /**
     * 根据类型获取所有的BeanName
     * @param var1
     * @return
     */
    String[] getBeanNamesForType(Class<?> var1);

}
