package algorithm.binary;

public class PowerOfThree {

    public static void main(String[] args) {
        // 求正整数部分int类型可以容纳的最大的3的幂
        int maxNum = 3;
        while (true) {
            if (maxNum < maxNum * 3) {
                maxNum = maxNum * 3;
            } else {
                break;
            }
        }
        System.out.println("最大的3的Integer幂为：" + maxNum);
        System.out.println("32是否为3的幂：" + isThreeTimes(maxNum, 32));
        System.out.println("27是否为3的幂：" + isThreeTimes(maxNum, 27));
        System.out.println("1是否为3的幂：" + isThreeTimes(maxNum, 1));
        System.out.println("0是否为3的幂：" + isThreeTimes(maxNum, 0));
    }

    public static boolean isThreeTimes(int maxNum, int targetNum) {
        return targetNum > 0 && maxNum % targetNum == 0;
    }
}
