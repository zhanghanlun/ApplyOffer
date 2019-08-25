package code._27二叉搜索树与双向链表;


import java.lang.reflect.Array;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Convert {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode lastNode = null;
        TreeNode head = pRootOfTree;
        covertNode(pRootOfTree, lastNode);
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
//        while (lastNode!=null&&lastNode.left!=null){
//            lastNode = lastNode.left;
//        }
//        return lastNode;
//        ArrayList<Integer> list = new ArrayList<>();
//        Map<Integer, TreeNode> map = new HashMap<>();
//        inOrder(pRootOfTree, list, map);
//        TreeNode root = map.get(list.get(0));
//        root.right = null;
//        for (int i = 0; i < list.size(); i++) {
//            if (i == list.size() - 1) {
//                map.get(list.get(i)).left = null;
//                continue;
//            }
//            TreeNode node1 = map.get(list.get(i));
//            TreeNode node2 = map.get(list.get(i + 1));
//            node1.left = node2;
//            node2.right = node1;
//        }
//        return root;

    }

    private void inOrder(TreeNode root, ArrayList<Integer> list, Map<Integer, TreeNode> map) {
        if (root != null) {
            inOrder(root.left, list, map);
            list.add(root.val);
            map.put(root.val, root);
            inOrder(root.right,list,map);
        }
    }

    private void covertNode(TreeNode root, TreeNode lastNode) {
        if (root != null) {
            if (root.left != null) {
                covertNode(root.left, lastNode);
            }
            root.left = lastNode;
            if (lastNode != null) {
                lastNode.right = root;
            }
            lastNode = root;
            if (root.right != null) {
                covertNode(root.right, lastNode);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(4);
        node.left = node1;
        node.right = node2;
        TreeNode root = new Convert().Convert(node);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }
}
