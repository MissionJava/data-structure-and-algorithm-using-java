package com.antesh.dsa.linkedlist;

public class FindLoopInLinkedList {

    public static Node root;
    public static int size = 0;


    static class Node {
        int data;
        Node next;

        public Node() {
        }
    }

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
        size++;
        return root;
    }

    public static boolean detectLoop() {
        int count = 0;
        while (root != null) {
            if (root.next == null) {
                return false;
            }
            if (count > size) {
                return true;
            }
            root = root.next;
            count++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 25, 10, 35, 40};
        for (int num : arr) {
            root = insertNode(root, num);
        }

        root.next.next.next.next.next = root.next.next;

        System.out.println("Is Loop present in LinkedList? \nAns: " + detectLoop());
    }

}
