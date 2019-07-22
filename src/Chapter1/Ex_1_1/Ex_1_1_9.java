package Chapter1.Ex_1_1;

import java.util.Scanner;

public class Ex_1_1_9 {
    public static void DoExercise()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input a number: ");
        int x = sc.nextInt();

        if (x <= 0)
        {
            System.out.println("error");
            return;
        }

        StringBuilder s = new StringBuilder();
        while(x > 0)
        {
            s.insert(0,x % 2);
            x = x / 2;
        }

        System.out.println(s);
    }
}
