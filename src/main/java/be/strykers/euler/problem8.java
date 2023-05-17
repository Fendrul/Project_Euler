package be.strykers.euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem8 {
    public static void main(String[] args) {
        TableauNombre tableauNombre = new TableauNombre();

        tableauNombre.ajoutNombres("7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450");

        long greatestProduct = tableauNombre.findGreatestProduct(13);

        System.out.println(greatestProduct);
    }

    private static class TableauNombre {
        public static final int TAILLE_LISTE = 50;
        private final List<List<Integer>> nombres = new ArrayList<>();

        public void ajoutNombres(String s) {
            int taille = s.length();
            List<Integer> nouveauxNombres = new ArrayList<>();

            for (int i = 0; i < taille; i++) {
                nouveauxNombres.add(Character.getNumericValue(s.charAt(i)));

                // Ce code permet de diviser le nombre en chaine égales
//                if ((i+1) % TAILLE_LISTE == 0) {
//                    nombres.add(nouveauxNombres);
//                    nouveauxNombres = new ArrayList<>();
//                }
            }

            if (!nouveauxNombres.isEmpty())
                nombres.add(nouveauxNombres);
        }

        public long findGreatestProduct(int quantiteNombresAdjacents) {
            long result = 0;
            long calc = 0;

            for (List l :
                    nombres) {
                calc = findGreatestProductInList(l,quantiteNombresAdjacents);

                if (calc > result)
                    result = calc;
            }

            return result;
        }

        public static long findGreatestProductInList(List<Integer> list, int quantiteNombresAdjacents) {
            long result = 0;
            long calc = 0;
            int lengthNumbers = list.size();

            for (int i = 0; i <= lengthNumbers - quantiteNombresAdjacents; i++) {
                calc = ProductFromArray(list.subList(i, i + quantiteNombresAdjacents).toArray(new Integer[0]));

                if (calc > result)
                    result = calc;
            }

            return result;
        }

        private static <T> long ProductFromArray(T[] toArray) {
            List<Long> list = Arrays.stream(toArray)
                    .map(Object::toString) // element -> element.toString()
                    .map(Long::parseLong) // str -> Integer.parseInt(str)
                    .toList();

            return list.stream()
                    .reduce(1L, (a, b) -> a * b);
        }

        @Override
        public String toString() {
            return "Tableaunombre{" +
                    "tableauNombre=" + nombres +
                    '}';
        }
    }
}
