package code._58二叉树的下一个结点;



class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class GetNext {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            return getNext(pNode.right);
        } else if (pNode.next != null) {
            TreeLinkNode father = pNode.next;
            TreeLinkNode current = pNode;
            while (father != null && current == current.right) {
                current = father;
                father = father.next;
            }
            return father;
        }
        return null;
    }

    private TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode leftNode = getNext(pNode.left);
        TreeLinkNode rightNode = getNext(pNode.right);
        if (leftNode != null) {
            return leftNode;
        } else {
            return pNode;
        }
    }

    public static void main(String[] args){

    }
}


