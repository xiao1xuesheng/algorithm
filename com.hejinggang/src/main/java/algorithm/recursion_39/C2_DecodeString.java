package algorithm.recursion_39;

// 含有嵌套的字符串解码
// 测试链接 : https://leetcode.cn/problems/decode-string/
public class C2_DecodeString {

    private static int where;

    public static String decodeString(String str) {
        where = 0;
        return f(str.toCharArray(), 0);
    }
    // s[i....]开始计算，遇到字符串终止 或者 遇到 ] 停止
    // 返回 : 自己负责的这一段字符串的结果
    // 返回之间，更新全局变量where，为了上游函数知道从哪继续！
    public static String f(char[] s, int i) {
        StringBuilder path = new StringBuilder();
        int cnt = 0;
        while (i < s.length && s[i] != ']') {
            if ((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z')) {
                path.append(s[i++]);
            } else if (s[i] >= '0' && s[i] <= '9') {
                cnt = cnt * 10 + (s[i++] - '0');
            } else {
                // 遇到【
                path.append(get(cnt, f(s, i + 1)));
                i = where  + 1;
                cnt = 0;
            }
        }
        where = i;
        return path.toString();
    }

    private static String get(int cnt, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<cnt; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "AB2[CD]E3[F]";
        System.out.println(decodeString(str));
    }
}
