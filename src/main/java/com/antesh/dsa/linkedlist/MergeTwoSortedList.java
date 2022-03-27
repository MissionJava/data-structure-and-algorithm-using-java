package com.antesh.dsa.linkedlist;

/**
 * Problem Reference: https://github.com/aniketskulkarni/coding-problems/blob/master/LeetCode/src/com/java7/problem/easy/linkedlist/MergeTwoSortedLists.java
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing
 * together the nodes of the first two lists.
 * Return the head of the merged linked list. Duplicate nodes should be retained.
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Input: list1 = [], list2 = []
 * Output: []
 */
public class MergeTwoSortedList {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node addToTail(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }
        Node temp = new Node(data);
        Node ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }

        ptr.next = temp;
        return head;
    }

    public String print(Node node) {
        StringBuilder sb = new StringBuilder();
        Node ptr = node;
        while (ptr != null) {
            sb.append(ptr.data).append(" --> ");
            ptr = ptr.next;
        }

        return sb.toString();
    }

    public Node mergeTwoSortedList(Node n1,Node n2) {
        if (n1 == null && n2 == null) {
            return null;
        }

        if (n1 == null) {
            return n2;
        }

        if (n2 == null) {
            return n1;
        }

        Node mergeList = null;
        while (n1 != null && n2 != null) {
            if (n1.data < n2.data) {
                mergeList = addToTail(mergeList, n1.data);
                n1 = n1.next;
            } else {
                mergeList = addToTail(mergeList, n2.data);
                n2 = n2.next;
            }
        }

        while (n1 != null) {
            mergeList = addToTail(mergeList, n1.data);
            n1 = n1.next;
        }

        while (n2 != null) {
            mergeList = addToTail(mergeList, n2.data);
            n2 = n2.next;
        }

        return mergeList;
    }

    public static void main(String[] args) {
        MergeTwoSortedList list = new MergeTwoSortedList();

        test1(list);
        System.out.println();
        test2(list);
    }

    private static void test1(MergeTwoSortedList list) {
        Node sortedList1 = null;
        for (int i = 1; i < 4; i++) {
            sortedList1 = list.addToTail(sortedList1, i);
        }

        Node sortedList2 = null;
        for (int i = 2; i < 5; i++) {
            sortedList2 = list.addToTail(sortedList2, i);
        }

        System.out.println("sortedList1 : " + list.print(sortedList1));
        System.out.println("sortedList2 : " + list.print(sortedList2));
        System.out.println("merged list : " + list.print(list.mergeTwoSortedList(sortedList1, sortedList2)));
    }

    private static void test2(MergeTwoSortedList list) {
        Node sortedList1 = null;
        sortedList1 = list.addToTail(sortedList1, 1);
        sortedList1 = list.addToTail(sortedList1, 2);
        sortedList1 = list.addToTail(sortedList1, 4);

        Node sortedList2 = null;
        sortedList2 = list.addToTail(sortedList2, 1);
        sortedList2 = list.addToTail(sortedList2, 3);
        sortedList2 = list.addToTail(sortedList2, 4);

        System.out.println("sortedList1 : " + list.print(sortedList1));
        System.out.println("sortedList2 : " + list.print(sortedList2));
        System.out.println("merged list : " + list.print(list.mergeTwoSortedList(sortedList1, sortedList2)));
    }
}
