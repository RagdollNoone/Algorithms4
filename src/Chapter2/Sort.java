package Chapter2;

import Utility.StdOut;
import Utility.StdRandom;
import Utility.Stopwatch;

public abstract class Sort {
    protected static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    protected static void exch(Comparable[] a, int i, int j)
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a)
    {
        for(int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");

        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a)
    {
        for(int i = 1; i < a.length; i++)
            if (Sort.less(a[i], a[i - 1])) return false;

        return true;
    }

//    public static double time(String alg, Double[] a) {
//        Stopwatch timer = new Stopwatch();
//
//        if(alg.equals("InsertionSort")) {
//            InsertionSort.
//        }
//
//        if(alg.equals("SelectionSort")) SelectionSort(a);
//
//        return timer.elapsedTime();
//    }
//
//    static public double timeRandomInput(String alg, int Numbers, int Times) {
//        double total = 0.0;
//        Double[] a = new Double[Numbers];
//
//        for (int t = 0; t < Times; t++) {
//            for (int i = 0; i < Numbers; i++) {
//                a[i] = StdRandom.uniform();
//            }
//
//            total += time(alg, a);
//        }
//
//        return total;
//    }
//
//    static public void compareSort(String alg1, String alg2) {
//        int Numbers = 100;
//        int Times = 5;
//
//        double t1 = timeRandomInput(alg1, Numbers, Times);
//        double t2 = timeRandomInput(alg2, Numbers, Times);
//
//        StdOut.printf("%d elements, %d times, %s cost time %.1f seconds", Numbers, Times, "SomeSort", t1);
//    }
}
