package be.strykers.euler;

import java.util.HashSet;

public class problem29 {
    public static void main(String[] args) {
        HashSet<Double> numbers = new HashSet<>();
        for (double a = 2; a <= 100; a++) {
            for (double b = 2; b <= 100; b++) {
                numbers.add(Math.pow(a, b));
            }
        }

        System.out.println(numbers.size());
    }
}
