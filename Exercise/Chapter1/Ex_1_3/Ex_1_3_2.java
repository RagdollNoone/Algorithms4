package Exercise.Chapter1.Ex_1_3;

public class Ex_1_3_2 {
    public static void DoExercise()
    {
        String[] inputArray = { "it", "was", "-", "the", "best", "-",
                                "of", "times", "-", "-", "-", "it",
                                "was", "-", "the", "-", "-"};

        FixedCapacityStack<String> array = new FixedCapacityStack<String> (inputArray.length);
        for(int i = 0; i < inputArray.length; i++) {
            if (!inputArray[i].equals("-"))
                array.push(inputArray[i]);
            else {
                String s = array.pop();
                System.out.print(s + " ");
            }
        }
    }
}