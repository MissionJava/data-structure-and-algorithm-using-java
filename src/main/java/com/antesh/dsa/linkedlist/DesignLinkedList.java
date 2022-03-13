package com.antesh.dsa.linkedlist;
/*  Reference: https://github.com/aniketskulkarni/coding-problems/blob/master/LeetCode/src/com/java7/problem/easy/linkedlist/DesignLinkedList.java
*   Design a linked list data structure with below supported operations
*       - addAtHead(int data)
*       - addAtTail(int data)
*       - addAtIndex(int data)
*       - get(int index)
*       - deleteAtIndex(int index)
* */
public class DesignLinkedList implements LinkedList {
    Node head;
    int size;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public DesignLinkedList() {

    }

    @Override
    public void addAtHead(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
        size++;
    }

    @Override
    public void addAtTail(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            size++;
            return;
        }

        Node ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }

        ptr.next = temp;
        size++;
    }

    @Override
    public void addAtIndex(int data, int index) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(data);
            return;
        }

        if (index == size) {
            addAtTail(data);
            return;
        }

        Node newNode = new Node(data);
        Node currentNode = head;
        int currentIndex = 1;
        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }

        Node nextNode = currentNode.next;
        currentNode.next = newNode;
        newNode.next = nextNode;
        size++;
    }

    @Override
    public int get(int index) {

        if (size == 0 || index > size) {
            return -1;
        }

        Node currentNode = head;
        int currentIndex = 0;

        while (currentNode.next != null && currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }

        return currentNode.data;
    }

    @Override
    public int deleteAtIndex(int index) {
        if (size == 0 || index > size) {
            return -1;
        }

        if (index == 0) {
            Node temp = head;
            head = head.next;
            size--;
            return temp.data;
        }

        Node currentNode = head;
        int currentIndex = 0;
        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        Node temp = currentNode;
        Node nextNode = currentNode.next.next;
        currentNode.next = nextNode;
        size--;

        return temp.data;
    }

    public static void main(String[] args) {
        DesignLinkedList linkedList  = new DesignLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(2);
        linkedList.addAtTail(3);
        linkedList.addAtHead(4);
        linkedList.deleteAtIndex(0);
        linkedList.addAtIndex(100, 2);

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(3));
    }

}

interface LinkedList {
    void addAtHead(int data);
    void addAtTail(int data);
    void addAtIndex(int data, int index);
    int get(int index);
    int deleteAtIndex(int index);
}
