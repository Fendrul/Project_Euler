package be.strykers.euler;

import java.math.BigInteger;

public class problem15 {

    public static final int TAILLE_TABLEAU = 20;

    public static void main(String[] args) {
        BigInteger result = new BigInteger(Integer.toString(1));
        BigInteger lengthTab = new BigInteger(Integer.toString(TAILLE_TABLEAU));
        long test = 1;
        int boucle1 = 0;
        int boucle2 = 0;

        test = calculSuite(TAILLE_TABLEAU+1, TAILLE_TABLEAU-1);

        System.out.println(test);

//        for (int i = 1; i <= TAILLE_TABLEAU; i++) {
//            result = result.multiply(intToBigInt(4)).subtract(intToBigInt(2));
//            test = test*4 - 2;
//        }
//
//        System.out.println(result);
//        System.out.println(test);
//        System.out.println((TAILLE_TABLEAU+1)*TAILLE_TABLEAU);
    }

    private static long calculSuite(int valeurSuite, int depth) {
        long sum = 0;
        if (depth != 1) {
            for (int i = valeurSuite; i > 0; i--) {
                sum += calculSuite(i, depth - 1);
            }
        } else {
            sum = (long) valeurSuite * (valeurSuite + 1)/2;
//            System.out.printf("Pour une valeur de %d, la valeur est %d\n", valeurSuite, sum);
            return sum;
        }

        return sum;
    }

    private static BigInteger intToBigInt(int num) {
        return new BigInteger(Integer.toString(num));
    }


}
