package Chapter1.Ex_1_1;

public class Ex_1_1_12 {
    public static void DoExercise()
    {
        int a[] = new int[10];

        for(int i = 0; i < 10; i++)
            a[i] = 9 - i;

        for(int i = 0; i < 10; i++)
            System.out.print(a[i] + " ");

        System.out.println();
        System.out.println("-----------------------");

        for(int i = 0; i < 10; i++)
            a[i] = a[a[i]];

        for(int i = 0; i < 10; i++)
            System.out.print(a[i] + " ");
    }
}
