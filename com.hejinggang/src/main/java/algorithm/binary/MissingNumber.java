package algorithm.binary;

public class MissingNumber {

    // 判断一个整数是不是3的幂
    // 测试链接 : https://leetcode.cn/problems/power-of-three/
    public static void main(String[] args) {

        int[] a = {0, 1, 2, 3, 4, 6};

        System.out.println("missing number is: " + missingNum(a));
    }

    private static int missingNum(int[] a) {
        int numAll = 0; int numHas = 0;
        for (int i = 0; i < a.length; i++) {
            numAll = numAll ^ i;
            numHas = numHas ^ a[i];
        }
        numAll = numAll ^ a.length;
        return numHas ^ numAll;
    }
}
