package Exercise.Chapter1.Ex_1_3;

import sun.awt.image.ImageWatched;

import java.util.Random;

public class Ex_1_3_19 {
    static public void DoExercise() {
        try {
            Random rand = new Random();

            LinkNode lk1 = LinkNode.create(10, Class.forName("Exercise.Chapter1.Ex_1_3.Person"));

            Person[] personArray = new Person[10];
            for (int i = 0; i < personArray.length; i++) {
                personArray[i] = new Person("Persion" + i, rand.nextInt(100));
            }

            LinkNode lk2 = LinkNode.create(personArray);

            System.out.println("just for break");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
