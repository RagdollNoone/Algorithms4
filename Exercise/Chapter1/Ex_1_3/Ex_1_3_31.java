package Exercise.Chapter1.Ex_1_3;

public class Ex_1_3_31 {
    static public void DoExercise() {
        DoubleLink dl = new DoubleLink();

        for (int i = 0; i < 2; i++) {
            DoubleLink.addHead(dl, DoubleLink.createPerson("Person" + i, i * 10));
        }

        System.out.println("just for break");

        DoubleLink.deleteHead(dl);
        DoubleLink.deleteHead(dl);

        for (int i = 3; i < 5; i++) {
            DoubleLink.addTail(dl, DoubleLink.createPerson("Person" + i, i * 10));
        }

        System.out.println("just for break");

        DoubleLink.deleteTail(dl);
        DoubleLink.deleteTail(dl);

        for (int i = 0; i < 2; i++) {
            DoubleLink.addTail(dl, DoubleLink.createPerson("Person" + i, i * 10));
        }

        DoubleLink.addPreviousNode(dl, dl.findNode("Person1", 10), DoubleLink.createPerson("PersonX", 28));
        DoubleLink.addNextNode(dl, dl.findNode("Person1", 10), DoubleLink.createPerson("PersonXX", 82));

        DoubleLink.deleteNode(dl, dl.findNode("Person0", 0));
    }
}
