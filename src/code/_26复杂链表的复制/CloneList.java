package code._26复杂链表的复制;


import java.util.HashMap;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class CloneList {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode index = pHead;
        RandomListNode result = new RandomListNode(index.label);
        RandomListNode indexClone = result;
        while (index.next != null) {
            RandomListNode node = new RandomListNode(index.next.label);
            indexClone.next = node;
            indexClone = indexClone.next;
            index = index.next;
        }
        index = pHead;
        indexClone = result;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (index != null) {
            map.put(index, indexClone);
            index = index.next;
            indexClone = indexClone.next;
        }
        index = pHead;
        indexClone = result;
        while (index != null) {
            if (index.random != null) {
                indexClone.random = map.get(index.random);
            }
            index = index.next;
            indexClone = indexClone.next;
        }
        return result;
    }



    private void cloneFirst(RandomListNode pHead){
        RandomListNode index = pHead;
        while (index != null) {
            RandomListNode node = new RandomListNode(index.label);
            RandomListNode temp = index;
            index = index.next;
            temp.next = node;
            node.next = index;
        }
    }

    private void completeLinked(RandomListNode pHead) {
        RandomListNode index = pHead;
        while (index != null) {
            RandomListNode index1 = index;
            RandomListNode index2 = index.next;
            if (index1.random !=null){
                index2.random = index1.random.next;
            }
            index = index.next.next;
        }
    }

    private RandomListNode getClone(RandomListNode pHead){
        RandomListNode index = pHead;
        RandomListNode result = pHead.next;
        while (index.next.next != null) {
            RandomListNode index1 = index;
            RandomListNode index2 = index.next;
            index = index.next.next;
            index1.next = index2.next;
            index2.next = index1.next.next;
        }
        return result;
    }

    public static void main(String[] args){
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1.random = node3;
        node2.random = node4;
        node3.random = node1;
        node4.random = node2;
        RandomListNode node = new CloneList().Clone(node1);
        while (node != null) {
            System.out.println(node.label);
            System.out.println(node.random.label);
            node = node.next;
        }
    }
}
