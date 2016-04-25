package sky.patterns.singletonPattern;

/**
 * 单例模式 皇帝类
 * 1、饿汉模式（当前方法）
 * 2、synchronized懒汉模式
 * @author sky
 * @since 2012-2-20
 * @version 1.0
 */
public class Emperor {
    private static final Emperor emperor = new Emperor();

    private Emperor() {
        System.out.println("hello world");
    }

    public static Emperor getInstance() {
        return emperor;
    }

    public static void say() {
        System.out.println("我是。。。");
        
    }

}
