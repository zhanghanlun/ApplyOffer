package code._25二叉树中和为某一值的路径;

import java.util.*;


/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}
public class FindPath {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int sumVal = 0;
        orderTree(root,result,nodeStack,numStack,sumVal,target);
        result.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });
        return result;
    }

    public void orderTree(TreeNode root, ArrayList<ArrayList<Integer>> result,
                           Stack<TreeNode> nodeStack, Stack<Integer> numStack, int sumVal,int target) {
        if (root != null) {
            nodeStack.push(root);
            numStack.push(root.val);
            sumVal = sumVal + root.val;
            if (sumVal == target && root.left == null && root.right == null) {
                ArrayList<Integer> list = new ArrayList<>(numStack);
                result.add(list);
            }
            orderTree(root.left, result, nodeStack, numStack, sumVal, target);
            orderTree(root.right, result, nodeStack, numStack, sumVal, target);
            nodeStack.pop();
            numStack.pop();
            sumVal = sumVal - root.val;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        root.left = node2;
        root.right = node1;
        System.out.println(new FindPath().FindPath(root,7));

    }
}
