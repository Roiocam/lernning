package com.roiocam.designpattern.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * <p>在运行时创建代理对象</p>
 * <p>不用对每个类实现接口即可代理</p>
 *
 * @author Andy Chen
 * @date 2019/12/31 下午4:27
 */
public class DymanicProxy {
    public static void main(String[] args) {
        IDProxy dDing = new DDing();
        //创建一个与代理对象相关联的InvocationHandler
        InvocationHandler handler = new DingInvocationHandler<IDProxy>(dDing);
        //通过反射创建代理对象代理dDing对象，
        //方法执行时，通过代理对象执行方法，故必定会执行InvocationHandler中的Invoke方法。
        IDProxy newProxyInstance = (IDProxy) Proxy.newProxyInstance(IDProxy.class.getClassLoader(), new Class<?>[]{IDProxy.class}, handler);
        //通过代理执行方法
        newProxyInstance.ding();
    }
}

interface IDProxy {
    void ding();
}

/**
 * 需要执行ding方法的类
 * 被代理的对象
 */
class DDing implements IDProxy {
    @Override
    public void ding() {
        System.out.println("对象" + this.getClass().getSimpleName() + "执行方法:ding...");
    }
}

class DingInvocationHandler<T> implements InvocationHandler {
    //InvocationHandler持有的被代理对象
    private T target;

    public DingInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行:" + method.getName());
        Object result = method.invoke(target, args);
        return result;
    }
}