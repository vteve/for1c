package number23;

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
        ListNode[] tmps = new ListNode[3];
//        int[][] arr = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
//        for (int i = 0; i < 3; i++) {
//            tmps[i] = new ListNode(arr[i][0]);
//            for (int j = 1; j < arr[i].length; j++) {
//                tmps[i].add(arr[i][j]);
//            }
//        }
        mergeKLists(tmps);
    }

    public static ListNode findMin(ListNode[] tmps) {
        ListNode minListNode = null;
        int minValue = Integer.MAX_VALUE;
        for (ListNode tmp : tmps) {
            if (tmp != null && tmp.val < minValue) {
                minValue = tmp.val;
                minListNode = tmp;
            }
        }
        for (int i = 0; i < tmps.length; i++) {
            if (tmps[i] != null && tmps[i].equals(minListNode)) {
                tmps[i] = tmps[i].next;
                break;
            }
        }
        return minListNode;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int k = 0;
        for (ListNode list : lists) {
            ListNode tmp = list;
            while (tmp != null) {
                k++;
                tmp = tmp.next;
            }
        }
//        ListNode[] tmps = new ListNode[lists.length];
        ListNode answer = new ListNode();
        while (k > 0) {
            ListNode min = findMin(lists);
            ListNode tmp = answer;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new ListNode();
            tmp.next.val = min.val;
            tmp.next.next = null;
//            min.val = min.next.val;
//            min.next = min.next.next;
            k--;
        }
        if (answer.next != null) {
            answer.val = answer.next.val;
            answer.next = answer.next.next;
            return answer;
        } else return null;
    }
}
