package code._39二叉树的深度;


import java.util.Map;

public class IsBalancedTree {


    private int isBalance(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = isBalance(root.left);
        if (left == -1) return -1;
        int right = isBalance(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isBalance(root) != -1;
    }
}
