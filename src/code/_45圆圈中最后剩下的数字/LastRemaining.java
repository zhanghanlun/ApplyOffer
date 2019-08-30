package code._45圆圈中最后剩下的数字;

public class LastRemaining {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        Node head = new Node(0);
        Node index = head;
        for (int i = 1; i < n; i++) {
            Node node = new Node(i);
            index.next = node;
            index = index.next;
        }
        index.next = head;
        Node result = head;
        Node pre = index;
        int count = 1;
        while (result.next != null) {
            if (count == m) {
                pre.next = result.next;
                result = result.next;
                count = 1;
            } else {
                pre = pre.next;
                result = result.next;
                count++;
            }
            if (pre.next == pre || result.next == result) {
                break;
            }
        }
        return result.val;
    }

    public static void main(String[] args){
        System.out.println(new LastRemaining().LastRemaining_Solution(5,3));
    }
}
