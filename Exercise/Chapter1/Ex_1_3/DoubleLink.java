package Exercise.Chapter1.Ex_1_3;

public class DoubleLink {
    private DoubleNode<Person> head;
    private DoubleNode<Person> tail;
    private int N;

    public DoubleLink() {
        head = tail = null;
        N = 0;
    }

    public DoubleNode<Person> getHead() {
        return this.head;
    }
    public DoubleNode<Person> getTail() { return this.tail; }

    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }

    private void addHead(DoubleNode<Person> node) {
        N++;

        if (null == head) {
            head = tail = node;
            return;
        }

        node.next = head;
        head.previous = node;

        head = node;
    }

    private void addTail(DoubleNode<Person> node) {
        N++;

        if (null == tail) {
            head = tail = node;
            return;
        }

        node.previous = tail;
        tail.next = node;

        tail = node;
    }

    private void deleteHead() {
        N--;

        if (isEmpty()) {
            head = tail = null;
            return;
        }

        head = head.next;
    }

    private void deleteTail() {
        N--;

        if (isEmpty()) {
            tail = head = null;
            return;
        }

        tail = tail.previous;
    }

    public DoubleNode<Person> findNode(String name, int age) {
        DoubleNode<Person> travel = head;

        while (null != travel) {
            if (travel.data.name.equals(name) && travel.data.age == age)
                return travel;

            travel = travel.next;
        }

        return travel;
    }

    private void addPreviousNode(DoubleNode<Person> findNode, DoubleNode<Person> addNode) {
        N++;

        DoubleNode<Person> temp = findNode.previous;
        findNode.previous = addNode;
        addNode.next = findNode;
        addNode.previous = temp;
    }

    private void addNextNode(DoubleNode<Person> findNode, DoubleNode<Person> addNode) {
        N++;

        DoubleNode<Person> temp = findNode.next;
        findNode.next = addNode;
        addNode.previous = findNode;
        addNode.next = temp;
    }

    private void deleteNode(DoubleNode<Person> deleteNode) {
        N--;

        if (size() == 1) {
            head = tail = null;
            return;
        }

        deleteNode.previous.next = deleteNode.next;
    }

    static public void addHead(DoubleLink list, DoubleNode<Person> node) {
        list.addHead(node);
    }

    static public void addTail(DoubleLink list, DoubleNode<Person> node) {
        list.addTail(node);
    }

    static public void deleteHead(DoubleLink list) {
        list.deleteHead();
    }

    static public void deleteTail(DoubleLink list) {
        list.deleteTail();
    }

    static public void addPreviousNode(DoubleLink list, DoubleNode<Person> findNode, DoubleNode<Person> addNode) {
        if (null == findNode || null == addNode) return;

        list.addPreviousNode(findNode, addNode);
    }

    static public void addNextNode(DoubleLink list, DoubleNode<Person> findNode, DoubleNode<Person> addNode) {
        if (null == findNode || null == addNode) return;

        list.addNextNode(findNode, addNode);
    }

    static public void deleteNode(DoubleLink list, DoubleNode<Person> deleteNode) {
        if (null == deleteNode) return;

        list.deleteNode(deleteNode);
    }

    static public DoubleNode<Person> createPerson(String name, int age) {
        Person person = new Person(name, age);
        DoubleNode<Person> result = new DoubleNode(person);
        return result;
    }

    static private class DoubleNode<T> {
        public DoubleNode previous;
        public DoubleNode next;
        private T data;

        public DoubleNode(T data) {
            this.data = data;
            previous = next = null;
        }
    }

}
