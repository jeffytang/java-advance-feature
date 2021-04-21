package com.twq.collection;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        // 栈，线性结构
        Stack<String> stack = new Stack<>();

        // 栈包含了 栈顶 和 栈底
        // 称为入栈(压栈)
        stack.push("Hello");
        stack.push("World");

        // 出栈，将栈顶的元素出栈
        String element = stack.pop();

        // 压栈
        stack.push("Good");
        stack.push("Day");

        // 出栈
        element = stack.pop();

        // 栈的特点：先进后出(后进先出)

        // 出栈
        element = stack.pop();

        // 出栈
        element = stack.pop();

        // 是空的话，出栈抛异常
        element = stack.pop();

        System.out.println("出栈的元素：" + element);
        System.out.println(stack);
    }
}
