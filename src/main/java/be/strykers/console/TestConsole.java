package be.strykers.console;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TestConsole {

    public static void main(String[] args) throws FileNotFoundException {
        Console cons = new ConsoleBuilder("C:\\Users\\simon\\IdeaProjects\\Decouverte\\src\\be\\technifutur\\decouverte\\console\\testConsole.txt");

        cons.print("Donnez un nombre");
        int test = cons.integer();
        cons.print(test, " Est la valeur de : ", test);

        int[] array = { 1, 2, 3, 4, 5 };
        List<List<Integer>> list = new ArrayList<>();
    }
}