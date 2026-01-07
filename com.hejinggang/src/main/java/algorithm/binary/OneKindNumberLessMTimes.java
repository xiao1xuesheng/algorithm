package algorithm.binary;

public class OneKindNumberLessMTimes {

    // 数组中只有1种数出现次数少于m次，其他数都出现了m次
    // 返回出现次数小于m次的那种数
    // 测试链接 : https://leetcode.cn/problems/single-number-ii/
    // 注意 : 测试题目只是通用方法的一个特例，课上讲了更通用的情况
    public static void main(String[] args) {
        int []nums = {1,1,1,2,2,2,3,3,3,4,5,5,5};
        System.out.println(find(nums, 3));
        int []nums1 = {1,1,1,1,2,2,2,2,3,3,3,3,4,5,5,5,5};
        System.out.println(find(nums1, 4));
    }

    private static int find(int[] nums, int times) {
        int []cnts = new int[32];
        for (int num: nums) {
            for (int i=0; i<32; i++) {
                cnts[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i=0; i<32; i++) {
            // cnts[i] % times != 0 的可能的值为n * m + 1 或者 1，都表示该位置上目标数字为1
            if (cnts[i] % times != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
