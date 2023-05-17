package be.strykers.euler;

import java.math.BigInteger;

public class problem25 {
    public static void main(String[] args) {
        BigInteger fibonaci = new BigInteger("1");
        BigInteger fibonaciLast = new BigInteger("0");
        int index  = 1;

        while(fibonaci.toString().length() < 1000) {
            fibonaci = fibonaci.add(fibonaciLast);
            fibonaciLast = fibonaci.subtract(fibonaciLast);
            index++;
        }

        System.out.println(index);
    }
}
