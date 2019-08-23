package code._6重建二叉树;


public class ReconstructTheBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        return reConstructTree(pre, 0, pre.length - 1,
                in, 0, in.length - 1);
    }

    private TreeNode reConstructTree(int[] pre, int startPre, int endPre,
                                     int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        if (startPre < 0 || startIn < 0) {
            return null;
        }
        TreeNode node = new TreeNode(pre[startPre]);
        int indexIn = 0;
        for (int i = startIn; i <= endIn; i++) {
            if (pre[startPre] == in[i]) {
                indexIn = i;
            }
        }
        int leftLength = indexIn - startIn;
        node.left = reConstructTree(pre, startPre + 1, startPre + leftLength,
                in, startIn, indexIn - 1);
        node.right = reConstructTree(pre, startPre + leftLength + 1, endPre,
                in, indexIn + 1, endIn);
        return node;
    }

    public static void main(String[] args){

    }

}
