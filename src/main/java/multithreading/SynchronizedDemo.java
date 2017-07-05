package multithreading;

/**
 * Created by Muneer on 06-06-2017.
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        X x1 = new X();
        X x2 = new X();

        MyThread01 t1 = new MyThread01(x1);
        MyThread02 t2 = new MyThread02(x2);
        MyThread03 t3 = new MyThread03(x1);
        MyThread04 t4 = new MyThread04(x1);
        MyThread05 t5 = new MyThread05(x1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class MyThread extends Thread {
    Display display;
    String name;

    MyThread(Display display, String name) {
        this.display = display;
        this.name = name;
    }

    @Override
    public void run() {
        display.display(name);
    }
}

class Display {
    public static synchronized void display(String name) {
        for (int i = 0; i < 5; i++) {
            System.out.print("Good Morning: ");
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
        }
    }
}

class X {
    static synchronized void m1() {
        for(int i = 0; i < 5; i++) {
            System.out.println("m1");
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static synchronized void m2() {
        for(int i = 0; i < 5; i++) {
            System.out.println("m2");
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void m3() {
        for(int i = 0; i < 5; i++) {
            System.out.println("m3");
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized void m4() {
        for(int i = 0; i < 5; i++) {
            System.out.println("m4");
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void m5() {
        for(int i = 0; i < 5; i++) {
            System.out.println("m5");
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread01 extends Thread {
    X x;

    MyThread01(X x) {
        this.x = x;
    }

    @Override
    public void run() {
        x.m1();
    }
}

class MyThread02 extends Thread {
    X x;

    MyThread02(X x) {
        this.x = x;
    }

    @Override
    public void run() {
        x.m2();
    }
}

class MyThread03 extends Thread {
    X x;

    MyThread03(X x) {
        this.x = x;
    }

    @Override
    public void run() {
        x.m3();
    }
}

class MyThread04 extends Thread {
    X x;

    MyThread04(X x) {
        this.x = x;
    }

    @Override
    public void run() {
        x.m4();
    }
}

class MyThread05 extends Thread {
    X x;

    MyThread05(X x) {
        this.x = x;
    }

    @Override
    public void run() {
        x.m5();
    }
}
