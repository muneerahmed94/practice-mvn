package multithreading;

/**
 * Created by Muneer on 07-06-2017.
 */
public class SynchronizedDemo1 {
    public static void main(String[] args) {
        Show show = new Show();

        MyThread1 t1 = new MyThread1(show);
        MyThread2 t2 = new MyThread2(show);

        t1.start();
        t2.start();
    }
}

class Show {
    public synchronized void shown() {
        for(int i = 0; i < 10; i++) {
            System.out.print(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void showc() {
        for(int i = 97; i < 107; i++) {
            System.out.print((char) i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread1 extends Thread {
    Show show;

    MyThread1(Show show) {
        this.show = show;
    }

    @Override
    public void run() {
        show.shown();
    }
}

class MyThread2 extends Thread {
    Show show;

    MyThread2(Show show) {
        this.show = show;
    }

    @Override
    public void run() {
        show.showc();
    }
}
