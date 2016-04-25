package sky.patterns.factoryPattern;

public abstract class AbstractHumanFactory {
    public abstract <T extends Human> T createHuman(Class<T> c);
    public static void test(){
        System.out.println("hello test");
    }
}
