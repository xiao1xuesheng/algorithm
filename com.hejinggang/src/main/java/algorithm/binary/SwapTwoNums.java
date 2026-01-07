package algorithm.binary;

public class SwapTwoNums {

    public static void main(String []args) {
        swap();
    }

    /**
     * 使用异或的方式交换两个数
     */
    private static void swap() {
        int a = 3;
        int b = 5;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.printf("a = %s, b = %s", a, b);
    }
}
