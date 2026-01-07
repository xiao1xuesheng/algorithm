package algorithm;

/**
 * 对数器
 */
public class Validator {

    public static void main(String []args) {
        int testTimes = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = SampleArrayGenerator.generateRandomArray(maxSize, maxValue);
            int[] arr2 = SampleArrayGenerator.copyArray(arr1);
            bubbleSort(arr1);
            SampleArrayGenerator.rightMethod(arr2);
            if (!SampleArrayGenerator.isEqual(arr1, arr2)) {
                succeed = false;
                SampleArrayGenerator.printArray(arr1);
                SampleArrayGenerator.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    public static void bubbleSort(int []arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
