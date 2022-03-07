package com.antesh.dsa;

/*  Given a linked list, output it's reverse

    - Initialize three pointers prev as NULL, curr as head and next as NULL.
    - Iterate through the linked list. In loop, do following.
        // Before changing next of current,
        // store next node
        next = curr->next
        // Now change next of current
        // This is where actual reversing happens
        curr->next = prev
        // Move prev and curr one step forward
        prev = curr
        curr = next

    Time Complexity: O(n)
    Space Complexity: O(1)

*/
public class ReverseALinkedList {

    static Node root;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
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

    public static Node reverse(Node head) {
        if (head == null) {
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node temp = null;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        head = prev;
        return head;
    }

    public static void print(Node root) {
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }

        System.out.println("Print input list: ");
        print(root);

        System.out.println();
        root = reverse(root);
        System.out.println("Print reversed list: ");
        print(root);


    }
}
