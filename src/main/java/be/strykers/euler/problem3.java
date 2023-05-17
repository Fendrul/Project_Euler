package be.strykers.euler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class problem3 {

    public static final double NOMBRE_RECHERCHE = 600851475143d;

    public static void main(String[] args) {
        int result = 0;
        int nombreADecomposer = (int) Math.sqrt(NOMBRE_RECHERCHE);
        List<Integer> listeNombrePremier = new ArrayList<>();

        for (int i = 3; i <= nombreADecomposer; i += 2) {
            boolean isPremier = true;
            Iterator<Integer> iterator = listeNombrePremier.iterator();

            while (isPremier && iterator.hasNext()) {
                if (i % iterator.next() == 0)
                    isPremier = false;
            }

            if (isPremier) {
                listeNombrePremier.add(i);
            }
        }

        for (Integer i :
                listeNombrePremier) {
            if (NOMBRE_RECHERCHE % i == 0) {
                result = i;
                System.out.println(i);
            }
        }

        System.out.println(result);

    }
}
