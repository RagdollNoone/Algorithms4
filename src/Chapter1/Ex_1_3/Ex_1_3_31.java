package Chapter1.Ex_1_3;

public class Ex_1_3_31 {
    static public void DoExercise() {
        DoubleLink dl = new DoubleLink();

        for (int i = 0; i < 2; i++) {
            DoubleLink.addHead(dl, DoubleLink.createPerson("Person" + i, i * 10));
        }
        DoubleLink.printDoubleLink(dl);

        DoubleLink.deleteHead(dl);
        DoubleLink.deleteHead(dl);
        DoubleLink.printDoubleLink(dl);

        System.out.println("====================");

        for (int i = 3; i < 5; i++) {
            DoubleLink.addTail(dl, DoubleLink.createPerson("Person" + i, i * 10));
        }
        DoubleLink.printDoubleLink(dl);

        DoubleLink.deleteTail(dl);
        DoubleLink.deleteTail(dl);
        DoubleLink.printDoubleLink(dl);

        System.out.println("====================");

        for (int i = 0; i < 2; i++) {
            DoubleLink.addTail(dl, DoubleLink.createPerson("Person" + i, i * 10));
        }

        DoubleLink.addPreviousNode(dl, dl.findNode("Person0", 0), DoubleLink.createPerson("PersonX", 28));
        DoubleLink.addNextNode(dl, dl.findNode("Person1", 10), DoubleLink.createPerson("PersonXX", 82));
        DoubleLink.printDoubleLink(dl);

        DoubleLink.deleteNode(dl, dl.findNode("PersonX", 28));
        DoubleLink.deleteNode(dl, dl.findNode("PersonXX", 82));
        DoubleLink.printDoubleLink(dl);
    }
}
