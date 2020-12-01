package com.github.liufr._codeleet;

public class evalRPN {
    public int evalRPN(String[] tokens) {
        int[] numStack = new int[tokens.length/2 + 1];
        int index = 0;
        for (int i=0; i<tokens.length; i++) {
            switch (tokens[i]){
                case "*":
                    numStack[index - 2] *= numStack[--index];
                    break;
                case "+":
                    numStack[index - 2] += numStack[--index];
                    break;
                case "/":
                    numStack[index - 2] /= numStack[--index];
                    break;
                case "-":
                    numStack[index - 2] -= numStack[--index];
                    break;
                default:
                    numStack[index++] = Integer.valueOf(tokens[i]);
                    break;
            }
        }
        return numStack[0];
    }
}
