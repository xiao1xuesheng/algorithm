package algorithm;

// 峰值元素是指其值严格大于左右相邻值的元素
// 给你一个整数数组 nums，已知任何两个相邻的值都不相等
// 找到峰值元素并返回其索引
// 数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
// 你可以假设 nums[-1] = nums[n] = 无穷小
// 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
public class FindPeekElement {

    public static int findPeekElement(int []arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }

        if (arr[0] > arr[1]) {
            return 0;
        }

        if (arr[n - 1] > arr[n - 2]) {
            return n - 1;
        }

        int left = 1;
        int right = n - 2;
        int mid = 0;
        int ans = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr [mid + 1]) {
                ans = mid;
                break;
            } else if (arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 5, 6, 4};
        int index = findPeekElement(arr);
        System.out.println("Peak element index: " + index + ", value: " + arr[index]);
    }
}
