package reverseLinkedList;


import java.util.ArrayList;
import java.util.List;

class mList {
    ListNode listNode;

    mList() {
    }

    void add(int val) {
        if (listNode != null) {
            listNode.add(val);
        } else {
            listNode = new ListNode(val);
        }
    }

    public ListNode reverse() {
        if (listNode != null) {
            return listNode.reverse();
        }
        return null;
    }
}

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

    ListNode reverse() {
        ListNode list = this;
        ListNode newList = null;
        ListNode node = list;
        ListNode nextNode;
        while (node != null) {
            nextNode = node.next;
            node.next = newList;
            newList = node;
            node = nextNode;
        }
        return newList;
    }
}

public class Main {
    public static void main(String[] args) {
        mList list = new mList();
        list.add(1);
        list.add(2);
        list.add(3);
//        ListNode list = new ListNode(1);
//        list.add(2);
//        list.add(3);
        ListNode newList = list.reverse();
        while (newList != null) {
            System.out.print(newList.val + " ");
            newList = newList.next;
        }
    }
}
