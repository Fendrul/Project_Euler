package be.strykers.euler;


import be.strykers.console.ConsoleViaFichier;

import java.io.IOException;

public class problem18 {
        public static void main(String[] args) throws IOException {
                ConsoleViaFichier cons = new ConsoleViaFichier("src\\main\\java\\be\\strykers\\euler\\ressources\\problem67.txt");
//              src\main\java\be\strykers\euler\ressources\problem67.txt

                int[][] tab = cons.intTab(" ");
                int tabLength = tab.length;

                int result = maximumSumPath(tab, tabLength);

                System.out.println(result);
        }

        public static int maximumSumPath(int tab[][], int depth) {
                int maxResult = 0;

                if (depth == 1)
                        maxResult = tab[0][0];
                else {
                        int tempResult1 = maximumSumPath(tab, depth - 1, 0, 1);
                        int tempResult2 = maximumSumPath(tab, depth - 1, 1, 1);

                        maxResult = Math.max(tempResult1, tempResult2);
                }

                return maxResult + tab[0][0];
        }

        public static int maximumSumPath(int[][] tab, int depth, int i, int j) {
                int maxResult = 0;

                if (depth != 1) {
                        int tempResult1 = maximumSumPath(tab, depth - 1, i, j+1);
                        int tempResult2 = maximumSumPath(tab, depth - 1, i+1, j+1);

                        maxResult = Math.max(tempResult1, tempResult2);
                }

                return maxResult + tab[j][i];
        }
}
