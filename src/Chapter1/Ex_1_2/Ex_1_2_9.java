package Chapter1.Ex_1_2;

public class Ex_1_2_9 {
    public static void DoExercise()
    {
        int[] a = {1, 3, 4, 5, 6, 9, 10};
        int key = 9;
        Counter c = new Counter("total");
        rank(key, a, c);
        System.out.println("Result is: " + c.getTally());
    }

    public static int rank(int key, int[] a, Counter c)
    {
        int lo = 0;
        int hi = a.length - 1;

        while(lo <= hi)
        {
            c.increment();
            int mid = (lo + hi) / 2;
            if(a[mid] == key)
            {
                return mid;
            }

            if(a[mid] < key)
                lo = mid + 1;

            if(a[mid] > key)
                hi = mid - 1;
        }

        return -1;
    }


}
