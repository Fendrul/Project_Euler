package be.strykers.euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class problem33 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int numeratorProduct = 1;
        int denominatorProduct = 1;

        for (int denominator = 10; denominator <= 99; denominator++) {
            for (int numerator = 10; numerator < denominator; numerator++) {
                int[] simplifiedFraction = simplifyFraction(numerator, denominator);
                int simplifiedNumerator = simplifiedFraction[0];
                int simplifiedDenominator = simplifiedFraction[1];

                // Ne procède qu'avec les fractions pour lesquelles un chiffre a été retiré (dizaine -> unité)
                if (simplifiedNumerator < 10 && simplifiedDenominator < 10) {
                    List<Integer> numeratorDigits = new ArrayList<>(Arrays.asList(Arrays.stream(String.valueOf(numerator).chars()
                                    .toArray()).boxed()
                            .map(x -> x - 48)
                            .toArray(Integer[]::new)));
                    List<Integer> denominatorDigits = new ArrayList<>(Arrays.asList(Arrays.stream(String.valueOf(denominator).chars()
                                    .toArray()).boxed()
                            .map(x -> x - 48)
                            .toArray(Integer[]::new)));

                    int tempNum = simplifiedNumerator;
                    int tempDen = simplifiedDenominator;
                    while (!numeratorDigits.contains(simplifiedNumerator) && simplifiedNumerator < 10 && simplifiedDenominator < 10) {
                        simplifiedNumerator += simplifiedNumerator;
                        simplifiedDenominator += simplifiedDenominator;
                    }

                    // Retire les chiffres correspondants pour ne garder que ceux qui ont disparus dans la simplification
                    if (numeratorDigits.contains(simplifiedNumerator) && denominatorDigits.contains(simplifiedDenominator)) {
                        numeratorDigits.remove(numeratorDigits.lastIndexOf(simplifiedNumerator));
                        denominatorDigits.remove(denominatorDigits.lastIndexOf(simplifiedDenominator));

                        // Si les chiffres restants sont les mêmes, l'énoncé est respecté
                        if (numeratorDigits.get(0) != 0 && numeratorDigits.equals(denominatorDigits)) {
                            System.out.printf("%d/%d -> %d/%d\n", numerator, denominator, simplifiedNumerator, simplifiedDenominator);
                            numeratorProduct *= simplifiedNumerator;
                            denominatorProduct *= simplifiedDenominator;
                        }
                    }
                }
            }
        }
        int[] simplifiedFraction = simplifyFraction(numeratorProduct, denominatorProduct);

        System.out.printf("Valeur finale : %d/%d\n", simplifiedFraction[0], simplifiedFraction[1]);
        System.out.printf("Le programme a pris %d ms", System.currentTimeMillis() - startTime);
    }

    private static int[] simplifyFraction(int numerator, int denominator) {
        List<Integer> primeNumbers;
        int limit;
        if (numerator < denominator)
            primeNumbers = listPrimeNumber(numerator);
        else
            primeNumbers = listPrimeNumber(denominator);

        for (Integer value : primeNumbers) {
            while (numerator % value == 0 && denominator % value == 0) {
                numerator /= value;
                denominator /= value;
            }
        }

        return new int[]{numerator, denominator};
    }

    public static List<Integer> listPrimeNumber(int valueMax) {
        List<Integer> listeNombrePremier = new ArrayList<>();
        listeNombrePremier.add(2);

        int compteur = 3;
        int sizeList = 1;
        while (compteur <= valueMax) {
            boolean isPremier = true;
            Iterator<Integer> iterator = listeNombrePremier.iterator();

            while (isPremier && iterator.hasNext()) {
                if (compteur % iterator.next() == 0)
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
