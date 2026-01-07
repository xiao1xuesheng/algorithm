package algorithm;

public class SampleArrayGenerator {

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int size = (int) ((maxSize + 1) * Math.random());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        int n = arr.length;
        int []target = new int[n];
        for (int i= 0; i < n; i++) {
            target[i] = arr[i];
        }
        return target;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null) {
            return true;
        }
        for (int i = 0; i < arr1.length && i < arr2.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i % 4 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(arr[i] + " ");
        }
    }

    public static void rightMethod(int[] arr) {
        java.util.Arrays.sort(arr);
    }
}
