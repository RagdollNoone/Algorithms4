package Exercise.Chapter1.Ex_1_2;

public class Date {
    private final int month;
    private final int day;
    private final int year;

    public Date(int m, int d, int y) {
        try {
            ErrorType checkResult = isValidInput(m, d, y);

            if (checkResult != ErrorType.NO_ERROR)
                throw new DateException(checkResult.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            this.month = m;
            this.day = d;
            this.year = y;
        }
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

    private enum ErrorType{
        ERROR_INPUT_OF_YEAR,
        ERROR_INPUT_OF_MONTH,
        ERROR_INPUT_OF_DAY,
        NO_ERROR
    }

    private ErrorType isValidInput(int m, int d, int y) {
        if (y < 1000 || y > 9999) return ErrorType.ERROR_INPUT_OF_YEAR;
        if (m < 0 || m > 12) return ErrorType.ERROR_INPUT_OF_MONTH;

        int validDay = getValidDaysOfMonth(m, y);
        if (d < 0 || d > validDay) return ErrorType.ERROR_INPUT_OF_DAY;

        return ErrorType.NO_ERROR;
    }

    private int getValidDaysOfMonth(int m, int y) {
        if (m == 2) {
            if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0)
                return 29;
            else return 28;
        }

        if (m == 4 || m == 6 || m == 9 || m == 11)
            return 30;

        return 31;
    }

    public class DateException
            extends Exception {
        public DateException (String errorMessage) {
            super(errorMessage);
        }
    }
}
