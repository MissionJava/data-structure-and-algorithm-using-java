# data-structure-and-algorithm-using-java

This repository includes data structure and algorithm solutions, and solutions of the live coding interview questions asked at different companies over a video call.

##Data Structure

### Stack
 - linear data structure which follows LIFO or FILO
 - push(), pop(), peek(), isEmpty() all take O(1) and no looping required
    
   ####Application of Stack
     - String reversal
     - Tower of Hanoi
     - Infix to Postfix/Prefix conversion
     - Tree traversal
     - [Stock span problem](https://www.geeksforgeeks.org/the-stock-span-problem)
       - The stock span problem is a financial problem where we have a series of n daily price quotes for a stock, 
         and we need to calculate span of stock’s price for all n days.
     - Backtracking problems: Knight-Tour problem, N-Queen problem, find your way through a maze, and game-like 
       chess or checkers in all these problems we dive into someway if that way is not efficient we come back to
       the previous state and go into some another path. To get back from a current state we need to store the 
       previous state for that purpose we need a stack.
   
   ####Implementation of Stack
   - [Using Arrays](https://github.com/MissionJava/data-structure-and-algorithm-using-java/blob/main/src/main/java/com/antesh/dsa/stack/StackUsingArray.java)
   - [Using Linked list](https://github.com/MissionJava/data-structure-and-algorithm-using-java/blob/main/src/main/java/com/antesh/dsa/stack/StackUsingLinkedList.java)
     - Pros: The linked list implementation of a stack can grow and shrink according to the needs at runtime. 
     - Cons: Requires extra memory due to involvement of pointers.
