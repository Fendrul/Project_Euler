package be.strykers.euler;

import static be.strykers.euler.problem32.factorial;

public class problem34 {

    public static final int MAX_VALUE = 999999;

    public static void main(String[] args) {
        for (int number = 3; number < MAX_VALUE; number++) {
            int[] digitsNumber = intToDigits(number);
            int sumFactDigits = 0;

            for (int value :
                    digitsNumber) {
                sumFactDigits += factorial(value).intValue();
            }

            if (number == sumFactDigits)
                System.out.printf("Trouvé avec %d\n", sumFactDigits);
        }
    }

    static int[] intToDigits(int number) {
        return String.valueOf(number).chars().map(x -> x - 48).toArray();
    }
}
