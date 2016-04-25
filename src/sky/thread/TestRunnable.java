package sky.thread;

public class TestRunnable implements Runnable {

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {

            if (i == 20) {
                TestRunnable tr = new TestRunnable();
                Thread th = new Thread(tr, "线程一");
                th.start();

                // new Thread(tr, "线程二").start();
            }
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }
    }

    private int i;

    @Override
    public void run() {
        for (; i < 100; i++) {
//            Thread.currentThread().setName("新线程");
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }
    }
}
