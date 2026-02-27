package algorithm.recursion_38_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C2_Combinations {

    public static List<List<Integer>> combinations(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        f(nums, 0, new int[nums.length], 0, ans);
        return ans;
    }

    private static void f(int[] nums, int i, int[]path, int size, List<List<Integer>> ans) {
        if (i == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                cur.add(path[j]);
            }
            ans.add(cur);
            return;
        }
        int j = i + 1;
        while (j < nums.length && nums[i] == nums[j]) {
            j++;
        }
        f(nums, j, path, size, ans);
        for (; i < j; i++) {
            path[size++] = nums[i];
            f(nums, j, path, size, ans);
        }
    }

    public static void main(String []args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> ans = combinations(nums);
        System.out.println(ans);
    }
}
