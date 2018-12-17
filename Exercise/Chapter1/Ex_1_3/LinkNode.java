package Exercise.Chapter1.Ex_1_3;

public class LinkNode<T> {
    private Node<T> head;
    private Node<T> tail;
    private int N;

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    // TODO 能不能动态的传递类型给静态函数
    static public LinkNode<?> create() {
        LinkNode<?> lk = new LinkNode<>();
        return lk;
    }

    public LinkNode () {
        head = tail = null;
        N = 0;
    }

    public void addTail (T data) {
        Node newTail = new Node<T>(data);
        N++;

        if (null == this.tail) {
            this.head = this.tail = newTail;
            return;
        }

        this.tail.next = newTail;
        this.tail = newTail;
    }

    public void addHead (T data) {
        Node newHead = new Node<T>(data);
        N++;

        if (null == this.head) {
            this.head = this.tail = newHead;
            return;
        }

        newHead.next = this.head;
        this.head = newHead;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public int getLength(Node node) {
        int length = 0;

        while(null != node.next) {
            node = node.next;
            length++;
        }

        return length;
    }

    public void deleteNode (Node node) {
        N--;

        if (head == node) {
            this.head = head.next;
            return;
        }

        Node travel = head;
        while (null != travel.next) {
            if (node == travel.next) {
                if (travel.next == tail) {
                    tail = travel;
                }

                travel.next = travel.next.next;
                return;
            }

            travel = travel.next;
        }
    }

    // only use head node
    public void deleteTail() {
        if (null == head) return;

        Node travel = head;
        N--;

        if (null == head.next) {
            head = tail = null;
            return;
        }


        while (null != travel.next && null != travel.next.next) {
            travel = travel.next;
        }

        travel.next = null;
        tail = travel;
    }

    public void deleteK(int k) {
        if (size() < k) return;

        Node travel = head;
        for (int i = 1; i <= k - 1; i++) {
            travel = travel.next;
        }

        deleteNode(travel);
    }

    static public boolean find(LinkNode<String> lk, String key) {
        Node<String> travel = lk.head;

        while (null != travel.next) {
            if (travel.item.equals(key)) {
                return true;
            }

            travel = travel.next;
        }

        return false;
    }

    public Node find(T data) {
        Node travel = head;

        while(null != travel.next) {
            if (travel.item.equals(data)) {
                return travel;
            }

            travel = travel.next;
        }

        return null;
    }

    public void removeAfter(Node node) {
        if (node == null) return;

        int length = getLength(node);
        node.next = null;
        N = N - length;

        return;
    }

    static public void insertAfter(Node u, Node v) {
        if (null == u || null == v) return;

        Node temp = u.next;
        u.next = v;
        v.next = temp;

        return;
    }

    static public int max(Node node) {
        int max = 0;

        while (null != node) {
            if ((int)node.item > max)
                max = (int)node.item;

            node = node.next;
        }

        return max;
    }

    static public int max(Node node, int curResult) {
        if (null == node) return curResult;

        curResult = Math.max((int)node.item, curResult);
        return max(node.next, curResult);
    }

    public LinkNode<T> reserve() {
        Node travel = this.head;
        Node reserve = null;

        while(null != travel) {
            Node temp = travel.next;
            travel.next = reserve;
            reserve = travel;
            travel = temp;
        }

        this.head = reserve;

        return this;
    }

    public LinkNode<T> reserve(Node travel, Node reserve) {
        if (null == travel) {
            this.head = reserve;
            return this;
        }

        Node temp = travel.next;
        travel.next = reserve;
        reserve = travel;

        return reserve(temp, reserve);
    }
}
