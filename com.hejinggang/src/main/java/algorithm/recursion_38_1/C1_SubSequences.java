package algorithm.recursion_38_1;

import java.util.ArrayList;
import java.util.List;

public class C1_SubSequences {

    public static List<String> subsequences(String str) {
        List<String> ans = new ArrayList<>();
        char[] chars = str.toCharArray();
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

    public static List<String> subsequences1(String str) {
        List<String> ans = new ArrayList<>();
        char[] chars = str.toCharArray();
        f2(chars, 0, new char[chars.length], 0, ans);
        return ans;
    }

    private static void f2(char[] chars, int i, char[]path, int size, List<String> ans) {
        if (i == chars.length) {
            ans.add(String.valueOf(path, 0, size));
            return;
        }
        path[size] = chars[i];

        f2(chars, i + 1, path, size + 1, ans);
        f2(chars, i + 1, path, size, ans);
    }

    public static void main(String[] args) {
        List<String> ans = subsequences("abc");
        System.out.println(ans);
        List<String> ans1 = subsequences1("abc");
        System.out.println(ans1);
    }
}
