package be.strykers.euler;

import java.util.HashMap;
import java.util.Objects;

public class problem21 {

    public static final int LIMIT_AMICABLE_NUMBER = 1000000;

    public static void main(String[] args) {
        HashMap<Integer, Integer> amicableMap = new HashMap<>();

        for (int amicableNum = 1; amicableNum <= LIMIT_AMICABLE_NUMBER; amicableNum++) {
            int sumDivisors = 0;

            for (int divisor = 1; divisor <= Math.sqrt(amicableNum); divisor++) {
                if (amicableNum % divisor == 0) {
                    sumDivisors += divisor;
                    sumDivisors += amicableNum / divisor; // Ajoute chaque diviseurs en miroir comme ils peuvent être trouvé à partir du premier diviseur
                }
            }
            sumDivisors -= amicableNum; // retire le nombre lui-même qui se retrouve ajouté par les diviseurs miroirs

            if (Math.sqrt(amicableNum) % 1 == 0)
                sumDivisors -= Math.sqrt(amicableNum);

            amicableMap.put(amicableNum, sumDivisors);
        }

        int sumAmicable = 0;
        for (int number1 = 1; number1 < LIMIT_AMICABLE_NUMBER; number1++) {

            if (amicableMap.get(number1) != 0) { // Peut passer le nombre s'il a déjà été vérifié auparavant
                int number2 = amicableMap.get(number1); // Recherche la référence du deuxième nombre à comparer

                //vérifie si les nombres sont amicaux
                if (Objects.equals(amicableMap.get(number1), number2) && Objects.equals(amicableMap.get(number2), number1) && number1 != number2) {
                    sumAmicable += number1 + number2;
                    System.out.printf("(%d : %d)\n", number1, number2);
                    amicableMap.put(number2 , 0); // Passe la valeur à 0 afin de ne plus devoir boucler sur ce nombre comme on en a déjà trouvé un amicable
                }
            }
        }

        System.out.println(sumAmicable);
    }
}