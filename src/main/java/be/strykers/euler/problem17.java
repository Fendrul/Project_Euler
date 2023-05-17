package be.strykers.euler;

public class problem17 {
    // Array of string representations for numbers from 0 to 19
    private static final String[] DIGITS = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    // Array of string representations for numbers in tens (e.g. "twenty", "thirty", etc.)
    private static final String[] TENS = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    // Method that converts a number from 0 to 1000 into a string representation
    public static String convertNumberToString(int number) {
        if (number < 20) {
            // If the number is less than 20, we can use the DIGITS array to get its string representation
            return DIGITS[number];
        } else if (number < 100) {
            // If the number is less than 100 but greater than or equal to 20, we need to combine the
            // string representation of the tens digit and the string representation of the ones digit.
            // For example, the number 37 would be "thirty" + "seven".
            int tens = number / 10;
            int ones = number % 10;
            return TENS[tens] + DIGITS[ones];
        } else if (number < 1000) {
            // If the number is less than 1000 but greater than or equal to 100, we need to combine the
            // string representation of the hundreds digit, the string "hundred", and the string representation
            // of the remaining two digits. For example, the number 457 would be "four" + "hundred" + "fifty" + "seven".
            int hundreds = number / 100;
            int remaining = number % 100;
            String remainingString = convertNumberToString(remaining);
            if (remaining > 0) {
                // If the remaining two digits are not zero, we need to add the "and" conjunction.
                // For example, the number 457 would be "four" + "hundred" + "and" + "fifty" + "seven".
                return DIGITS[hundreds] + "hundred" + "and" + remainingString;
            } else {
                // If the remaining two digits are zero, we don't need the "and" conjunction.
                // For example, the number 400 would be "four" + "hundred".
                return DIGITS[hundreds] + "hundred";
            }
        } else {
            // If the number is 1000, we simply return "onethousand"
            return "onethousand";
        }
    }

    public static void main(String[] args) {
        long sum = 0;
        for (int i = 1; i <= 1000; i++) {
            String numberString = convertNumberToString(i);
            System.out.printf("%d: %d lettres pour %s\n", i, numberString.length(), numberString);

            sum += numberString.length();
        }

        System.out.printf("Il y a en tout %d lettres", sum);
    }
}
