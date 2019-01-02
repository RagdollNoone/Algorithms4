package Chapter2;

import Utility.StdOut;
import Utility.StdRandom;
import Utility.Stopwatch;

public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();

        if(alg.equals("InsertionSort")) Sort.InsertionSort(a);
        if(alg.equals("SelectionSort")) Sort.SelectionSort(a);

        return timer.elapsedTime();
    }

    static public double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];

        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }

            total += time(alg, a);
        }

        return total;
    }

    static public void main(String[] args) {
        int N = 100;
        int T = 5;

        double t1 = timeRandomInput("InsertionSort", N, T);
        double t2 = timeRandomInput("InsertionSort", N, T);

        StdOut.printf("%d elements, %d times, %s cost time %.1f seconds", N, T, "SomeSort", t1);
    }
}
