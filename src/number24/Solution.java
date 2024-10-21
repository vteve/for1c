package number24;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    void add(int val) {
        ListNode tmp = this;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new ListNode();
        tmp.next.val = val;
        tmp.next.next = null;
    }
}

public class Solution {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4};
        ListNode listNode = new ListNode(1);
        for (int j : arr) {
            listNode.add(j);
        }
        swapPairs(listNode);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head.next.next, prev = head;
        ListNode head2 = head;
        ListNode head3 = head.next.next;
        head = head.next;
        head.next = head2;
        head.next.next = head3;
        while (tmp != null) {
            if (tmp.next != null) {
                ListNode tmp2 = tmp;
                ListNode tmp3 = tmp.next.next;
                tmp = tmp.next;
                tmp.next = tmp2;
                tmp.next.next = tmp3;
                prev.next = tmp;
                prev = tmp2;
            }
            tmp = tmp.next;
            if (tmp != null) {
                tmp = tmp.next;
            }
        }
        return head;
    }
}

/////// очень крутое решение
//class Solution {
//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode temp = head.next;
//        head.next = swapPairs(head.next.next);
//        temp.next = head;
//
//        return temp;
//    }
//}

