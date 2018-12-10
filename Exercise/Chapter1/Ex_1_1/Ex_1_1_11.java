package Exercise.Chapter1.Ex_1_1;

public class Ex_1_1_11 {
    public static void DoExercise()
    {
        int M = 3;
        int N = 4;
        boolean a[][];
        a = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i % 2 == 0 || j % 2 == 0)
                    a[i][j] = true;
                else
                    a[i][j] = false;

//                System.out.printf("M = %d, N = %d, value = %s\n", i, j, a[i][j] == true ? "*" : " ");
                System.out.printf(a[i][j] == true ? "* " : "  ");
            }

            System.out.println();
        }
    }
}
