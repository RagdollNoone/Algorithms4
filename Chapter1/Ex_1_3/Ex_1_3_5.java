package Chapter1.Ex_1_3;

import java.util.Stack;

public class Ex_1_3_5 {
    public static void DoExercise() {
        int N = 50;

        Stack<Integer> stack = new Stack<Integer>();
        while(N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }

        for(int d : stack) System.out.print(d); // foreach不会继承栈的特性
        System.out.println();
        for(int i = stack.size() - 1; i >= 0; i--) System.out.print(stack.get(i));
    }
}
