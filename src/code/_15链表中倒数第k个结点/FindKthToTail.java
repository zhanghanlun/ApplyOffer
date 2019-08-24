package code._15链表中倒数第k个结点;

public class FindKthToTail {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode index = head;
        ListNode result = head;
        for (int i = 1; i < k; i++) {
            if (index.next != null) {
                index = index.next;
            } else {
                return null;
            }
        }
        while (index.next != null) {
            index = index.next;
            result = result.next;
        }
        return result;
    }
}
