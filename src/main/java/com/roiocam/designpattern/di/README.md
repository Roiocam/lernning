# 前言
编写此包(Dependency Injection)的原因在于,在思考为什么我们需要IOC容器时想到的。

IOC的主要核心原理是DI，依赖注入，为此，为什么简单的DI无法满足，而需要IOC容器来帮助我们呢？

我们先来看看DI能为我们做什么，以及它有哪些不足，以至于为什么我们需要IOC

<!--more-->
# 解释
在软件工程中，依赖注入是一种“一个对象可以提供另一对象的依赖关系”的技术。

**依赖关系(Dependency):**: “依赖关系”是可以用作Service的Example对象. 与客户端指定使用具体的Service实现不同,"依赖关系"告诉客户端应该使用哪个Service实现.
           
**注入(Injection)**: “注入”是指将依赖(一个Service的具体实现对象)传递给将使用该服务的对象(客户端)

在依赖注入中,Service是客户端状态(属性)的一部分。将Service传递给客户端，而不是允许客户端自行构建或找到服务，是该模式的基本要求。

# 目的
依赖注入的目的是将 Service的实现以及Service对象的构造(生成)与 Service的使用分离.从而提高代码可读性.如

    #Service的实现与构造耦合
    public class Client{
        void useInputServicePrint(){
            //构造
            InputService is = new InputService();
            //使用
            is.print();
        }
    }
    //实现
    class InputService{
        void print(){
            System.out.println("I'm Input Service");
        }
    }
    #依赖注入
    public class Client{
        //作为客户端的状态存在
        private InputService is;
        void useInputServicePrint(){
            //使用
            is.print();
        }
    }
  
通过以上的案例我们可以清晰的了解到.依赖注入的主要目的是将Service的 ”use“ 责任与 "build" 责任分离. 将"build"责任委托给注入程序.

维基百科上关于目的的说法:

1. **类**或应用程序如何不受对象创建的约束? (对象的创建与类无关)
2. **类**或应用程序如何在单独的配置文件中配置对象创建的方法.
3. **类**或应用程序如何支持不同的配置文件

依赖注入实现了"依赖倒置原则"和"单一职责原则".

# 结论
通过依赖注入,我们实现了build和use分离.但是有个缺点是,即使是使用[InjectorExample.java]('https://github.com/Roiocam/lernning/blob/master/src/main/java/com/roiocam/designpattern/di/InjectorExample.java.java')中的
类注入,我们仍然无法避免需要主动告诉程序我们使用了什么类.  

IOC中 **Service locator pattern(服务定位器模式)** 解决了DI的此缺点,需要进一步了解IOC的内容则跳转-->>[IOC]('https://github.com/Roiocam/lernning/blob/master/src/main/java/com/roiocam/designpattern/ioc')

# 二.控制反转(IOC)
依赖项注入是IoC的一种特定类型。类似于Java命名和目录接口(JNDI)这样的服务定位器。



控制反转（IoC）比DI更普遍。简而言之，IoC意味着让其他代码调用您，而不是坚持进行调用。没有DI的IoC的一个示例是模板方法模式。在这里，多态性是通过子类化（即继承）实现的。[17]

依赖注入通过组合实现IoC，因此通常与策略模式的 IoC 相同，但是虽然策略模式旨在使依赖在对象的整个生命周期中都可以互换，但是在依赖注入中，可能仅使用了一个依赖实例。[18]这仍然可以实现多态，但是要通过委派和组成。


