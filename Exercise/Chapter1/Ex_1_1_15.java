package Exercise.Chapter1;

public class Ex_1_1_15 {
    public static void DoExercise()
    {
        int[] a = {0, 0, 2, 2};

        int[] result = histogram(a, 6);
        for(int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
    }

    public static int[] histogram(int[] a, int M)
    {
        int[] result = new int[M];

        for(int i = 0; i < a.length; i++)
        {
            if(a[i] < M)
                result[a[i]]++;
        }

        return result;
    }
}
