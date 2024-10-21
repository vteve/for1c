package number206;

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
    public ListNode reverseList(ListNode head) {
        ListNode newList = null;
        ListNode node = head;
        ListNode nextNode;
        while (node != null){
            nextNode = node.next;
            node.next = newList;
            newList = node;
            node = nextNode;
        }
        return newList;
    }
}
