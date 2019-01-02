package Chapter1;

import Utility.StdRandom;
import Utility.Stopwatch;

public class ThreeSum {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;

        for(int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for(int k = j + 1; k < N; k++)
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }

        return cnt;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        int[] a = new int[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(-1000000, 10000000);
        }

        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        double time = timer.elapsedTime();

        System.out.println(cnt + "triples " + time + "seconds");
    }
}
