package com.designpattern.singleton;

public class SingleObject {

    private static SingleObject instance = new SingleObject();

    public SingleObject() {
    }

    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }

    /**
     * 单例总结
     * 经验之谈：一般情况下，不建议使用第 1 种和第 2 种懒汉方式，建议使用第 3 种饿汉方式。
     * 只有在要明确实现 lazy loading 效果时，才会使用第 5 种登记方式。
     * 如果涉及到反序列化创建对象时，可以尝试使用第 6 种枚举方式。
     * 如果有其他特殊的需求，可以考虑使用第 4 种双检锁方式。
     */

    /**
     * 单例的几种模式
     */

    /**
     * 1、懒汉式，线程不安全
     * 是否 Lazy 初始化：是
     *
     * 是否多线程安全：否
     *
     * 实现难度：易
     *
     * 描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
     * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
     */

//    private static Singleton instance;
//    private Singleton (){}
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    /**
     *2、懒汉式，线程安全
     * 是否 Lazy 初始化：是
     *
     * 是否多线程安全：是
     *
     * 实现难度：易
     *
     * 描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
     * 优点：第一次调用才初始化，避免内存浪费。
     * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
     * getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
     *
     */

//    public class Singleton {
//        private static Singleton instance;
//        private Singleton (){}
//        public static synchronized Singleton getInstance() {
//            if (instance == null) {
//                instance = new Singleton();
//            }
//            return instance;
//        }
//    }

    /**
     * 3、饿汉式
     * 是否 Lazy 初始化：否
     *
     * 是否多线程安全：是
     *
     * 实现难度：易
     *
     * 描述：这种方式比较常用，但容易产生垃圾对象。
     * 优点：没有加锁，执行效率会提高。
     * 缺点：类加载时就初始化，浪费内存。
     * 它基于 classloader 机制避免了多线程的同步问题，不过，instance 在类装载时就实例化，
     * 虽然导致类装载的原因有很多种，在单例模式中大多数都是调用 getInstance 方法，
     * 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化 instance 显然没有达到 lazy loading 的效果。
     */

//    public class Singleton {
//        private static Singleton instance = new Singleton();
//        private Singleton (){}
//        public static Singleton getInstance() {
//            return instance;
//        }
//    }

    /**
     * 4、双检锁/双重校验锁（DCL，即 double-checked locking）
     * JDK 版本：JDK1.5 起
     *
     * 是否 Lazy 初始化：是
     *
     * 是否多线程安全：是
     *
     * 实现难度：较复杂
     *
     * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
     * getInstance() 的性能对应用程序很关键
     */

//    public class Singleton {
//        private volatile static Singleton singleton;
//        private Singleton (){}
//        public static Singleton getSingleton() {
//            if (singleton == null) {
//                synchronized (Singleton.class) {
//                    if (singleton == null) {
//                        singleton = new Singleton();
//                    }
//                }
//            }
//            return singleton;
//        }
//    }

    /**
     * 5、登记式/静态内部类
     * 是否 Lazy 初始化：是
     *
     * 是否多线程安全：是
     *
     * 实现难度：一般
     *
     * 描述：这种方式能达到双检锁方式一样的功效，但实现更简单。对静态域使用延迟初始化，
     * 应使用这种方式而不是双检锁方式。这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
     */

//    public class Singleton {
//        private static class SingletonHolder {
//            private static final Singleton INSTANCE = new Singleton();
//        }
//        private Singleton (){}
//        public static final Singleton getInstance() {
//            return SingletonHolder.INSTANCE;
//        }
//    }

    /**
     * 6、枚举
     * JDK 版本：JDK1.5 起
     *
     * 是否 Lazy 初始化：否
     *
     * 是否多线程安全：是
     *
     * 实现难度：易
     *
     * 描述：这种实现方式还没有被广泛采用，但这是实现单例模式的最佳方法。它更简洁，自动支持序列化机制，绝对防止多次实例化。
     */

//    public enum Singleton {
//        INSTANCE;
//        public void whateverMethod() {
//        }
//    }



}
