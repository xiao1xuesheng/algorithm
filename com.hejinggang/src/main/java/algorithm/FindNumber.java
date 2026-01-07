package algorithm;

public class FindNumber {

    public static void main(String []args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        int target = 7;
        int index = findNumber(arr, target);
        int rightIndex = rightMethod(arr, target);
        if (index != rightIndex) {
            System.out.println("Error: expected " + rightIndex + " but got " + index);
        } else {
            System.out.println("Correct: index is " + index);
        }
    }

    public static int findNumber(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int targetIndex = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                targetIndex = mid;
                break;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return targetIndex;
    }

    public static int rightMethod(int []arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
