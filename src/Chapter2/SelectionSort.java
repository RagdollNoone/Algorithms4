package Chapter2;

public class SelectionSort extends Sort{
    static public void sort(Comparable[] array) {
        if (null == array || array.length == 0) return;

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (less(array[j], array[minIndex])) minIndex = j;
            }

            exch(array, i, minIndex);
        }
    }
}
