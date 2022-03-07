package com.antesh;

/*  Mirror of a Tree: Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.
*   (1)  Call Mirror for left-subtree    i.e., Mirror(left-subtree)
    (2)  Call Mirror for right-subtree  i.e., Mirror(right-subtree)
    (3)  Swap left and right subtrees.
              temp = left-subtree
              left-subtree = right-subtree
              right-subtree = temp
* */

public class MirrorOrSymmetryOrInvertedBSTree {
    static Node root;

    public static void display(Node node) {
        System.out.print(node.data + " ");
    }

    public static Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    public static void mirror() {
        root = mirror(root);
    }

    public static Node mirror(Node node) {
        if (node == null) {
            return node;
        }

        Node left = mirror(node.left);
        Node right = mirror(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

    static void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        for (int num: arr) {
            root = insert(root, num);
        }

        System.out.println("In order tree: ");
        inorder(root);

        mirror();

        System.out.println("\nIn order of mirror tree: ");
        inorder(root);

        System.out.println();
        root = null;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("In order tree: ");
        inorder(root);

        mirror();

        System.out.println("\nIn order of mirror tree: ");
        inorder(root);
    }
}




