package Exercise.Chapter1.Ex_1_3;

// 19 20 21 24
public class Ex_1_3_19 {
    static public void DoExercise() {
        LinkNode<Integer> lk = new LinkNode<>();

        for (int i = 0; i < 7; i++) {
            lk.addTail(i);
        }

//        lk.deleteTail();
//        lk.deleteK(1);
//        lk.deleteK(6);
//        lk.deleteK(3);

//        LinkNode<String> lk = new LinkNode<>();
//
//        for (int i = 0; i < 9; i++) {
//            lk.addTail(String.valueOf(i));
//        }

//        boolean result;
//        result = LinkNode.find(lk, "10");
//        result = LinkNode.find(lk, "5");

//        Node keyNode = lk.find("5");
//        lk.removeAfter(keyNode);

//        Node keyNode = lk.find("5");
//        Node<String> node = new Node<String>("insert");
//        lk.insertAfter(keyNode, node);

//        int result = LinkNode.max(lk.getHead(), 0);

//        Queue<Integer> queue = new Queue<>();
//        for (int i = 0; i < 7; i++) {
//            queue.enqueue(i);
//        }
//
//
//        while (!queue.isEmpty()) {
//            int data = queue.dequeue();
//        }

//        lk.reserve();
        lk.reserve(lk.getHead(), null);
    }
}
