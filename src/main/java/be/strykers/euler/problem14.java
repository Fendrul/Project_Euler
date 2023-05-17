package be.strykers.euler;

public class problem14 {
    public static void main(String[] args) {
        long number = 0;
        int nbTerms = 0;
        int nbTermsResult = 0;
        int result = 0;

        for (int comptor = 1; comptor < 1000000; comptor++) {
            number = comptor;
            nbTerms = 0;

            while (number != 1) {
                if (number % 2 == 0)
                    number /= 2;
                else
                    number = (number * 3) + 1;

                nbTerms++;
            }
            if (nbTerms > nbTermsResult) {
                result = comptor;
                nbTermsResult = nbTerms;
            }
        }

        System.out.printf("Le plus grand nombre est %d, avec une chaîne de %d\n", result, nbTermsResult);
    }
}
