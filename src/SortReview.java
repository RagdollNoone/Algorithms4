public class SortReview {
    public static void main(String[] args) {
        Integer[] a = {-1, 5, 3, 2, 6, 7, 9, 1, 8, 4};
//        constructHeap(a);
//        heapSort(a);
//        show(a);

//        quickSort(a, 0, a.length - 1);
//        show(a);

        support = new Comparable[a.length];
        mergeSort(a, 0, a.length - 1);
        show(a);

    }

    static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }

    static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    static void constructHeap(Comparable[] a) {
        for (int i = a.length / 2; i > 0; i--) {
            sink(a, i, a.length);
        }
    }

    static void sink(Comparable[] a, int index, int n) {
        if (2 * index >= n) return;

        int maxChild;
        if (2 * index + 1 >= n) {
            maxChild = 2 * index;
        } else {
            if (less(a, 2 * index, 2 * index + 1)) {
                maxChild = 2 * index + 1;
            } else {
                maxChild = 2 * index;
            }
        }

        if (less(a, index, maxChild)) {
            exch(a, index, maxChild);
        }
    }

    static void swim(Comparable[] a, int index) {

    }

    static void heapSort(Comparable[] a) {
        int n = a.length - 1;
        while (n > 0) {
            exch(a, 1, n);
            n--;

            for (int i = n / 2; i > 0; i--) {
                sink(a, i, n);
            }
        }
    }


    static void quickSort(Comparable[] a, int low, int high) {
        if (low >= high) return;

        int mid = partition(a, low, high);
        quickSort(a, low, mid - 1);
        quickSort(a, mid + 1, high);
    }

    static int partition(Comparable[] a, int low, int high) {
        int result = low;
        while (low < high) {
            if (!less(a, result, high)) {
                exch(a, result, high);
                result = high;
            } else {
                high--;
                continue;
            }

            if (less(a, result, low)) {
                exch(a, result, low );
                result = low;
            } else {
                low++;
                continue;
            }
        }

        return result;
    }

    static Comparable[] support;
    static void mergeSort(Comparable[] a, int low, int high) {
        if (low >= high) return;

        int mid = (low + high) / 2;
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);

        System.out.println("---------------------");
        System.out.println("low: " + low + " mid: " + mid + " high: " + high);
        merge(a, low, mid, high);

        show(a);

    }

    static void merge(Comparable[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {
            support[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = support[j++];
                continue;
            }

            if (j > high) {
                a[k] = support[i++];
                continue;
            }

            if (less(support, i, j)) a[k] = support[i++];
            else a[k] = support[j++];

            System.out.println("k = " + k + " a[k] = " + a[k] + " i = " + i + " j = " + j);
        }
    }


}
