package algorithm.binary;

import java.util.Arrays;

public class TwoSingleNumbers {

    // 数组中有2种数出现了奇数次，其他的数都出现了偶数次
    // 返回这2种出现了奇数次的数
    // 测试链接 : https://leetcode.cn/problems/single-number-iii/
    // 这是java版本的实现，本节课Code05_DoubleNumber2文件是C++版本的实现
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,4,4,5,6,6};
        int[] retResult = getTwoSingleNumbers(arr);
        System.out.println(Arrays.toString(retResult));
    }

    private static int[] getTwoSingleNumbers(int[] arr) {

        int exor = 0;
        for (int i : arr) {
            exor ^= i;
        }
        int rightOne = exor & (-exor);
        int num1 = 0;
        for (int i : arr) {
            if ((i & rightOne) == 0) {
                num1 ^= i;
            }
        }
        int [] retResult = new int[2];
        retResult[0] = num1;
        retResult[1] = exor ^ num1;
        return retResult;
    }
}
