package code._18数的子结构;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class HasSubtree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return judgeTree(root1,root2);
    }

    private boolean judgeTree(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return false;
        }
        TreeNode index1 = root1;
        TreeNode index2 = root2;
        if (orderTree(index1, index2)) {
            return true;
        }
        return judgeTree(root1.left,root2) || judgeTree(root1.right,root2);
    }


    private boolean orderTree(TreeNode index1, TreeNode index2) {
        if (index2 == null) {
            return true;
        }
        if (index1 == null) {
            return false;
        }
        if (index1.val == index2.val) {
            return orderTree(index1.left, index2.left) && orderTree(index1.right, index2.right);
        } else {
            return false;
        }
    }
}
