package Exercise.Chapter1.Ex_1_1;

import java.util.HashMap;
import java.util.Map;

public class Ex_1_1_19 {
    // 计算运行时间和堆栈空间的使用情况

    private static Map resultMap = new HashMap();
    private static long[] resultArray;

    public static void DoExercise()
    {
        long result = F(100);
//        long result = FWhileWay(90);

        System.out.println("The result is: " + result);
    }

    public static long F(int n)
    {
        if(n == 0) return 0;
        if(n == 1) return 1;

        if(resultMap.containsKey(n))
            return (long)resultMap.get(n);
        else {
            long result = F(n - 1) + F(n-2);
            resultMap.put(n, result);
            return result;
        }
    }

    public static long FWhileWay(int n)
    {
        if (n == 0) return 0;
        if (n == 1) return 1;

        resultArray = new long[n]; // 为什么这样定义还是会有溢出呢?
        resultArray[0] = (long)0;
        resultArray[1] = (long)1;

        int i = 2;
        long result = -1;
        while (i < n) {
            result = resultArray[i - 1] + resultArray[i - 2];
            resultArray[i] = result;
            i++;
        }

        return result;
    }
}
