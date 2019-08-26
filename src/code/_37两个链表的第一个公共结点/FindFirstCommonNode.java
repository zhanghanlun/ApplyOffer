package code._37两个链表的第一个公共结点;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class FindFirstCommonNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int count1 = 0;
        int count2 = 0;
        ListNode index2 = pHead2;
        ListNode index1 = pHead1;
        while (index1 != null) {
            count1++;
            index1 = index1.next;
        }
        while (index2 != null) {
            count2++;
            index2 = index2.next;
        }
        if (count1 > count2) {
            for (int i = 0; i < count1 - count2; i++) {
                pHead1 = pHead1.next;
            }
        } else {
            for (int i = 0; i < count2 - count1; i++) {
                pHead2 = pHead2.next;
            }
        }
        while (pHead1 != null && pHead2 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }
}
