package Chapter4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodeIterator<T> implements Iterator<T> {
    private Node<T> current;

    public NodeIterator(Node<T> first) {
        current = first;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
        return current == null ? false : true;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        T item = current.item;
        current = current.next;

        return item;
    }
}
