package Leetcode;

import java.util.Stack;

class day34 {

    // 150. Evaluate Reverse Polish Notation
    private int func(int a, int b , String c){
        if(c.equals("+")) {
            return a+b;
        }
        else if(c.equals("-")){
            return a-b;
        }
        else if(c.equals("*")){
            return (int) ((long)a* (long)b);
        }
        else if(c.equals("/")){
            return a/b;
        }
        return -1;
    }


    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int result = 0;

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int b = st.pop();
                int a = st.pop();

                result = func(a, b, s);
                st.push(result);
            } else {
                st.push(Integer.parseInt(s));
            }
        }

        return st.pop();
    }

    public static void main(String[] args) {
        System.out.println("let us start.");
    }
    
}