package be.strykers.euler;

public class problem28 {

    public static final int SPIRAL_LENGTH = 1001;

    public static void main(String[] args) {
        int value = 1;
        int sum = 1;
        for (int spiralLength = 2; spiralLength <= SPIRAL_LENGTH; spiralLength = spiralLength + 2) {
            for (int i = 1; i <= 4; i++) {
                sum += value + spiralLength * i;
            }

            value += 4 * spiralLength;
        }

        System.out.println(sum);
    }
}
