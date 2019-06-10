package Chapter1.Ex_1_2;

public class Ex_1_2_6 {
    public static void DoExercise()
    {
        String s1 = "ACTGACG";
        String s2 = "TGACGAC";

        boolean result = checkCircularRotation(s1, s2);
        System.out.println("Result is: " + result);
    }

    private static boolean checkCircularRotation(String s1, String s2)
    {
        if((s1 + s1).indexOf(s2) != -1 && s1.length() == s2.length())
            return true;

        return false;
    }
}
