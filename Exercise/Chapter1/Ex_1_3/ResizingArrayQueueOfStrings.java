package Exercise.Chapter1.Ex_1_3;

public class ResizingArrayQueueOfStrings<T> {
    private T[] array;
    private int N;

    public ResizingArrayQueueOfStrings(int n) {
        array = (T[])(new Object[n]);
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public T peek(){
        return array[0];
    }

    public void enqueue(T object) {
        array[++N] = object;
    }

    public T dequeue() {
        T result = array[0];

        for (int i = 1; i < N; i++) {
            array[i - 1] = array[i];
        }

        array[N - 1] = null;
        N--;

        return result;
    }

    public void resize(int n) {
        T[] newArray = (T[])(new Object[n]);

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }
}
