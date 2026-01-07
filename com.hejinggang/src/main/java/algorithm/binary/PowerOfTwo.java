package algorithm.binary;

public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println("32 是否为2的幂：" + isPowerOf(32));
        System.out.println("36 是否为2的幂：" + isPowerOf(36));
        System.out.println("-32 是否为2的幂：" + isPowerOf(-32));
        System.out.println("1 是否为2的幂：" + isPowerOf(1));
    }

    // 判断是否为2的幂就是判断该数的二进制是否只包含一个1，若小于0，则一定不是
    private static boolean isPowerOf(int i) {
        return  i > 0 && i == (i & (-i));
    }


}
