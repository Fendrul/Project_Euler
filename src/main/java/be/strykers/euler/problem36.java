package be.strykers.euler;

public class problem36 {

    public static void main(String[] args) {
        int sumDoublebasePalindrome = 0;
        for (int number = 1; number < 1000000; number++) {
            int[] digits = intToDigits(number);
            int[] binaryDigits = intToDigits(Integer.toBinaryString(number));

            if (checkPalindrome(digits) && checkPalindrome(binaryDigits)) {
                sumDoublebasePalindrome += number;
            }
        }

        System.out.println(sumDoublebasePalindrome);
    }

    private static boolean checkPalindrome(int[] digits) {
        int length = digits.length;

        for (int i = 0; i <= length / 2; i++) {
            if (digits[i] != digits[length - 1 - i])
                return false;
        }

        return true;
    }

    static int[] intToDigits(int number) {
        return String.valueOf(number).chars().map(x -> x - 48).toArray();
    }

    static int[] intToDigits(String number) {
        return number.chars().map(x -> x - 48).toArray();
    }
}
