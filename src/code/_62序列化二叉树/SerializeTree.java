package code._62序列化二叉树;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class SerializeTree {

    private static int index = -1;

    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        index++;
        String[] strs = str.split(",");
        TreeNode node = null;
        int length = strs.length;
        if (index >= length) {
            return null;
        }
        if (!strs[index].equals("#")) {
            node = new TreeNode(Integer.parseInt(strs[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
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
        String str = new SerializeTree().Serialize(root);
        TreeNode node = new SerializeTree().Deserialize(str);
        System.out.println(str);
        System.out.println(node.val);
    }
}
