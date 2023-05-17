package be.strykers.euler;

public class problem10 {
    public static void main(String[] args) {
        int[] listeNombrePremier = new int[2000000];
        int compteur = 3;
        int sizeList = 1;
        long sum = 2;

        while (compteur < 2000000) {
            boolean isPremier = true;
            int compteurListePremier = 0;

            while (isPremier && compteurListePremier < sizeList-1 && listeNombrePremier[compteurListePremier] <= Math.sqrt(compteur)) {
                if (compteur % listeNombrePremier[compteurListePremier] == 0)
                    isPremier = false;
                else
                    compteurListePremier++;
            }

            if (isPremier) {
                listeNombrePremier[sizeList-1] = compteur;
                sum += compteur;
                sizeList++;
//                System.out.printf("Compteur vaut %d et somme vaut %d\n", compteur, sum);
//                System.out.println(sizeList);
            }
            compteur+=2;

        }
        System.out.println(sum);
    }
}
