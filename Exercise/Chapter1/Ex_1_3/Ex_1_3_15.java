package Exercise.Chapter1.Ex_1_3;

import java.util.LinkedList;
import java.util.Queue;

public class Ex_1_3_15 {
    static private Queue<Integer> queue = new LinkedList<Integer>();

    static public void DoExercise() {
        int k = 10;

        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }

        printQueue();

        int travel = 0;
        for (Integer x : queue) {
            if (travel == queue.size() - k) {
                System.out.println("Result is : " + x);
                break;
            }

            travel++;
        }

    }

    static private void printQueue() {
        System.out.print("Queue is : ");

        for (Integer x : queue) {
            System.out.print(x + " ");
        }

        System.out.println();
    }
}
