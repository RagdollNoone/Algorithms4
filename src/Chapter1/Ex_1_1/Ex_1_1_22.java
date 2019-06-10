package Chapter1.Ex_1_1;

public class Ex_1_1_22 {
    public static void DoExercise()
    {
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        int index = rank(0, a.length, 8, a, 0);
        System.out.println("index is: " + index);
    }

    public static int rank(int lo, int hi, int key, int a[], int deep)
    {
        System.out.println("lo: " + lo + " hi: " + hi + " deep: " + deep);
        if(lo >= hi) return -1;

        int mid = (lo + hi) / 2;
        if(a[mid] == key) return mid;
        if(a[mid] < key) return rank(mid + 1, hi, key, a, ++deep); // notice deep++ is wrong
        if(a[mid] > key) return rank(lo, mid - 1, key, a, ++deep);

        return -1;
    }
}
