package Exercise.Chapter1.Ex_1_3;

import Utility.StdIn;

import java.util.Stack;

public class InfixToPostfix {

    static private Stack<String> stack1 = new Stack<String>();
    static private Stack<String> stack2 = new Stack<String>();
    static private int leftBracketNum = 0;

    static public String convert() {
        String in = StdIn.readString();

        for(int i = 0; i < in.length(); i++) {
            String s = String.valueOf(in.charAt(i));

            if (s.equals("+") || s.equals("-") || s.equals("*")) {
                stack2.push(s);
            }
            else if(s.equals(")")) {
                op1();
                op2();
            }
            else {
                stack1.push(s);

                if (s.equals("(")) leftBracketNum++;
                else
                    op2();
            }
        }

        System.out.println("Result is: " + stack1.get(0));
        return stack1.get(0);
    }


    static private void op1() {
        String s1 = stack1.pop();
        String s2 = stack1.pop();
        String s3 = stack2.pop();

        stack1.pop(); // 弹出左括号
        leftBracketNum--;

        stack1.push(s2 + s1 + s3);
    }

    static private void op2() {
        if (leftBracketNum > 0)
            return;

        if (stack1.size() - stack2.size() == 1 && stack2.size() > 0) {
            String s1 = stack1.pop();
            String s2 = stack1.pop();
            String s3 = stack2.pop();

            stack1.push(s2 + s1 + s3);
        }
    }
}
