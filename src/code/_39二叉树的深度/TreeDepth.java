package code._39二叉树的深度;


import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class TreeDepth {

    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        return Math.max(leftDepth+1,rightDepth+1);
    }


//    private int treeDepth(TreeNode root, Stack<TreeNode> nodeStack) {
//        if (root == null) {
//            return 0;
//        }
//        nodeStack.push(root);
//        int depth = nodeStack.size();
//        int leftDepth = treeDepth(root.left, nodeStack);
//        int rightDepth = treeDepth(root.right, nodeStack);
//        nodeStack.pop();
//        return Math.max(depth, Math.max(leftDepth, rightDepth));
//    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        node1.left = node2;
        System.out.println(new TreeDepth().TreeDepth(node1));
    }

}
