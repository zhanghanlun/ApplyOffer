package code._57删除列表中重复的结点;


import java.util.List;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class DeleteDuplication {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null){
            return null;
        }
        int duplicateNum = Integer.MAX_VALUE;
        while (pHead.val == duplicateNum || (pHead.next != null && pHead.val == pHead.next.val)) {
            duplicateNum = pHead.val;
            pHead = pHead.next;
            if (pHead == null) break;
        }
        if (pHead == null){
            return null;
        }
        ListNode indexPre = pHead;
        ListNode index = pHead.next;
        while (index != null && index.next != null) {
            if (index.val == index.next.val) {
                duplicateNum = index.val;
                while (index != null && index.val == duplicateNum) {
                    index = index.next;
                }
                indexPre.next = index;
                if (index == null){
                    break;
                }
            }else{
                index = index.next;
                indexPre = indexPre.next;
            }

        }
        return pHead;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode pHead = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode head = new DeleteDuplication().deleteDuplication(node1);
        while (head!=null){
            System.out.println(head.val);
            head= head.next;
        }

    }
}
