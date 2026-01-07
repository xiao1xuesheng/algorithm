package algorithm.binary;

public class GetMaxWithoutJudge {

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        System.out.println("max = " + getMax1(a, b));
    }
    // 但是这种方法有问题，因为C有可能溢出
    private static int getMax(int a, int b) {
        int c = a - b;
        int returnA = sign(c);
        int returnB = flip(returnA);
        return returnA * a + returnB * b;
    }

    private static int getMax1(int a, int b) {
        // c为负的情况有两种： 1）a < b; 2)溢出导致为负
        int c = a - b;
        System.out.println("c = " + c);
        // 返回A的情况有两种：1）a和b符号相同（非负|负） 2）a和b符号不同，a为非负
        int signC = sign(c);
        int signA = sign(a);
        int signB = sign(b);
        // a 和 b的符号是否相同，若相同则signDiff = 0; 若不同则signDiff = 1
        int signDiff = signA ^ signB;
        int signSame = flip(signDiff);
        int returnA = signDiff * signA + signSame * signC;
        int returnB = flip(returnA);
        return returnA * a + returnB * b;
    }

    public static int flip(int n) {
        return n ^ 1;
    }
    // 1. 先将n左移31位，只保留符号位, 若为非负数则为0， 负数则为1
    // 2. 通过异或的方法将符号转一下 若为非负数则为1， 负数则为0
    public static int sign(int n) {
        return flip(n >>> 31);
    }
}
