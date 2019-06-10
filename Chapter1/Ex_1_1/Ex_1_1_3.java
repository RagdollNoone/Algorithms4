package Chapter1.Ex_1_1;

import java.util.Scanner;

public class Ex_1_1_3 {
    public static void DoExercise()
    {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if(a == b && a == c)
            System.out.println("equal");
        else
            System.out.println("not equal");
    }
}
