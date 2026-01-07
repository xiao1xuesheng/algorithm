package juc3;

public class Synchronized1 {

    public static void main(String[] args) {
        Test.a();

        Test t = new Test();
        t.b();
    }


}

class Test {
    public static synchronized  void a() {

        System.out.println("a");
    }

    public synchronized void b() {
        System.out.println("b");
    }
}
