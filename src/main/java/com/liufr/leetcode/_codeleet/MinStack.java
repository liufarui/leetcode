package com.liufr.leetcode._codeleet;

import java.util.Stack;

public class MinStack {
    /** initialize your data structure here. */
    private Stack<Integer> data;
    private Stack<Integer> minNum;

    public MinStack() {
        data = new Stack<>();
        minNum = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if(minNum.empty() || minNum.peek() > x) {
            minNum.push(x);
        } else {
            minNum.push(minNum.peek());
        }
    }

    public void pop() {
        data.pop();
        minNum.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minNum.peek();
    }
}
