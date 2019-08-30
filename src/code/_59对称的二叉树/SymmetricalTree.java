package code._59对称的二叉树;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class SymmetricalTree {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        if (pRoot.left == null && pRoot.right == null) {
            return true;
        } else if (pRoot.right != null && pRoot.left != null) {
            return isSys(pRoot.right,pRoot.left);
        } else {
            return false;
        }
    }

    public boolean isSys(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 != null && node2 != null) {
            if (node1.val != node2.val) {
                return false;
            }
            return isSys(node1.left, node2.right) && isSys(node1.right, node2.left);
        } else {
            return false;
        }
    }
}
