package algorithm.recursion_38;

import java.util.ArrayList;
import java.util.List;

// 字符串的全部子序列
// 子序列本身是可以有重复的，只是这个题目要求去重
// 测试链接 : https://www.nowcoder.com/practice/92e6247998294f2c933906fdedbc6e6a
public class C1_Subsequences {

    public static List<String> generatePermutation(String str) {
        char[] chars = str.toCharArray();
        List<String> ans = new ArrayList<>();
        f(chars, 0, new StringBuilder(), ans);
        return ans;
    }

    private static void f(char[] chars, int i, StringBuilder path, List<String> ans) {
        if (i == chars.length) {
            ans.add(path.toString());
            return;
        }
        path.append(chars[i]);
        f(chars, i + 1, path, ans);
        path.deleteCharAt(path.length() - 1);
        f(chars, i + 1, path, ans);
    }

    public static List<String> generatePermutation1(String str) {
        char[] chars = str.toCharArray();
        List<String> ans = new ArrayList<>();
        f1(chars, 0, new char[chars.length], 0, ans);
        return ans;
    }

    private static void f1(char[] chars, int i, char[]path, int size, List<String> ans) {
        if (i == chars.length) {
            ans.add(String.valueOf(path, 0, size));
            return;
        }
        path[size] = chars[i];
        f1(chars, i + 1, path, size + 1, ans);
        f1(chars, i + 1, path, size, ans);
    }

    public static void main(String[] args) {

        System.out.println("第一种方案：");
        List<String> ans = generatePermutation("abc");
        for (String cur: ans) {
            System.out.println(cur);
        }
        System.out.println("第二种方案：");
        List<String> ans1 = generatePermutation("abc");
        for (String cur: ans1) {
            System.out.println(cur);
        }
    }
}
