package Exercise.Chapter1.Ex_1_2;

public class SmartDate
extends Date{
    public static SmartDate create(int m, int d, int y) {
        SmartDate smartDatedate = new SmartDate(m, d, y);
        return smartDatedate;
    }

    public SmartDate(int m, int d, int y) {
        super(m, d, y);

        try {
            ErrorType checkResult = isValidInput(m, d, y);

            if (checkResult != ErrorType.NO_ERROR)
                throw new DateException(checkResult.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private enum DayOfWeek {
        Unknow(-1),
        Monday(1),
        Tuesday(2),
        Wednesday(3),
        Thursday(4),
        Friday(5),
        Saturday(6),
        Sunday(0);

        private final int value;

        DayOfWeek(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public String getDayOfTheWeek() {

        int dayCode = this.getDay();
        int monthCode = this.getMonthCode(this.getMonth(), this.getYear());
        int yearCode = this.getYearCode(this.getYear());

        assert (monthCode != -1);
        assert (yearCode != -1);

        int checkValue = dayCode + monthCode + yearCode;
        DayOfWeek result = DayOfWeek.values()[(checkValue % 7)];

        return result.toString();
    }

    private int getMonthCode(int m, int y) {
        int result = -1;

        switch(m)
        {
            case 5:
                result = 0;
                break;
            case 8:
                result = 1;
                break;
            case 2:
                if (isLeapYear(y))
                {
                    result = 1;
                    break;
                }
            case 3:
            case 11:
                result = 2;
                break;
            case 6:
                result = 3;
                break;
            case 9:
            case 12:
                result = 4;
                break;
            case 4:
            case 7:
                result = 5;
                break;
            case 1:
                if (isLeapYear(y))
                {
                    result = 5;
                    break;
                }
            case 10:
                result = 6;
                break;
        }

        return result;
    }

    private int getYearCode(int y) {
        int a = y % 100;
        int b = a / 4 + a;
        int result = b % 7;

        return result;
    }

    private enum ErrorType{
        ERROR_INPUT_OF_YEAR,
        ERROR_INPUT_OF_MONTH,
        ERROR_INPUT_OF_DAY,
        NO_ERROR
    }

    public static ErrorType isValidInput(int m, int d, int y) {
        if (y < 1000 || y > 9999) return ErrorType.ERROR_INPUT_OF_YEAR;
        if (m < 0 || m > 12) return ErrorType.ERROR_INPUT_OF_MONTH;

        int validDay = getValidDaysOfMonth(m, y);
        if (d < 0 || d > validDay) return ErrorType.ERROR_INPUT_OF_DAY;

        return ErrorType.NO_ERROR;
    }

    public static int getValidDaysOfMonth(int m, int y) {
        if (m == 2) {
            if (isLeapYear(y))
                return 29;
            else return 28;
        }

        if (m == 4 || m == 6 || m == 9 || m == 11)
            return 30;

        return 31;
    }

    public static boolean isLeapYear(int y) {
        return y % 4 == 0 && y % 100 != 0 || y % 400 == 0;
    }

    public class DateException extends RuntimeException {
        public DateException (String errorMessage) {
            super(errorMessage);
        }
    }
}
