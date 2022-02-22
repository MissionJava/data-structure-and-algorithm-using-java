package com.antesh.dsa.stack;

public class StackUsingArray {

    private final int size = 10;
    private int top;
    private int[] stack = new int[size];

    public StackUsingArray() {
        this.top = -1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return 0;
        }

        return stack[top];
    }

    public boolean push(int data) {
        if (top >= size - 1) {
            System.out.println("Stack overflow");
            return false;
        }

        stack[++top] = data;
        System.out.println(data + " pushed into the stack");
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return 0;
        }

        int data = stack[top--];
        return data;
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray();

        System.out.println(stack.isEmpty());

        stack.push(10);
        stack.push(30);
        stack.push(20);
        stack.push(50);
        System.out.println(stack.peek());
        System.out.println(stack.pop());

    }
}
