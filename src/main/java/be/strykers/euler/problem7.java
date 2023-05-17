package be.strykers.euler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class problem7 {
    public static void main(String[] args) {

        List<Integer> listeNombrePremier = new ArrayList<>();

        int compteur = 3;
        int sizeList = 1;
        while (sizeList <= 10001) {
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

        System.out.println(listeNombrePremier);
    }
}
