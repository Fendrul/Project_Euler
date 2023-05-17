package be.strykers.euler;


import be.strykers.console.Console;
import be.strykers.console.ConsoleBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class problem26 {

    public static final int DECIMALS_SCALE = 1000;

    public static void main(String[] args) {
        Console cons = new ConsoleBuilder();
        HashMap<Integer, Integer> cycles = new HashMap<>();
        List<Integer> listPrimeNumber = listPrimeNumber(DECIMALS_SCALE);
        listPrimeNumber.removeIf(p -> p >= DECIMALS_SCALE);

        // Ne calcule qu'à partir des nombres premiers
        for (Integer i: listPrimeNumber) {
            BigDecimal dividend = new BigDecimal(1);
            BigDecimal divisor = new BigDecimal(i);
            BigDecimal result = dividend.divide(divisor, DECIMALS_SCALE, RoundingMode.HALF_UP).stripTrailingZeros();

            // Ne calcule que pour ceux qui ont une suite de décimales qui a l'air infinie
            if (result.toString().length() == DECIMALS_SCALE + 2) {
                boolean cycleFound = false;
                int cycleLength = 0;

                // Remet le nombre à l'unité, afin qu'il puisse passer dans la vérification par modulo 1
                while (result.compareTo(BigDecimal.valueOf(1)) < 0)
                    result = result.scaleByPowerOfTen(1);

                BigDecimal number1 = bigDecimalTruncate(new BigDecimal(String.valueOf(result)), 1);
                BigDecimal number2 = bigDecimalTruncate(result, 1);

                // Recherche la taille de la suite probable
                while (cycleLength < DECIMALS_SCALE - 10 && !cycleFound) {
                    cycleLength++;
                    number1 = number1.scaleByPowerOfTen(1);
                    number2 = bigDecimalTruncate(number2, 1);

                    // Si par la soustraction d'un nombre plus élevé de E^cycleLength il n'y a plus de reste avec le modulo 1, c'est alors la taille de la suite
                    if (number1.subtract(number2).remainder(BigDecimal.valueOf(1)).compareTo(BigDecimal.valueOf(0)) == 0) {
                        System.out.println(i);
                        cycles.put(i, cycleLength);
                        cycleFound = true;
                    }
                }
            }
        }
        System.out.println(cycles.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey());

    }

    public static List<Integer> listPrimeNumber(int qttPrimeNumber) {
        List<Integer> listeNombrePremier = new ArrayList<>();

        int compteur = 3;
        int sizeList = 1;
        while (sizeList <= qttPrimeNumber) {
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

            compteur+=2;
        }

        return listeNombrePremier;
    }

    private static BigDecimal bigDecimalTruncate(BigDecimal bigD, int truncate) {
        String s = bigD.toString();
        s = s.substring(0, s.length() - truncate);
        return new BigDecimal(s);
    }
}
