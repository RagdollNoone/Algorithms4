package Chapter4;

import Utility.StdIn;
import Utility.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<T> implements Iterable<T> {
    private Node<T> first;
    private int n;

    public Bag() {
        first = null;
        n = 0;
    }


    private static class Node<T> {
        private T item;
        private Node<T> next;
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
        return new ListIterator(first);
    }


    private class ListIterator implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> first) {
            current = first;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return current != null;
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

    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            bag.add(item);

            StdOut.println("Size of bag = " + bag.size());
            for (String s : bag) {
                StdOut.print(s + " ");
            }
            StdOut.println();
        }
    }

}
