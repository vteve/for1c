

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
}

public class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode tmp = ans;
        tmp.val = 0;
        while (l1 != null && l2 != null) {
            if (l1.val + l2.val + tmp.val > 9) {
                tmp.val = (l1.val + l2.val + tmp.val) % 10;
                tmp.next = new ListNode(1);
            } else {
                tmp.val = l1.val + l2.val + tmp.val;
                if (l1.next != null || l2.next != null) {
                    tmp.next = new ListNode(0);
                }
            }
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            if (l1.val + tmp.val > 9) {
                tmp.val = (l1.val + tmp.val) % 10;
                tmp.next = new ListNode(1);
            } else {
                tmp.val = l1.val + tmp.val;
                if (l1.next != null) {
                    tmp.next = new ListNode(0);
                }
            }
            tmp = tmp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            if (l2.val + tmp.val > 9) {
                tmp.val = (l2.val + tmp.val) % 10;
                tmp.next = new ListNode(1);
            } else {
                tmp.val = l2.val + tmp.val;
                if (l2.next != null) {
                    tmp.next = new ListNode(0);
                }
            }
            tmp = tmp.next;
            l2 = l2.next;
        }
        return ans;
    }
}