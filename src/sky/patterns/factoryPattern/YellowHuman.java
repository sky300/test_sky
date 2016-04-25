package sky.patterns.factoryPattern;

public class YellowHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("我是黄色人种");

    }

    @Override
    public void talk() {
        System.out.println("我说的是汉语");
    }

}
