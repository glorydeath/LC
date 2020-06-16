package com.company.Problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P22 {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<String>();
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        generate(stack, n, sb, results, n);
        return results;
    }

    public void generate(Stack<Character> stack, int leftNum, StringBuilder sb, List<String> results, int n) {
        if (sb.length() == 2 * n) {
            results.add(sb.toString());
            return;
        }
        if (leftNum > 0) {
            sb.append('(');
            leftNum--;
            stack.push('(');
            generate(stack, leftNum, sb, results, n);
            sb.setLength(sb.length() - 1);
            leftNum++;
            stack.pop();
        }
        if (!stack.empty()) {
            sb.append(')');
            stack.pop();
            generate(stack, leftNum, sb, results, n);
            sb.setLength(sb.length() - 1);
            stack.push('(');
        }
        return;
    }
}
