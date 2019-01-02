package Exercise.Chapter1.Ex_1_3;

import Utility.StdIn;

import java.util.Stack;

public class Ex_1_3_9 {
    static private Stack stack1 = new Stack();
    static private Stack stack2 = new Stack();

    public static void DoExercise() {
        String in = StdIn.readString();

        for(int i = in.length() - 1; i >= 0; i--) {
            String s = String.valueOf(in.charAt(i));

            if (s.equals(")")) continue;
            else if (s.equals("-") || s.equals("+") || s.equals("*")) {
                if (s.equals("*")) {
                    if (!stack2.empty() && stack1.size() - stack2.size() == 1) {
                        if (stack2.lastElement().equals("*"))
                            op2();
                    }
                }

                stack2.push(s);
            }
            else {
                stack1.push(s);

                if (!stack2.empty() && stack1.size() - stack2.size() == 1) {
                    if (!stack2.lastElement().equals("*"))
                        op1();
                }
            }
        }


        if (!stack2.empty() && stack1.size() - stack2.size() == 1) op2();
        System.out.println("Result is: " + stack1.get(0));
    }

    public static void op1() {
        String s1 = (String)stack1.pop();
        String s2 = (String)stack2.pop();
        String s3 = (String)stack1.pop();

        String New = s1 + s2 + s3;
        stack1.push(New);
    }

    public static void op2() {
        String s1 = (String)stack1.pop();
        String s2 = (String)stack1.pop();
        String s3 = (String)stack2.pop();

        if (s1.indexOf("(") == -1 && s1.length() > 1) s1 = "(" + s1 + ")";
        if (s2.indexOf("(") == -1 && s2.length() > 1) s2 = "(" + s2 + ")";

        String New = "(" + s1 + s3 + s2 + ")";
        stack1.push(New);
    }
}
