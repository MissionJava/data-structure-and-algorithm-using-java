package com.antesh.dsa.linkedlist;
/**
 * Problem Reference: https://github.com/aniketskulkarni/coding-problems/blob/master/LeetCode/src/com/java7/problem/easy/linkedlist/AddTwoNumbersLinkedList.java
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbersLinkedList {

    Node n1;
    Node n2;
    Node result;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public String print(Node n) {
        StringBuilder sb = new StringBuilder();
        Node ptr = n;
        while (ptr != null) {
            sb.append(ptr.data).append(" --> ");
            ptr = ptr.next;
        }
        return sb.toString();
    }

    public Node addToTail(Node head, int data) {
        if (head == null) {
            head = new Node(data);
            return head;
        }

        Node ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new Node(data);

        return head;
    }

    public Node addTwoNumbers(Node n1, Node n2) {
        if (n1 == null && n2 == null) return null;
        if (n1 == null) return n2;
        if (n2 == null) return n1;

        Node result = null;
        int carry = 0;

        while (n1 != null && n2 != null) {
            int sum = carry + n1.data + n2.data;
            if ( sum > 9) {
                carry = 1;
                sum = sum % 10;
            }

            result = addToTail(result, sum);

            n1 = n1.next;
            n2 = n2.next;
        }

        while (n1 != null) {
            addToTail(result, n1.data + carry);
            carry = 0;
            n1 = n1.next;
        }

        while (n2 != null) {
            addToTail(result, n2.data + carry);
            carry = 0;
            n2 = n2.next;
        }

        if (carry > 0) {
            result = addToTail(result, carry);
        }

        return result;
    }

    public static void main(String[] args) {
        AddTwoNumbersLinkedList list = new AddTwoNumbersLinkedList();
        for (int i = 3; i < 6; i++) {
            list.n1 = list.addToTail(list.n1, i);
            list.n2 = list.addToTail(list.n2, i);
        }

        System.out.println("n1: " + list.print(list.n1));
        System.out.println("n2: " + list.print(list.n2));
        list.result = list.addTwoNumbers(list.n1, list.n2);
        System.out.println("sum: " + list.print(list.result));
    }
}
