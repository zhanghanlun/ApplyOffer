package code._17合并两个排序的链表;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeList {


    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1==null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode head;
        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        head.next = null;
        ListNode point = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                point.next = list1;
                list1 = list1.next;
            } else {
                point.next = list2;
                list2 = list2.next;
            }
            point = point.next;
            point.next = null;
        }
        if (list1 != null) {
            point.next = list1;
        }
        if (list2 != null) {
            point.next = list2;
        }
        return head;
    }
}
