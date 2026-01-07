package algorithm;

public class SampleSortTest {

    public static void main(String []args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        insertSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 冒泡排序
    public static void bubbleSort(int []arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        for(int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void selectSort(int []arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
    }

    public static void insertSort(int []arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}
