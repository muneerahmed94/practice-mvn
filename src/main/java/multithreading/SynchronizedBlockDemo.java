package multithreading;

/**
 * Created by Muneer on 08-06-2017.
 */
public class SynchronizedBlockDemo {
    public static void main(String[] args) {
        DisplayBlock d1 = new DisplayBlock();
        DisplayBlock d2 = new DisplayBlock();

        MyThread11 t1 = new MyThread11(d1 ,"Muneer");
        MyThread11 t2 = new MyThread11(d2, "Ahmed");

        t1.start();
        t2.start();
    }
}

class DisplayBlock {
    public void  wish(String name) {
        synchronized (this) {
            for(int i = 0; i < 5; i++) {
                System.out.println("Good Morning: " + name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyThread11 extends Thread {
    DisplayBlock d;
    String name;

    MyThread11(DisplayBlock d, String name) {
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        d.wish(name);
    }
}
