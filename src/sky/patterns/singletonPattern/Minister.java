package sky.patterns.singletonPattern;

/**
 * 单例模式 臣子类
 * @author sky
 * @since 2012-2-20
 * @version 1.0
 */
public class Minister {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Emperor emperor = Emperor.getInstance();
            emperor.say();
//            Emperor e = new Emperor();
//            e.say();
        }
    }

}
