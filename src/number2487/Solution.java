package number2487;

import java.util.List;
import java.util.Stack;

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
        ListNode listNode = new ListNode(138);
        int[] a = {466, 216, 67, 642, 978, 264, 136, 463, 331, 60, 600, 223, 275, 856, 809, 167, 101, 846, 165, 575, 276, 409, 590, 733, 200, 839, 515, 852, 615, 8, 584, 250, 337, 537, 63, 797, 900, 670, 636, 112, 701, 334, 422, 780, 552, 912, 506, 313, 474, 183, 792, 822, 661, 37, 164, 601, 271, 902, 792, 501, 184, 559, 140, 506, 94, 161, 167, 622, 288, 457, 953, 700, 464, 785, 203, 729, 725, 422, 76, 191, 195, 157, 854, 730, 577, 503, 401, 517, 692, 42, 135, 823, 883, 255, 111, 334, 365, 513, 338, 65, 600, 926, 607, 193, 763, 366, 674, 145, 229, 700, 11, 984, 36, 185, 475, 204, 604, 191, 898, 876, 762, 654, 770, 774, 575, 276, 165, 610, 649, 235, 749, 440, 607, 962, 747, 891, 943, 839, 403, 655, 22, 705, 416, 904, 765, 905, 574, 214, 471, 451, 774, 41, 365, 703, 895, 327, 879, 414, 821, 363, 30, 130, 14, 754, 41, 494, 548, 76, 825, 899, 499, 188, 982, 8, 890, 563, 438, 363, 32, 482, 623, 864, 161, 962, 678, 414, 659, 612, 332, 164, 580, 14, 633, 842, 969, 792, 777, 705, 436, 750, 501, 395, 342, 838, 493, 998, 112, 660, 961, 943, 721, 480, 522, 133, 129, 276, 362, 616, 52, 117, 300, 274, 862, 487, 715, 272, 232, 543, 275, 68, 144, 656, 623, 317, 63, 908, 565, 880, 12, 920, 467, 559, 91, 698};
        for (int j : a) {
            listNode.add(j);
        }
        removeNodes(listNode);
    }

    public static ListNode removeNodes(ListNode head) {
        ListNode tmp = head;
        ListNode prev = null;
        while (tmp.next != null) {
            if (tmp.val < tmp.next.val) {
                if (prev != null) {
                    ListNode prev2 = prev;
                    while (prev2.val >= tmp.next.val) {
                        prev2 = prev2.next;
                    }
                    prev2.val = tmp.next.val;
                    prev2.next = tmp.next.next;
                    tmp = prev2;
                } else {
                    tmp.val = tmp.next.val;
                    tmp.next = tmp.next.next;
                }
            } else {
                if (prev == null) {
                    prev = tmp;
                }
                tmp = tmp.next;
            }
        }
        return head;
    }
}

////////////////////// официальное решение
//class Solution1 {
//    public ListNode removeNodes(ListNode head) {
//        Stack<ListNode> stack = new Stack<>();
//        ListNode current = head;
//
//        // Add nodes to the stack
//        while (current != null) {
//            stack.push(current);
//            current = current.next;
//        }
//
//        current = stack.pop();
//        int maximum = current.val;
//        ListNode resultList = new ListNode(maximum);
//
//        // Remove nodes from the stack and add to result
//        while (!stack.isEmpty()) {
//            current = stack.pop();
//            // Current should not be added to the result
//            if (current.val < maximum) {
//                continue;
//            }
//            // Add new node with current's value to front of the result
//            else {
//                ListNode newNode = new ListNode(current.val);
//                newNode.next = resultList;
//                resultList = newNode;
//                maximum = current.val;
//            }
//        }
//
//        return resultList;
//    }
//}
