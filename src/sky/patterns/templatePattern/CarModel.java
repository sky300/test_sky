package sky.patterns.templatePattern;

public abstract class CarModel {
    protected void start(){}
    protected void stop(){}
    protected void alarm(){}
    protected void engineBoom(){}
    protected void run(){
        this.start();
        this.alarm();
        this.engineBoom();
        this.stop();
    }
}
