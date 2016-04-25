package sky.patterns.factoryPattern;

public class HumanFactory extends AbstractHumanFactory{

    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        //定义一个生产的人种
        Human human = null;
        //产生一个人种
        try {
            //产生一个人种
            human = (Human)Class.forName(c.getName()).newInstance();
            
        } catch (Exception e) {
            System.out.println("产生人种异常");
            e.printStackTrace();
        } 
        return (T)human;
    }
    
}
