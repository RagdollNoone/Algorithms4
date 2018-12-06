package Exercise.Chapter1;

public class Ex_1_1_7 {
    public static void DoExercise()
    {
        // a
        double t = 9.0;
        while(Math.abs(t - 9.0 / t) > .001)
            t = (9.0 / t + t) / 2.0;

        System.out.printf("%.5f\n", t); // 求极值能得出t应该无限趋近于3, 但是具体是什么值不会算


        int sum = 0;
        for(int i = 1; i < 1000; i++)
            for(int j = 0; j < i; j++)
                sum++;

        System.out.println(sum);

        // c
        sum = 0;
        for(int i = 1; i < 1000; i *= 2)
            for(int j = 0; j < 1000; j++)
                sum++;

        System.out.println(sum);
    }
}
