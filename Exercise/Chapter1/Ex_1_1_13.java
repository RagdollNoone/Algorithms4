package Exercise.Chapter1;

public class Ex_1_1_13 {
    public static void DoExercise()
    {
        int testArray[][] = {   {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12}};

        printArray(3, 4, testArray);
    }

    public static void printArray(int M, int N, int array[][])
    {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++) {
               System.out.print(array[j][i] + " ");
            }

            System.out.println();
        }
    }
}
