package Chapter1.Ex_1_2;

public class Ex_1_2_7 {
    public static void DoExercise()
    {
        String s = "abcd";
        String result = mystery(s);

        System.out.println("Result is : " + result);
    }

    private static String mystery(String s)
    {
        int n = s.length();
        if(n <= 1) return s;

        String s1 = s.substring(0, n / 2);
        String s2 = s.substring(n / 2, n);
        return mystery(s2) + mystery(s1);
    }
}
