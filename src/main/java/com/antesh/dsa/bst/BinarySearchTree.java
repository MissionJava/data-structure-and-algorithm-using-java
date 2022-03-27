package com.antesh.dsa.bst;

/*
 * https://www.javatpoint.com/binary-tree
 * */
public class BinarySearchTree {
    public Node root;

    public BinarySearchTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(20);
        bst.insert(30);
        bst.insert(60);
        bst.insert(10);
        bst.insert(70);
        bst.insert(40);
        System.out.println("Inorder traversal of binary search tree");
        bst.inorder(bst.root);

        System.out.println("\nPreorder traversal of binary search tree");
        bst.preorder(bst.root);

        System.out.println("\nPostorder traversal of binary search tree");
        bst.postorder(bst.root);

        System.out.print(bst.search(40) ? "\n40 found in BST" : "\n40 not found in BST");
        System.out.print(bst.search(90) ? "\n90 found in BST" : "\n90 not found in BST");
        System.out.println("\nLargest node in BST: " + bst.findLargestNodeInBST(bst.root));
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    public Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }

        return node;
    }

    public boolean search(int key) {
        Node current = root;

        while (current.data != key) {
            if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }

        return true;
    }

    public int findLargestNodeInBST(Node node) {
        if (node == null) {
            System.out.println("Tree is empty");
            return 0;
        }

        int leftMax;
        int rightMax;
        int max = node.data;

        if (node.left != null) {
            leftMax = findLargestNodeInBST(node.left);
            max = Math.max(max, leftMax);
        }

        if (node.right != null) {
            rightMax = findLargestNodeInBST(node.right);
            max = Math.max(max, rightMax);
        }

        return max;
    }

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            node.display();
            inorder(node.right);
        }
    }

    public void preorder(Node node) {
        if (node != null) {
            node.display();
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            node.display();

        }
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void display() {
            System.out.print(data + " ");
        }
    }
}
