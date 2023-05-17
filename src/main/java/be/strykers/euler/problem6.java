package be.strykers.euler;

public class problem6 {
    public static void main(String[] args) {
        int sumSquare = 0;
        int sum = 0;

        for (int i = 1; i <= 100; i++) {
            sum += i;
            sumSquare += Math.pow(i, 2);
        }

        sum = (int)Math.pow(sum, 2);
        System.out.println(sum);
        System.out.println(sum - sumSquare);
    }
}
