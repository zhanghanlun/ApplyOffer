package code._63二叉搜索树的第k个结点;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class KthNode {

    private int index = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        index++;
        if (index == k) {
            return pRoot;
        }
        TreeNode nodeLeft = KthNode(pRoot.left, k);
        TreeNode nodeRight = KthNode(pRoot.right, k);
        if (nodeLeft != null) {
            return nodeLeft;
        }
        if (nodeRight != null) {
            return nodeRight;
        }
        return null;
    }
}
