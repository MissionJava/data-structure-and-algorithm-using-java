# Heap
## Complete Binary Tree Definition
- A binary tree is called complete binary tree when all the level of binary tree is completely filled except possibly the last level, which is filled from left side to right.
- Difference between a complete binary tree and a full binary tree is that, in a complete binary tree all leaf nodes should lean towards left and the last nodes need not to have a right sibling.


## Definition of Heap
According to Wikipedia, a Heap is a special type of binary tree. A heap is a binary tree that meets the following criteria:

- Is a complete binary tree;
- The value of each node must be no greater than (or no less than) the value of its child nodes.

A Heap has the following properties:
- Insertion of an element into the Heap has a time complexity of O(log N);
- Deletion of an element from the Heap has a time complexity of O(log N);
- The maximum/minimum value in the Heap can be obtained with O(1) time complexity

## Types of Heap
There are two kinds of heaps: **Max Heap** and **Min Heap**

**Max Heap:** Each node in the Heap has a value no less than its child nodes. Therefore, the top element (root node) has the largest value in the Heap.

**Min Heap:** Each node in the Heap has a value no larger than its child nodes. Therefore, the top element (root node) has the smallest value in the Heap.

![](https://github.com/MissionJava/data-structure-and-algorithm-using-java/tree/main/src/main/java/com/antesh/dsa/heap/min-and-max-heap-diagram.jpg)