package sky.patterns.factoryPattern;

public class BlackHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("我是黑皮肤的人");
    }

    @Override
    public void talk() {
        System.out.println("黑人说话都是土著语");
    }
}
