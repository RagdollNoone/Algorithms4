package Chapter1.Ex_1_3;

import java.util.Stack;

public class EvaluatePostfix {
    static private Stack<String> stack = new Stack<String>();

    static public double evaluate() {
        String input = InfixToPostfix.convert();

        for (int i = 0; i < input.length(); i++) {
            String s = String.valueOf(input.charAt(i));

            if (s.equals("+") || s.equals("*") || s.equals("-")) {
                double v1 = Double.valueOf(stack.pop());
                double v2 = Double.valueOf(stack.pop());

                switch (s)
                {
                    case "+":
                        stack.push(String.valueOf(v2 + v1));
                        break;
                    case "-":
                        stack.push(String.valueOf(v2 - v1));
                        break;
                    case "*":
                        stack.push(String.valueOf(v2 * v1));
                        break;
                }
            }
            else
                stack.push(s);
        }

        System.out.println("Result is: " + Double.valueOf(stack.get(0)));
        return Double.valueOf(stack.get(0));
    }
}
