package com.roiocam.designpattern.di;

import java.security.InvalidParameterException;

/**
 * @author Andy Chen
 * @date 2020/3/17 下午8:28
 */
public class Client {
    /**
     * 使用组合依赖Service
     */
    private OutputService os;

    /**
     * 构造器注入
     * @param os
     */
    public Client(OutputService os){
        if (os == null) throw new InvalidParameterException("OutputService must not be null");
        this.os = os;
    }
    /**
     * Setter注入
     * @param os
     */
    public void setOutputService(OutputService os) {
        if (os == null) throw new InvalidParameterException("OutputService must not be null");
        this.os = os;
    }

    /**
     * 方法使用
     */
    public void useOutputServicePrint(){
        os.print();
    }
}
