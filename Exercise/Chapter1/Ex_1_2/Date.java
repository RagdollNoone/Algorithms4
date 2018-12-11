package Exercise.Chapter1.Ex_1_2;

public class Date {
    private final int month;
    private final int day;
    private final int year;

    public Date(int m, int d, int y) {
        this.month = m;
        this.day = d;
        this.year = y;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public int getYear() {
        return this.year;
    }

    public String toString() {
        return getMonth() + "/" + getDay() + "/" + getYear();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (null == o) return false;
        if (this.getClass() != o.getClass()) return false;
        if (this.getMonth() != ((Date)o).getMonth()) return false;
        if (this.getDay() != ((Date)o).getDay()) return false;
        if (this.getYear() != ((Date)o).getYear()) return false;

        return true;
    }


}
