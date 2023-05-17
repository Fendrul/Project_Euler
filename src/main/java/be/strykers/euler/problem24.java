package be.strykers.euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class problem24 {

    public static final String STRING = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUM_OF_PERMUTATIONS = "50000000000000000000000000";

    public static void main(String[] args) {
        List<Character> object = orderedCharList(STRING);
        int length = object.size();
        char[] objectPermuted = new char[length];
        LinkedList<Integer> lehmerCode = new LinkedList<>();
        BigInteger numberLeft = new BigInteger(NUM_OF_PERMUTATIONS);

// crée le ccode de Lehmer permettant de retrouver l'index de chaque élément à la xème permutation
        for (int i = length - 1; i >= 0; i--) {
            BigInteger factorial = factorial(i);
            lehmerCode.add(numberLeft.divide(factorial).intValue());
            numberLeft = numberLeft.subtract(factorial.multiply(intToBigInt(lehmerCode.get(length - 1 - i))));
        }

//remplace les élements en fonction du code de Lehmer
        for (int i = 0; i < length; i++) {
            objectPermuted[i] = object.get(lehmerCode.get(i));
            object.remove((int) lehmerCode.get(i));
        }

        for (char c :
                objectPermuted) {
            System.out.printf("%s ", c);
        }
    }

    private static BigInteger factorial(int n) {
        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            result = result.multiply(intToBigInt(i));
        }
        return result;
    }

    private static BigInteger intToBigInt(int num) {
        return new BigInteger(Integer.toString(num));
    }

    private static List<Character> orderedCharList(String string) {
        char[] charArray = string.toCharArray();
        List<Character> charList = new ArrayList<>();

        for (char c :
                charArray) {
            charList.add(c);
        }

        Collections.sort(charList);

        return charList;
    }
}
