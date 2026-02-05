package algorithm.tree_second_37;

// 二叉树打家劫舍问题
// 测试链接 : https://leetcode.cn/problems/house-robber-iii/
public class HouseRobberIII {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static int rob(TreeNode root) {
        f(root);
        return Math.max(yes, no);
    }

    // 用来存放偷X子树时若偷了头节点的最大累计和
    public static int yes;

    // 用来存放偷X子树时若不偷头节点的最大累计和
    public static int no;

    public static void f(TreeNode root) {
        if (root == null) {
            yes = 0;
            no = 0;
        } else {
            int y = root.val;
            int n = 0;
            f(root.left);
            y += no;
            n += Math.max(yes, no);
            f(root.right);
            y += no;
            n += Math.max(yes, no);
            yes = y;
            no = n;
        }
    }
}
