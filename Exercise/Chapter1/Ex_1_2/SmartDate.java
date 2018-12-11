package Exercise.Chapter1.Ex_1_2;

public class SmartDate
extends Date{
    public SmartDate(int m, int d, int y) {
        super(m, d, y);
    }

    public static void create(int m, int d, int y) {
        new SmartDate(m, d, y);
    }
}
