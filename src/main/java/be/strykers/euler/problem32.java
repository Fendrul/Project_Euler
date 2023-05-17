package be.strykers.euler;

import java.math.BigInteger;
import java.util.*;

public class problem32 {

    public static final String PANDIGITAL_NUMBER = "123456789";

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int length = PANDIGITAL_NUMBER.length();
        Set<Integer> setMultiplicators = new HashSet<>();
        Set<Integer> productList = new HashSet<>();

        int permutationsMax = factorial(length).intValue();
        for (int permutation = 0; permutation < permutationsMax; permutation++) {
            int[] values = permutedNumber(PANDIGITAL_NUMBER, permutation);

            // Aloue une partie du nombre au multiplicand
            for (int multiplicandIndex = 0; multiplicandIndex < length - 2; multiplicandIndex++) {

                //Insère la partie du nombre dans la variable
                int multiplicand = 0;
                for (int multiplicandCursor = 0; multiplicandCursor <= multiplicandIndex; multiplicandCursor++) {
                    multiplicand = multiplicand * 10 + values[multiplicandCursor];
                }

                // Aloue une partie du nombre au multiplicateur, sur base de la partie allouée au multiplicand
                for (int multiplicatorIndex = multiplicandIndex + 1; multiplicatorIndex < length - 1; multiplicatorIndex++) {

                    // Insère cette partie du nombre dans la variable
                    int multiplier = 0;
                    for (int multiplierCursor = multiplicandIndex + 1; multiplierCursor <= multiplicatorIndex; multiplierCursor++) {
                        multiplier = multiplier * 10 + values[multiplierCursor];
                    }

                    // Aloue la part restante au produit
                    int product = 0;
                    for (int productCursor = multiplicatorIndex + 1; productCursor < length; productCursor++) {
                        product = product * 10 + values[productCursor];
                    }

                    if (multiplicand * multiplier == product && !setMultiplicators.contains(multiplicand)) {
                        System.out.printf("%d, %d, %d\n", multiplicand, multiplier, product);
                        setMultiplicators.add(multiplicand);
                        setMultiplicators.add(multiplier);

                        // Ajoute le produit à la liste
                        productList.add(product);
                    }
                }
            }
        }

        int sumProduct = 0;
        for (Integer number :
                productList) {
            sumProduct += number;
        }

        System.out.println(sumProduct);
        System.out.printf("Le programme a pris %d", System.currentTimeMillis() - startTime);
    }

    public static int[] permutedNumber(String number, int NUM_OF_PERMUTATIONS) {
        List<Character> object = orderedCharList(number);
        int length = object.size();
        int[] objectPermuted = new int[length];
        LinkedList<Integer> lehmerCode = new LinkedList<>();
        BigInteger numberLeft = new BigInteger(String.valueOf(NUM_OF_PERMUTATIONS));

// crée le ccode de Lehmer permettant de retrouver l'index de chaque élément à la xème permutation
        for (int i = length - 1; i >= 0; i--) {
            BigInteger factorial = factorial(i);
            lehmerCode.add(numberLeft.divide(factorial).intValue());
            numberLeft = numberLeft.subtract(factorial.multiply(intToBigInt(lehmerCode.get(length - 1 - i))));
        }

//remplace les élements en fonction du code de Lehmer
        for (int i = 0; i < length; i++) {
            objectPermuted[i] = object.get(lehmerCode.get(i)) - 48; // le nombre étant représenté en ASCII, on retire la valeur de ce tableau
            object.remove((int) lehmerCode.get(i));
        }

        return objectPermuted;
    }

    static BigInteger factorial(int n) {
        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            result = result.multiply(intToBigInt(i));
        }
        return result;
    }

    static BigInteger intToBigInt(int num) {
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
