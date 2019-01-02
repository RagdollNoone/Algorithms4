package Chapter1;

public class MergeSort {
    static private int[] arrayCopy;

    static public void Sort(int[] a) {
        arrayCopy = new int[a.length];
        Sort(a, 0, a.length - 1);

//        System.out.println("just for break");
    }

    static private void Sort(int[] a, int low, int high) {
        if (high <= low || null == a) return;

        int mid = (low + high) /2;
        Sort(a, low, mid);
        Sort(a, mid + 1, high);

        merge(a, low, mid, high);
    }

    static public void merge(int[] a, int low, int mid, int high) {
        int i = low, j = mid + 1;

        for (int k = low; k <= high; k++) {
            arrayCopy[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid)        a[k] = arrayCopy[j++];
            else if (j > high)  a[k] = arrayCopy[i++];
            else if (arrayCopy[i] < arrayCopy[j]) a[k] = arrayCopy[i++];
            else a[k] = arrayCopy[j++];
        }

    }

    static public void main(String[] args) {
        int[] array = {7, 4, 8, 5, 2, 1, 9, 3, 6, 0};
        Sort(array);
    }
}
