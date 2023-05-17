package be.strykers.euler;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problem13 {
    public static void main(String[] args) {

        File file = new File("src\\main\\java\\be\\strykers\\euler\\ressources\\problem13.txt");
        try (Scanner scan = new Scanner(file)) {
            List<BigInteger> numbers = new ArrayList<>();

            while (scan.hasNextLine()) {
                BigInteger bigInt = new BigInteger(scan.nextLine());
                numbers.add(bigInt);
            }

            BigInteger sum = BigInteger.valueOf(0);
            for (BigInteger i :
                    numbers) {
                sum = sum.add(i);
            }
            String s = sum.toString();
            System.out.print(s.substring(0, 10));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
