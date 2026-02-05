package algorithm.recursion_38;

public class C7_TowerOfHanoi {

    public static void hanoi(int n) {
        if (n > 0) {
            f(n, "左", "右", "中");
        }
    }

    public static void f(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("移动圆盘 1 从 " + from + " 到 " + to);
            return;
        }
        f(n - 1, from, other, to);
        System.out.println("移动圆盘 " + n + " 从 " + from + " 到 " + to);
        f(n - 1, other, to, from);
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }
}
