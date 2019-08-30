package code._61按之字形打印二叉树;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class PrintTree {

    private ArrayList<ArrayList<Integer>> PrintTyStack(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Stack<TreeNode> current = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        current.push(pRoot);
        ArrayList<Integer> list = new ArrayList<>();
        boolean fromLeftToRight = true;
        while (!current.isEmpty() || !next.isEmpty()) {
            if (current.isEmpty()) {
                current = next;
                result.add(list);
                list = new ArrayList<>();
                next = new Stack<>();
                fromLeftToRight = !fromLeftToRight;
            }
            TreeNode node = current.pop();
            list.add(node.val);
            if (fromLeftToRight) {
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            } else {
                if (node.right != null) next.add(node.right);
                if (node.left != null) next.add(node.left);
            }
        }
        if (list.size()>0){
            result.add(list);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        int nextNum = 0;
        int leaveNum = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        ArrayList<Integer> list = new ArrayList<>();
        int depth = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (leaveNum > 0) {
                list.add(node.val);
                leaveNum--;
            } else {
                leaveNum = nextNum;
                nextNum = 0;
                leaveNum--;
                if (depth % 2 == 1) {
                    int length = list.size();
                    for (int i = 0; i < length / 2; i++) {
                        int temp = list.get(i);
                        list.set(i, list.get(length - 1 - i));
                        list.set(length - 1 - i, temp);
                    }
                }
                result.add(list);
                depth++;
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
            if (depth % 2 == 1) {
                int length = list.size();
                for (int i = 0; i < length / 2; i++) {
                    int temp = list.get(i);
                    list.set(i, list.get(length - 1 - i));
                    list.set(length - 1 - i, temp);
                }
            }
            result.add(list);
        }
        return result;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        System.out.println(new PrintTree().PrintTyStack(root));
    }

}
