package com.antesh.dsa.stack;

import java.util.Stack;

public class InfixToPostFixExpressionUsingStack {

    public static int precendence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }

        return -1;
    }

    //using stack
    public static String infixToPostfix(String expr) {
        String result = new String();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {

            char c = expr.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precendence(c) <= precendence(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid expression";
            }

            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        String expression = "a+b*(c^d-e)^(f+g*h)-i";

        System.out.println("Infix to postfix conversion of " + expression + " is: " + infixToPostfix(expression));
    }
}
