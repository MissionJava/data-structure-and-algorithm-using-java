package com.antesh.problems;


/*  Given a singly linked list of characters, write a function that returns true if the given list is a palindrome,
    else false.

    Input: R -> A -> D -> A -> R
    Output: true

    Input: 1 -> 2 -> 3 -> 2 -> 1
    Output: true
*
* */

import java.util.Stack;

public class IsSinglyLinkedListPalindrome {

    static Node root;

    public static void main(String[] args) {
        root = insert(root, 1);
        root = insert(root, 2);
        root = insert(root, 3);
        root = insert(root, 2);
        root = insert(root, 1);

        System.out.println(isPalindrome(root));
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        Node temp = new Node(data);
        Node ptr = root;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = temp;

        return root;
    }

    static boolean isPalindrome(Node root) {
        Node ptr = root;

        Stack<Integer> stack = new Stack<>();

        while (ptr != null) {
            stack.push(ptr.data);
            ptr = ptr.next;
        }

        while (root != null) {
            int n = stack.pop();
            if (root.data != n) {
                return false;
            }
            root = root.next;
        }

        return true;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "[" + data + " | next] --> " + next;
        }
    }
}
