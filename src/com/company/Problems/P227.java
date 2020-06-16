package com.company.Problems;

import java.util.Stack;

public class P227 {
    public static int calculate(String s) {
        String s1 = s.replace(" ", "");
        int n = s1.length();
        Stack<Integer> stack = new Stack();
        int num = 0;
        char op = '+';
        for (int i=0; i<n; i++) {
            char ch = s1.charAt(i);
            if (isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            if (!isDigit(ch) || i == n-1){
                if (op == '+') {
                    stack.push(num);
                }
                if (op == '-') {
                    stack.push(num * -1);
                }
                if (op == '*') {
                    int preNum = stack.pop();
                    num = num * preNum;
                    stack.push(num);
                }
                if (op == '/') {
                    int preNum = stack.pop();
                    num = preNum / num;
                    stack.push(num);
                }

                num = 0;
                op = ch;
            }
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
