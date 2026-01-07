package algorithm.binary;

public class SingleNumber {

    public static void main(String[] args) {
        int []arr = {1,1,1,1,2,2,3,3,3,4,4,4,4,4,4};
        System.out.println("the single number is: " + singleNum(arr));
    }

    private static int singleNum(int[] arr) {

        int numAll = 0;

        for (int i : arr) {
            numAll = numAll ^ i;
        }
        return numAll;
    }
}

