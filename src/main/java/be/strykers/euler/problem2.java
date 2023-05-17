package be.strykers.euler;

public class problem2 {
    public static void main(String[] args) {
        int fiboprev = 1;
        int fibo = 1;
        int result = 0;

        while (fibo < 4000000) {
            fibo+= fiboprev;
            fiboprev= fibo - fiboprev;
            System.out.println(fibo);

            if (fibo%2 == 0)
                result+= fibo;
        }

        System.out.println(result);
    }
}
