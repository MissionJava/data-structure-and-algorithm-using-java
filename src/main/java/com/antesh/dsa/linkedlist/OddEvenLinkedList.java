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
    public ListNode head;

    class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode temp = head;
            while (temp!= null) {
                sb.append(temp.data).append(" --> ");
                temp = temp.next;
            }

            return sb.toString();
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

    public ListNode oddEvenLinkedList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode currentNode = head;        //1 -> 2 -> 3 -> 4 -> 5

        int size = 0;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }

        currentNode = head;
        int counter = size / 2;

        while (currentNode.next != null && currentNode.next.next != null && counter > 0) {
            int data = currentNode.next.data;
            currentNode.next = currentNode.next.next;
            addAtTail(data);
            currentNode = currentNode.next;
            counter--;
        }

        return head;
    }

    public static void main(String[] args) {
        //Odd length
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        oddEvenLinkedList.addAtTail(1);
        oddEvenLinkedList.addAtTail(2);
        oddEvenLinkedList.addAtTail(3);
        oddEvenLinkedList.addAtTail(4);
        oddEvenLinkedList.addAtTail(5);


        System.out.println("Original odd length linked list: " + oddEvenLinkedList.head);
        System.out.println("linked list after odd even position shuffling: " +oddEvenLinkedList.oddEvenLinkedList(oddEvenLinkedList.head));
        System.out.println();

        //Even length
        oddEvenLinkedList = new OddEvenLinkedList();
        oddEvenLinkedList.addAtTail(1);
        oddEvenLinkedList.addAtTail(2);
        oddEvenLinkedList.addAtTail(3);
        oddEvenLinkedList.addAtTail(4);
        oddEvenLinkedList.addAtTail(5);
        oddEvenLinkedList.addAtTail(6);

        System.out.println("Original even length linked list: " + oddEvenLinkedList.head);
        System.out.println("linked list after odd even position shuffling: " +oddEvenLinkedList.oddEvenLinkedList(oddEvenLinkedList.head));


    }

}
