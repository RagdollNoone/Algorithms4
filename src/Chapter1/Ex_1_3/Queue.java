package Chapter1.Ex_1_3;

public class Queue<T> {
    private Node<T> tail;
    private int N;

    public Queue(){
        tail = null;
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(T data) {
        Node<T> node = new Node<>(data);
        N++;

        if (null == tail) {
            node.next = node;
            tail = node;
            return;
        }

        node.next = tail.next;
        tail.next = node;
        tail = node;
    }

    public T dequeue() {
        if (isEmpty()) return null;

        T data = (T)tail.next.item;
        tail.next = tail.next.next;
        N--;

        if (isEmpty()) tail = null;

        return data;
    }

    public T peek() {
        if (isEmpty()) return null;

        return (T)tail.next.item;
    }

}
