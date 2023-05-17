package be.strykers.euler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class problem5 {
    public static void main(String[] args) {
        boolean numberFound = false;
        List<Integer> liste = new ArrayList<>();
        int compteur = 21;

        for (int i = 11; i <= 20; i++) {
            liste.add(i);
        }

        while (!numberFound) {
            Iterator<Integer> iterator = liste.iterator();
            boolean isMultiple = true;

            while (isMultiple && iterator.hasNext()) {
                if (compteur % iterator.next() != 0)
                    isMultiple = false;
            }

            if (isMultiple) {
                numberFound = true;
                System.out.println(compteur);
            }

            compteur++;
        }
    }
}
