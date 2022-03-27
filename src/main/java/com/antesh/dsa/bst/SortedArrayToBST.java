package com.antesh.dsa.bst;


/*Given a sorted array, create a balanced BST and not skewed bst
 *
 * */


public class SortedArrayToBST {

    static class Node {
        int data;
        Node parent;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.parent = null;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "[" + data + "] --> ";
        }
    }

    public static Node sortedArrayToBalancedBST(int[] sortedArr, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = (low + high) / 2;

        Node node = new Node(sortedArr[mid]);
        System.out.print(sortedArr[mid] + " --> ");
        node.left = sortedArrayToBalancedBST(sortedArr, low, mid - 1);
        node.right = sortedArrayToBalancedBST(sortedArr, mid + 1, high);

        return node;
    }

    public static void main(String[] args) {
        int[] sortedArr = {11, 22, 33, 44, 55, 66, 77, 88};
        sortedArrayToBalancedBST(sortedArr, 0, sortedArr.length - 1);
    }
}
