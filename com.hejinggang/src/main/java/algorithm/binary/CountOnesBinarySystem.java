package algorithm.binary;

public class CountOnesBinarySystem {

    public static void main(String[] args) {
        int n = 28;
        System.out.println("n count ones is : " + countOnes(n));
        System.out.println("n count ones is : " + countOnes1(n));
        System.out.println("is equal : " + (countOnes(n) == countOnes1(n)));
    }

    public static int countOnes(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static int countOnes1(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
        return n;
    }
}
