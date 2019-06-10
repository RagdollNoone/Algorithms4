package Chapter1;

public class BinarySearch {
    public static int rank(int key, int[] a) {
        int low = 0;
        int high = a.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if (a[mid] < key) low = mid + 1;
            if (a[mid] == key) return mid;
            if (a[mid] > key) high = mid - 1;
        }

        return -1;
    }
}
