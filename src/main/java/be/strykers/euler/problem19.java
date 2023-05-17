package be.strykers.euler;

public class problem19 {
    public static void main(String[] args) {
        int[] daysInMonths;
        int[] normalYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//        String[] monthInString = {"janvier", "février", "mars", "avril", "mai", "juin", "juillet", "aout", "septembre", "octobre", "novembre", "décembre"};
        int counterDays = 1;
        int counterSundays = 0;

        for (int month :
                normalYear) {
            counterDays+=month;
        }

        for (int year = 1901; year < 2001; year++) {
            if (isLeapYear(year))
                daysInMonths = leapYear;
            else
                daysInMonths = normalYear;

            for (int month = 0; month < 12; month++) {
                if (counterDays % 7 == 6) {
                    counterSundays++;
                }

                counterDays += daysInMonths[month];
            }
        }

        System.out.println(counterSundays);
    }

    static boolean isLeapYear(int year) {
        return ((year & 3) == 0) && ((year % 100) != 0 || (year % 400) == 0);
    }

}
