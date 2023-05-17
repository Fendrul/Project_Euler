package be.strykers.euler;

public class problem31 {

    public static final int MONEY_VALUE = 200;

    public static void main(String[] args) {
        int[] coins = {200, 100, 50, 20, 10, 5, 2, 1};

        Distributeur.leCoin(MONEY_VALUE);

        Distributeur.printPossibilities();

        //Pour chaque pièce, prendre le max de la valeur possible et calculer la suite
        //décrémenter la valeur possible de 1 et renvoyer ainsi de suite

    }
}

class Distributeur {

    public static int possibilities = 0;
    public static final int[] coins = {200, 100, 50, 20, 10, 5, 2, 1};

    public static void leCoin  (int money) {
        calc(money, 0);
    }

    public static void calc(int money, int depth) {

        if (depth == coins.length - 1) {
            possibilities++;

        } else {
            int divQtt = money / coins[depth];

            for (int i = 0; i <= divQtt; i++) {
                calc(money, depth+1);
                money -= coins[depth];
            }
        }
    }

    public static void printPossibilities() {
        System.out.println(possibilities);
    }
}