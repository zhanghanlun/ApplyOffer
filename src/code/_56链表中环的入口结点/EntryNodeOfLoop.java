package code._56链表中环的入口结点;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class EntryNodeOfLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = getMeetingNode(pHead);
        if (meetingNode == null) {
            return null;
        }
        ListNode index = meetingNode.next;
        int count = 1;
        while (index != meetingNode) {
            count++;
            index = index.next;
        }
        ListNode index1 = pHead;
        ListNode index2 = pHead;
        for (int i = 0; i < count; i++) {
            index1 = index1.next;
        }
        while (index1 != index2) {
            index1 = index1.next;
            index2 = index2.next;
        }
        return index1;
    }

    ListNode getMeetingNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head.next;
        if (slow == null) {
            return null;
        }
        ListNode fast = slow.next;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return fast;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }
}
