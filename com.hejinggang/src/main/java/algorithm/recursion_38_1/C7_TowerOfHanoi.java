package algorithm.recursion_38_1;

public class C7_TowerOfHanoi {

    public static void hanoi(int n) {
        if (n > 0) {
            f(n, "left", "right", "middle");
        }
    }

    public static void f(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("move 1 from " + from + " to " + to);
            return;
        }
        f(n - 1, from, other, to);
        System.out.println("move " + n + " from " + from + " to " + to);
        f(n - 1, other, to, from);
    }

    public static void main(String []args) {
        hanoi(3);
    }
}
