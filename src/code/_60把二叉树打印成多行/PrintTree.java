package code._60把二叉树打印成多行;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class PrintTree {




    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        int nextNum = 0;
        int leaveNum = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (leaveNum > 0) {
                list.add(node.val);
                leaveNum--;
            } else {
                leaveNum = nextNum;
                nextNum = 0;
                leaveNum--;
                result.add(list);
                list = new ArrayList<>();
                list.add(node.val);
            }
            if (node.left != null) {
                nextNum++;
                queue.offer(node.left);
            }
            if (node.right != null) {
                nextNum++;
                queue.offer(node.right);
            }
        }
        if (list.size()>0){
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args){
         TreeNode root = new TreeNode(8);
         TreeNode node1 = new TreeNode(7);
         TreeNode node2 = new TreeNode(6);
         root.left = node1;
         node1.right = node2;
        System.out.println(new PrintTree().Print(root));
    }
}
