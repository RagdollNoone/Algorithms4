package Exercise.Chapter1.Ex_1_3;

public class LinkNode {
    private Node first;
    private int N;

    static private Node createNode(Object o) {
        Node node = new Node();
        node.setItem(o);

        return node;
    }

    static public LinkNode create(int n, Class type) {
        LinkNode lk = new LinkNode();

        try {
            lk.N = n;

            lk.first = createNode(type.newInstance());

            Node tail = lk.first;
            for (int i = 1; i < n; i++) {
                Node node = createNode(type.newInstance());
                tail.setNext(node);
                tail = node;
            }
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }

        return lk;
    }

    static public LinkNode create(Object[] array) {
        LinkNode lk = create(array.length, array[0].getClass());

        int i = 0;
        Node travel = lk.first;
        while(null != travel){
            travel.setItem(array[i]);
            i++;
            travel = travel.getNext();
        }

        return lk;
    }



}
