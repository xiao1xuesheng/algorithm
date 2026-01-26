package algorithm.binary;

public class ReverseBits {

    // 颠倒给定的 32 位无符号整数的二进制位。
    // 提示：
    // 输入是一个长度为 32 的二进制字符串
    // 测试链接 : https://leetcode.cn/problems/reverse-bits/
    public static void main(String[] args) {
        int n = 8;
        System.out.println("n reverse bits is : " + reverseBits(n));
        System.out.println("n reverse bits is : " + reverseBits1(n));
        System.out.println("is equal : " + (reverseBits(n) == reverseBits1(n)));
    }

    // 方法一：逐位颠倒
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= (n & 1) << (31 - i);
            n >>= 1;
        }
        return res;
    }

    // 大神做法
    public static int reverseBits1(int n) {
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = (n >>> 16) | (n<< 16);
        return n;
    }
}
