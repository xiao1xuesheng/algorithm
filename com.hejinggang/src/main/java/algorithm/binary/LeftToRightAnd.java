package algorithm.binary;

public class LeftToRightAnd {

    // 给你两个整数 left 和 right ，表示区间 [left, right]
    // 返回此区间内所有数字 & 的结果
    // 包含 left 、right 端点
    // 测试链接 : https://leetcode.cn/problems/bitwise-and-of-numbers-range/
    public static void main(String[] args) {
        System.out.println("1 ~ 2 and result is: " + leftToRightAdd(1,2));
        System.out.println("2 ~ 3 and result is: " + leftToRightAdd(2,3));
        System.out.println("-3 ~ -1 and result is: " + leftToRightAdd(-3,-1));
    }

    public static int leftToRightAdd(int left, int right) {
        while (left < right) {
            right = right - (right & -right);
        }

        return right;
    }
}
