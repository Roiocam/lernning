package com.roiocam.designpattern.ioc.bean.factory;

/**
 * 层级管理的BeanFactory。
 * @author Andy Chen
 * @date 2020/1/7 下午6:12
 */
public interface HierarchicalBeanFactory extends BeanFactory {
    /**
     * 获取父类BeanFactory
     * @return
     */
    BeanFactory getParentBeanFactory();

    /**
     * 是否包含本地Bean
     * @param var1
     * @return
     */
    boolean containsLocalBean(String var1);
}
