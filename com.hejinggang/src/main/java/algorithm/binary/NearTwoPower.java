package algorithm.binary;

public class NearTwoPower {

    public static void main(String[] args) {

        System.out.println("大于等于32的2的幂为" + nearTwoPower(32));
        System.out.println("大于等于0的2的幂为" + nearTwoPower(0));
        System.out.println("大于等于36的2的幂为" + nearTwoPower(36));
        System.out.println("大于等于1的2的幂为" + nearTwoPower(1));
        System.out.println("最大的2的幂为：" + nearTwoPower(Integer.MAX_VALUE / 2 - 1));
        System.out.println("最大的2的幂为：" + nearTwoPower(Integer.MAX_VALUE / 2 + 2));
        /**
         * 大于等于32的2的幂为32
         * 大于等于0的2的幂为1
         * 大于等于36的2的幂为64
         * 大于等于1的2的幂为1
         * 最大的2的幂为：1073741824
         * 最大的2的幂为：-2147483648
         */

        int maxPowerTwo = nearTwoPower(Integer.MAX_VALUE / 2 + 1);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(maxPowerTwo * 2);
    }

    public static int nearTwoPower(int num) {
        if (num <= 0) {
            return 1;
        }
        num = num - 1;

        num |= num >>> 1;
        num |= num >>> 2;
        num |= num >>> 4;
        num |= num >>> 8;
        num |= num >>> 16;
        return num + 1;
    }
}
