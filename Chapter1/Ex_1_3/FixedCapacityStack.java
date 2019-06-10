package Chapter1.Ex_1_3;

public class FixedCapacityStack<T> {
    private T[] array;
    private int n;

    public FixedCapacityStack(int cap) {
        assert cap > 0;

        array = (T[]) new Object[cap];
        n = 0;
    }

    public int size() {
        return array.length;
    }

    public T pop() {
        return array[--n];
    }

    public void push(T object) {
        if (isFull())
            resize();

        array[n++] = object;
    }

    private void resize() {
        T[] newArray = (T[]) new Object[2 * array.length];
        for(int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == array.length;
    }
}
