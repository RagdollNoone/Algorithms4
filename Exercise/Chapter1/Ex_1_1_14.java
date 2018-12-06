package Exercise.Chapter1;

import java.util.Scanner;

public class Ex_1_1_14 {
    public static void DoExercise()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input a number: ");

        while (sc.hasNext())
        {
            int n = sc.nextInt();

            int result = 0;
            int exponent = 1;
            while(exponent < n)
            {
                result++;
                exponent = exponent * 2;
            }

            if(exponent > n) result--;

            System.out.println("The result is: " + result);
            System.out.print("Please input a number: ");
        }
    }
}
