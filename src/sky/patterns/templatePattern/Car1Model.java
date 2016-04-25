package sky.patterns.templatePattern;

public class Car1Model extends CarModel{

    @Override
    protected void start() {
        // TODO Auto-generated method stub
        System.out.println("第一辆车开始启动。。。");
        super.start();
    }

    @Override
    protected void stop() {
        System.out.println("第一辆车停止咯··");
        super.stop();
    }

    @Override
    protected void alarm() {
        System.out.println("声音想起来了！");
        super.alarm();
    }

    @Override
    protected void engineBoom() {
        System.out.println("引擎轰鸣");
        super.engineBoom();
    }

   
    
}
