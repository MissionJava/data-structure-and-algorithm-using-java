package com.antesh.dsa.linkedlist;


import java.util.List;

/**
 * Problem Reference: https://github.com/aniketskulkarni/coding-problems/blob/master/LeetCode/src/com/java7/problem/easy/linkedlist/OddEvenLinkedList.java
 *
 * Given the head of a singly linked list, group all the nodes with odd indices
 * together followed by the nodes with even indices, and return the reordered
 * list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 * Note that the relative order inside both the even and odd groups should
 * remain as it was in the input.
 * You must solve the problem in O(1) extra space complexity and O(n) time
 * complexity.
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 */

public class OddEvenLinkedList {
    ListNode head;

    class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addAtTail(int data) {
        if (head == null) {
            head = new ListNode(data);
            return;
        }

        ListNode currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        ListNode newNode = new ListNode(data);
        currentNode.next = newNode;
    }

    public static ListNode oddEvenLinkedList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode currentNode = head;        //1 -> 2 -> 3 -> 4 -> 5

        while (currentNode.next != null && currentNode.next.next != null) {
            ListNode nextNode = currentNode.next;       // 2 -> 3
            ListNode nextToNextNode = currentNode.next.next;    // 3 -> 4
            currentNode.next = currentNode.next.next;   //1 -> 3 -> 4
            //TODO:



        }


    }

}
