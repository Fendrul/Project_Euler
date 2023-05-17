package be.strykers.euler;

public class problem9 {
    public static void main(String[] args) {
        int[] result = new int[3];

        for (int i = 1; i < 999; i++) {
            for (int j = i+1; j < 1000; j++) {
                for (int k = j+1; k < 1000; k++) {
                    if(i+j+k == 1000 && Math.pow(i,2) + Math.pow(j, 2) == Math.pow(k, 2)){
                        result[0] = i;
                        result[1] = j;
                        result[2] = k;
                    }
//                    System.out.printf("i: %d, j: %d, k: %d\n", i, j, k);
                }
            }
        }

        for (Integer i :
                result) {
            System.out.println(i);
        };
        System.out.printf("Le résultat est %d\n", (long)result[0] * result[1] * result[2]);
    }
}
