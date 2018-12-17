package Exercise.Chapter1.Ex_1_3;

public class DoubleLink {
    private DoubleNode<Person> head;
    private int N;

    public DoubleLink() {
        head = null;
        N = 0;
    }

    public void increase() { N++; }
    public void decrease() { N--; }

    public DoubleNode<Person> getHead() {
        return this.head;
    }

    static public void addHead(DoubleLink list, DoubleNode<Person> node) {
        DoubleNode<Person> head = list.getHead();

        node.next = head;
        head.previous = node;
        list.increase();
    }


    private class DoubleNode<T> {
        public DoubleNode previous;
        public DoubleNode next;
        private T data;

        public DoubleNode(T data) {
            this.data = data;
            previous = next = null;
        }
    }

}
