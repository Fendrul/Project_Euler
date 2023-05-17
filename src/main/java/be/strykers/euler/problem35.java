package be.strykers.euler;

import java.util.*;

import static be.strykers.euler.problem34.intToDigits;


public class problem35 {

    public static final int NUMBER_MAX = 999999;

    public static void main(String[] args) {
        List<Integer> listPrimeNumber = listPrimeNumber(NUMBER_MAX * 10); // Multiplie par 10 afin d'avoir les nombres entiers pour tous les chiffres
        Set<Integer> setPrimeNumbers = new HashSet<>(listPrimeNumber);

        listPrimeNumber = listPrimeNumber.stream().filter(x -> x < NUMBER_MAX).toList();

        int circularPrimeCounter = 0;

        for (Integer value : listPrimeNumber) {
            String stringValue = value.toString();
            int lengthNumber = stringValue.length();
            int[] valueRotated = intToDigits(value);
            boolean isCircularPrime = true;

            for (int permutation = 0; permutation < lengthNumber; permutation++) {
                rotateDigits(valueRotated);

                if (!setPrimeNumbers.contains(digitsToInt(valueRotated)))
                    isCircularPrime = false;
            }

            if (isCircularPrime) {
                circularPrimeCounter++;
//                System.out.println(value);
            }
        }

        System.out.printf("il y a %d nombres premiers circulaires", circularPrimeCounter);
    }

    private static void rotateDigits(int[] digits) {
        int length = digits.length;
        int firstDigit = digits[0]; // Garde en mémoire le premier chiffre comme il se fera écraser

        for (int i = 0; i < length - 1; i++) {
            digits[i] = digits[i+1];
        }
        digits[length-1] = firstDigit;
    }

    private static int digitsToInt(int[] digits) {
        int returnValue = 0;

        for (int digitValue :
                digits) {
            returnValue = returnValue * 10 + digitValue;
        }
        return returnValue;
    }

    public static List<Integer> listPrimeNumber(int roof) {
        List<Integer> listeNombrePremier = new ArrayList<>();
        listeNombrePremier.add(2);

        int compteur = 3;
        int sizeList = 1;
        while (compteur <= roof) {
            boolean isPremier = true;
            Iterator<Integer> iterator = listeNombrePremier.iterator();
            int value = 0;
            int sqrtCounter = (int) Math.sqrt(compteur);

            while (iterator.hasNext() && value < sqrtCounter) {
                value = iterator.next();

                if (compteur % value == 0)
                    isPremier = false;
            }

            if (isPremier) {
                listeNombrePremier.add(compteur);
                sizeList++;
            }

            compteur += 2;
        }

        return listeNombrePremier;
    }

}
