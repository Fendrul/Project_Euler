package be.strykers.euler;

public class problem4 {
    public static void main(String[] args) {
        int result = 0;

        for (int i = 100; i <= 999; i++) {
            for (int j = i; j <= 999; j++) {
                int mult = i * j;
                if (isPalindrome(mult))
                    if (mult > result) {
                        result = mult;
                        System.out.println(mult);
                    }
            }
        }

//        System.out.println(isPalindrome(990097));
    }

    private static boolean isPalindrome(int i) {
        String s = Integer.toString(i);
        return s.equals(new StringBuilder(s).reverse().toString());
    }

}
