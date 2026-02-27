package algorithm.recursion_38_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class C4_PermutationWithRepetition {

    public static List<List<Integer>> permutationWithRepetition(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(nums, 0, ans);
        return ans;
    }

    private static void f(int[] nums, int i, List<List<Integer>> ans) {
        if (i == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for (int num: nums) {
                cur.add(num);
            }
            ans.add(cur);
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int j = i; j < nums.length; j++) {
            if (set.contains(nums[j])) {
                continue;
            }
            set.add(nums[j]);
            swap(nums, i, j);
            f(nums, i + 1, ans);
            swap(nums, i, j);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int []nums = {1, 2, 3, 3};
        List<List<Integer>> ans = permutationWithRepetition(nums);
        System.out.println(ans);
    }
}
