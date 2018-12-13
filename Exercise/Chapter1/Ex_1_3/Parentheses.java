package Exercise.Chapter1.Ex_1_3;

import IO.StdIn;

import java.util.Stack;

public class Parentheses
{
    static private String[] target = {"[", "]", "{", "}", "(", ")"};
    static private Stack<String> stack = new Stack<String>();

    public static void check() {
        while(!StdIn.isEmpty()) {
            stack.clear();
            String s = StdIn.readString();

            for(int i = 0; i < s.length(); i++) {
                String temp = String.valueOf(s.charAt(i));

                boolean isTarget = isInputValid(temp);
                if (!isTarget) System.out.println("Result is: false");;

                if (stack.isEmpty()) {
                    stack.push(temp);
                    continue;
                }

                if (isMatch(stack.peek(), temp)) {
                    stack.pop();
                    continue;
                }
                else {
                    stack.push(temp);
                }
            }

            System.out.println("Result is: " + stack.isEmpty());
        }
    }

    public static boolean isInputValid(String s) {
        for (int i = 0; i < target.length; i++) {
            if (s.equals(target[i])) {
                return true;
            }
        }

        return false;
    }

    public static boolean isMatch(String s1, String s2) {
        int index1 = -1; int index2 = -1;

        for (int i = 0; i < target.length; i++) {
            if (s1.equals(target[i])) index1 = i;
            if (s2.equals(target[i])) index2 = i;
        }

        if (index1 == 0 && index2 == 1) return true;
        if (index1 == 2 && index2 == 3) return true;
        if (index1 == 4 && index2 == 5) return true;

        return false;
    }
}
