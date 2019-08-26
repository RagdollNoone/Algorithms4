package Chapter4;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {
    private Node<T> first;
    private int n;

    public Bag() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void add(T item) {
        Node<T> oldFirst = first;

        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    @Override
    public Iterator<T> iterator() {
        return new NodeIterator(first);
    }
}
