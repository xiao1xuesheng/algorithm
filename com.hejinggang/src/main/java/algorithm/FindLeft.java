package algorithm;

// 有序数组中找>=num的最左位置
public class FindLeft {

    public static void main(String []args) {
        int[] arr = {1, 3, 3, 5, 7, 9, 11, 13};
        int num = 13;
        int index = findLeft(arr, num);
        int rightIndex = rightMethod(arr, num);
        if (index != rightIndex) {
            System.out.println("Error: expected " + rightIndex + " but got " + index);
        } else {
            System.out.println("Correct: index is " + index);
        }
    }

    public static int findLeft(int []arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] >= num) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    public static int rightMethod(int []arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                return i;
            }
        }
        return -1;
    }
}
