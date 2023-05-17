package be.strykers.euler;

public class problem12 {

    public static final int NOMBRE_DIVISEURS = 500 / 2; // à diviser par deux, comme chaque diviseur possède un diviseur parallèle

    public static void main(String[] args) {
        boolean numberFound = false;
        int counter = 1;
        int sum = 0;
        int divisorsCounter = 0;

        while (!numberFound) {
            sum += counter;

            for (int i = 1; i <= Math.sqrt(sum); i++) {
                if (sum % i == 0) {
                    divisorsCounter++;
                }
            }

            if (divisorsCounter >= NOMBRE_DIVISEURS) {
                System.out.printf("Il y a %d diviseurs et le nombre est %d", divisorsCounter * 2, sum);
                numberFound = true;
            }

            counter++;
            divisorsCounter = 0;
        }
    }
}
