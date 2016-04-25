package sky.patterns.factoryPattern;

public class WhiteHuman implements Human {

    @Override
    public void getColor() {
       System.out.println("我的皮肤是白色的");

    }

    @Override
    public void talk() {
        System.out.println("我说的是英语");
    }

}
