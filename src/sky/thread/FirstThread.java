package sky.thread;

import java.util.Date;

public class FirstThread extends Thread {

    private int i;

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "  " + i);
            if (i == 20) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println(new Date());
        System.out.println("mian thread-->"+Thread.currentThread().getName());
        FirstThread ft = new FirstThread();
        ft.setName("线程1");
        ft.start();
        System.out.println("1111111");
         ft.sleep(1000);
         System.out.println("2222222");
    }

}
