package be.strykers.euler.ressources;

public class Euler {
    public static int[] intToDigits(int number) {
        return String.valueOf(number).chars().map(x -> x - 48).toArray();
    }

    public static int[] intToDigits(String number) {
        return number.chars().map(x -> x - 48).toArray();
    }
}
