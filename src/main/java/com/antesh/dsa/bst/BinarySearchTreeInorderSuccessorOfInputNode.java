package com.antesh.dsa.bst;

public class BinarySearchTreeInorderSuccessorOfInputNode {

    public static void main(String[] args) {
        int[] arr = {20,8,22,4,12,10,14};

        int n = arr.length;

        BinarySearchTreeInorderSuccessorOfInputNode bst = new BinarySearchTreeInorderSuccessorOfInputNode();
        Node root =  null;
        for (int key: arr) {
            root = bst.insert(root, key);
        }

        System.out.println("In order successor of input node 8 in BST: " + bst.findInOrderSuccessorOfInputNode(root.left).key);
        System.out.println("In order successor of input node 10 in BST: " + bst.findInOrderSuccessorOfInputNode(root.left.right.left).key);
        System.out.println("In order successor of input node 14 in BST: " + bst.findInOrderSuccessorOfInputNode(root.left.right.right).key);
        System.out.println("In order successor of input node 22 in BST: " + bst.findInOrderSuccessorOfInputNode(root.right));
    }


    public Node findInOrderSuccessorOfInputNode(Node inputNode) {

        if (inputNode == null) {
            return null;
        }

        //if input node has right then find the most left node of the right node which will become in order successor
        if (inputNode.right != null) {
            return getMostLeft(inputNode.right);
        }

        //Else  traverse to parent of input node on the right till parent == null
        else {
            Node parent = inputNode.parent;
            Node child = inputNode;

            while (parent.right == child) {
                if (parent.parent == null) {
                    return null;
                }
                child = parent;
                parent = parent.parent;
            }

            return parent;
        }
    }

    private Node getMostLeft(Node inputNode) {
        if (inputNode.left == null) {
            return inputNode;
        } else {
            return getMostLeft(inputNode.left);
        }
    }

    public Node insert(Node root, int key) {

        if (root == null) {
            return new Node(key);
        } else {
            Node ptr = null;

            if (key <= root.key) {
                ptr =  insert(root.left, key);
                root.left = ptr;
                ptr.parent = root;
            } else {
                ptr = insert(root.right, key);
                root.right = ptr;
                ptr.parent = root;
            }
        }
        return root;
    }
}


class Node {
    int key;
    Node left;
    Node right;
    Node parent;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

}