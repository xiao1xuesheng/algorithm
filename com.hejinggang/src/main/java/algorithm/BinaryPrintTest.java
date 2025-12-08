package algorithm;

public class BinaryPrintTest {

    public static void main(String[] args) {
        int n = -29;
        printBinary(n);
        printBinary2(n);
    }

    // AI 写的
    public static void printBinary(int n) {
        StringBuilder binary = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;
            binary.append(bit);
        }
        System.out.println("Binary representation of " + n + " is: " + binary.toString());
    }

    // 左老师写的
    public static void printBinary2(int n) {
        System.out.print("Binary representation of " + n + " is: ");
        for (int i=31; i>=0; i--) {
            System.out.print((n & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
}
