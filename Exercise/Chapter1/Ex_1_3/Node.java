package Exercise.Chapter1.Ex_1_3;

public class Node<T> {
    public T item;
    public Node next;

    public Node(T data, Node next) {
        this.item = data;
        this.next = next;
    }

    public Node(T data) {
        this.item = data;
        this.next = null;
    }
}
