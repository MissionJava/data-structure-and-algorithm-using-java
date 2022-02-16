package com.antesh.interview.nvidia;

/*
 * Goal is to find the loop in LinkedList without extra space
 * */

public class FindLoopInLinkedList {

    public static Node root;

    public static Node insertNode(Node root, int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = null;

        if (root == null) {
            root = temp;
        } else {
            Node ptr = root;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = temp;
        }
        return root;
    }

    public static boolean detectLoop() {
        Node p_slow = root;
        Node p_fast = root;

        while (p_slow != null && p_fast != null && p_fast.next != null) {
            p_slow = p_slow.next;
            p_fast = p_fast.next.next;
            if (p_fast == p_slow) {
                return true;
            }
        }
        return false;
    }

    public static void print(Node root) {
        while (root != null) {
            System.out.print(root.data + " -> ");
            root = root.next;
        }
        System.out.println();
    }

    //driver
    public static void main(String[] args) {
        int[] arr = new int[]{5, 25, 10, 35, 40};
        for (int num : arr) {
            root = insertNode(root, num);
        }

        print(root);
        System.out.println("Is Loop present in LinkedList? \nAns: " + detectLoop());
    }

    static class Node {
        int data;
        Node next;
    }
}
