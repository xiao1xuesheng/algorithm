package algorithm.recusion;

public class QuickSort1 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 6, 4, 7, 2};
        sortArray(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void sortArray(int []nums) {
        if (nums.length > 1) {
            quickSort(nums, 0, nums.length - 1);
        }
    }

    private static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = nums[l + (int)(Math.random() * (r - l + 1))];
        int mid = partition(nums, l, r, x);
        quickSort(nums, l, mid - 1);
        quickSort(nums, mid + 1, r);
    }

    private static int partition(int[] nums, int l, int r, int x) {
        int a = l, xi = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] <= x) {
                swap(nums, a, i);
                if (nums[a] == x) {
                    xi = a;
                }
                a++;
            }
        }
        swap(nums, xi, a - 1);
        return a - 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
