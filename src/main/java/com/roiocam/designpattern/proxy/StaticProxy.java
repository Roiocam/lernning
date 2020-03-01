package com.roiocam.designpattern.proxy;


/**
 * 静态代理
 * <p>事先定义</p>
 * <p>在运行之前已经编译好</p>
 *
 * @author Andy Chen
 * @date 2019/12/31 下午4:16
 */
public class StaticProxy {
    public static void main(String[] args) {
        //需要执行ding()方法的类
        Ding ding = new Ding();
        //代理对象代理执行ding方法
        DingProxy proxy = new DingProxy(ding);
        proxy.ding();
        /*
        输出:
        代理对象:DingProxy代理执行ding();
        对象Ding执行方法:ding...
        代理对象:DingProxy执行完毕;
        */
    }
}

/**
 * 代理接口。
 */
interface IProxy {
    /**
     * 被代理对象需要的方法
     */
    void ding();
}

/**
 * 需要执行ding方法的类
 * 被代理的对象
 */
class Ding implements IProxy {
    @Override
    public void ding() {
        System.out.println("对象" + this.getClass().getSimpleName() + "执行方法:ding...");
    }
}

class DingProxy implements IProxy {
    Ding ding;

    public DingProxy(Ding ding) {
        this.ding = ding;
    }

    @Override
    public void ding() {
        System.out.println("代理对象:" + this.getClass().getSimpleName() + "代理执行ding();");
        ding.ding();
        System.out.println("代理对象:" + this.getClass().getSimpleName() + "执行完毕;");
    }
}
