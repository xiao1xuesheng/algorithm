package algorithm.heap;

public class HeapSort {

    public static void main(String[] args) {
        int []nums = {6,2,4,3,8,1};
        sortArray(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int[] sortArray(int[] nums) {
        if (nums.length > 1) {
            heapSort(nums);
        }
        return nums;
    }

    public static void heapSort(int []nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            heapInsert(nums, i);
        }
        int size = n;
        while (size > 1) {
            swap(nums, 0, --size);
            heapify(nums, 0, size);
        }
    }

    public static void heapInsert(int []nums, int i) {
        while (nums[i] > nums[(i - 1) / 2]) {
            swap(nums, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void heapify(int []nums, int i, int size) {
        int l = i * 2 + 1;
        while (l < size) {
            int best = (l + 1) < size && nums[l + 1] > nums[l] ? (l + 1) : l;
            best = nums[best] > nums[i] ? best : i;
            if (best == i) {
                break;
            }
            swap(nums, best, i);
            i = best;
            l = i * 2 + 1;
        }
    }

    public static void swap(int []nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 从底到顶建立大根堆，O(n)
    // 依次弹出堆内最大值并排好序，O(n * logn)
    // 整体时间复杂度O(n * logn)
    public static void heapSort2(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
        int size = n;
        while (size > 1) {
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }
}
