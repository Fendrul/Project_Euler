package be.strykers.euler;

import java.math.BigInteger;
import java.util.Arrays;

public class problem16 {
    public static void main(String[] args) {
        BigInteger number = new BigInteger("2");
        number = number.pow(1000);

        String s = number.toString();
        Integer[] listeChiffres = s.chars().boxed().map(x -> x-48).map(problem16::print).toArray(Integer[]::new);

        int sum = Arrays.stream(listeChiffres).mapToInt(x -> x).sum();

        System.out.println(sum);
    }

    public static <R> R print(R r) {
        System.out.println(r);
        return r;
    }
}
