package com.antesh.dsa.linkedlist;

/*
* 24. Swap Nodes in Pairs
* Given a linked list, swap every two adjacent nodes and return its head.
* You must solve the problem without modifying the values in the list's
* nodes (i.e., only nodes themselves may be changed.)
*
* Input: head = [1,2,3,4]
* Output: [2,1,4,3]
*
* Input: head = []
* Output: []
*
* Input: head = [1]
* Output: [1]
* */

import java.util.Objects;

public class SwapNodesInPair {

    public static ListNode head;

    class ListNode {
        int data;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int data) {
            this.data = data;
        }
    }

    public ListNode insert(ListNode head, int data) {
        if (Objects.isNull(head)) {
            return new ListNode(data);
        }
        ListNode temp = new ListNode(data);
        ListNode ptr = head;

        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = temp;

        return head;
    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode previous = dummy;

        while(current != null && current.next != null) {
            previous.next = current.next;
            current.next = previous.next.next;
            previous.next.next = current;
            previous = current;
            current = current.next;
        }
        return dummy.next;
    }

    public void print(ListNode head) {
        ListNode ptr = head;
        System.out.print("[ ");
        while (ptr != null) {
            System.out.print(ptr.data + " --> ");
            ptr = ptr.next;
        }
        System.out.print(" ]");
        System.out.println();
    }

    public static void main(String[] args) {
        SwapNodesInPair swap = new SwapNodesInPair();

        head = swap.insert(head, 1);
        head = swap.insert(head, 2);
        head = swap.insert(head, 3);
        head = swap.insert(head, 4);

        swap.print(head);

        ListNode result = swap.swapPairs(head);

        swap.print(result);
    }
}
