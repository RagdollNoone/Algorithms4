package Exercise.Chapter1.Ex_1_3;

public class Node<T> {
    private T item;
    private Node next;

    public Node() {
        item = null;
        next = null;
    }

    public void setItem(T data) {
        item = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }
}
