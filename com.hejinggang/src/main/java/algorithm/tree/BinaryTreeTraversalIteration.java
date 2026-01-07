package algorithm.tree;

import java.util.Stack;

public class BinaryTreeTraversalIteration {

    public static class TreeNode {
        public int val;
        public TreeNode leftNode;
        public TreeNode rightNode;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void preOrder(TreeNode head) {
        if (head == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            System.out.print(treeNode.val + " ");
            if (treeNode.rightNode != null) {
                stack.push(treeNode.rightNode);
            }
            if (treeNode.leftNode != null) {
                stack.push(treeNode.leftNode);
            }
        }
        System.out.println();
    }

    public static void inOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.leftNode;
            } else {
                head = stack.pop();
                System.out.print(head.val + " ");
                head = head.rightNode;
            }
        }
        System.out.println();
    }

    public static void posOrder(TreeNode head) {

    }
}
