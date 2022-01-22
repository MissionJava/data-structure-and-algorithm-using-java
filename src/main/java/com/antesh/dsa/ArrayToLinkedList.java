package com.antesh.dsa;

/*
* time complexity for insert operation is O(n)
* */

public class ArrayToLinkedList {

    public static Node root;

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int n = arr.length;
        //slow insertion approach
        root = convertArrayToLinkedListSlow(arr, n);
        display(root);

        //fast insertion operation approach
        root = null;
        root = convertArrayToLinkedListFast(arr, n);
        System.out.println();
        display(root);
    }

    private static Node convertArrayToLinkedListSlow(int[] arr, int n) {
        for (int data : arr) {
            root = insertUsingWhileLoop(root, data);  //slow insertion operation
        }

        return root;
    }

    private static Node convertArrayToLinkedListFast(int[] arr, int n) {
        for (int i = n-1; i>= 0; i--) {
            root = insertUsingWithoutWhileLoop(root, arr[i]);  //slow insertion operation
        }

        return root;
    }


    // traversing till end of node and then insert new node at the end causing slow insert
    public static Node insertUsingWhileLoop(Node root, int data) {
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

    // insert new node at the start of root result in fast insertion
    public static Node insertUsingWithoutWhileLoop(Node root, int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = root;

        root = temp;

        return root;
    }

    public static void display(Node root) {
        while (root != null) {
            System.out.print("[ " + root.data + " | next ] --> ");
            root = root.next;
        }

        System.out.print("null");
    }

    static class Node {
        int data;
        Node next;
    }
}
