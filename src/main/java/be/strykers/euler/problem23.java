package be.strykers.euler;

import java.util.*;

public class problem23 {

    public static final int LIMIT_POSITIVE_INT = 28124;

    public static void main(String[] args) {
        HashMap<Integer, Integer> abudantNumMap = new HashMap<>();
        List<Integer> abudantNumList = new ArrayList<>();
        Set<Integer> intNotSum = new HashSet<>();

        for (int i = 1; i <= LIMIT_POSITIVE_INT; i++) {
            intNotSum.add(i);
        }

        abudantNumbers(abudantNumMap, LIMIT_POSITIVE_INT);

        // transfère la map vers une liste pour avoir plus de facilité à travailler avec dans les boucles
        abudantNumMap.forEach((key, value) -> {
            abudantNumList.add(key);
        });

        Collections.sort(abudantNumList); //pas d'utilité, mais ça fait plaisir à mon PTSD

        for (int i = 0; i < abudantNumList.size(); i++) {
            for (int j = i; j < abudantNumList.size(); j++) {
                int sum = abudantNumList.get(i) + abudantNumList.get(j);
                intNotSum.remove(sum);
            }
        }

        int result = intNotSum.stream()
                .mapToInt(i -> i) // Transforme le stream en un IntStream
                .sum();
        System.out.println(result);
    }

    private static void abudantNumbers(HashMap<Integer, Integer> abudantNumMap, int limit) {
        HashMap<Integer, Integer> sumDivisors = new HashMap<>();
        sumDivisors(sumDivisors, limit);

        sumDivisors.forEach((key, value) -> {
            if (value > key)
                abudantNumMap.put(key, value);
        });
    }

    private static void sumDivisors(HashMap<Integer, Integer> sumDivMap, int limit) {
        for (int counter = 1; counter <= limit; counter++) {
            int sumDivisors = 0;

            for (int divisor = 1; divisor <= Math.sqrt(counter); divisor++) {
                if (counter % divisor == 0) {
                    sumDivisors += divisor;
                    sumDivisors += counter / divisor; // Ajoute chaque diviseurs en miroir comme ils peuvent être trouvé à partir du premier diviseur
                }
            }
            sumDivisors -= counter; // retire le nombre lui-même qui se retrouve ajouté par les diviseurs miroirs

            if (Math.sqrt(counter) % 1 == 0)
                sumDivisors -= Math.sqrt(counter);

            sumDivMap.put(counter, sumDivisors);
        }
    }
}
