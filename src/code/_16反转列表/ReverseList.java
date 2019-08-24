package code._16反转列表;

import java.util.List;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class ReverseList {



    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode index;
        ListNode result = head;
        head = head.next;
        result.next = null;
        while (head != null) {
            index = head;
            head = head.next;
            index.next = result;
            result = index;
        }
        return result;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        ListNode node = new ReverseList().ReverseList(node1);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }

    }
}
