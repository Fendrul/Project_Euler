package be.strykers.euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class problem27 {
    public static void main(String[] args) {
        HashSet<Integer> primeNumbers = new HashSet<>(listPrimeNumber(100000));
        int indexNA = 0;
        int indexNB = 0;
        int maxN = 0;

        for (int a = -999; a < 1000; a++) {
            for (int b = -1000; b <= 1000; b++) {
                int n = 0;
                boolean suitePrime = true;

                while (suitePrime) {
                    int result = (int) Math.pow(n, 2) + (a * n) + b;
                    if (primeNumbers.contains(result))
                        n++;
                    else
                        suitePrime = false;
                }

                if (n > maxN) {
                    maxN = n;
                    indexNA = a;
                    indexNB = b;
                }
            }
        }
        System.out.printf("Pour a: %d et b: %d, une suite de %d a été trouvée. Produit : %d", indexNA, indexNB, maxN, indexNA * indexNB);
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

            compteur += 2;
        }

        return listeNombrePremier;
    }
}
