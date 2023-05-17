package be.strykers.console;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Toutes les fonctions de scan de console vont boucler jusqu'à avoir le type de valeur voulue
 */
public class ConsoleViaFichier implements Console {

    private BufferedReader br;



    public ConsoleViaFichier(String cheminFichier) {
        try {
            br = new BufferedReader(new FileReader(new File(cheminFichier)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Fichier non trouvé - " + e);
        }
    }

    public void close() {
        if (br != null) {
            try {
                System.out.println("fermeture du fichier");
                br.close();
            } catch (IOException ex) {
                System.out.println("Échec dans la fermeture de fichier");
            }
        }
    }

    public boolean hasNext() throws IOException {
        return br.ready();
    }

    public int[] lineArray(String separator) {
        return Arrays.stream(string() // string est une fonction de la classe renvoyant une ligne du fichier en tant que String
                .split(separator))
                .mapToInt(Integer::parseInt) // traite chaque élément pour les transformer en un int
                .toArray(); //converti le steam d'int en un int[]
    }

    /**
     * !!! cette méthode lit l'entièreté du fichier pour le transformer en un int[][]
     * @param separator le(s) caractère(s) servant à séparer une ligne en un array
     * @return le tableau construit sur base du fichier
     * @throws IOException
     */
    public int[][] intTab(String separator) throws IOException {
        List<List<Integer>> listTab = new ArrayList<>();

        while (hasNext()) {
            List<Integer> entry = Arrays.stream(lineArray(separator))
                    .boxed()// Converti les valeurs primitives du stream en leur objet correspondant (ex : int -> Integer)
                    .collect(Collectors.toList()); // crée un collecteur des éléments puis les transforme en un seul objet (ici une List)

            listTab.add(entry);
        }

        return listTab.stream()
                .map(l -> l.stream().mapToInt(x -> x).toArray())
                .toArray(int[][]::new);
    }

    @Override
    public int integer() {
        String st;

        try {
            if ((st = br.readLine()) != null)
                return Integer.parseInt(st);

        } catch (IllegalArgumentException ignored) {
            print("ConsoleViaFichier.integer : mauvais nombre inséré, un long était attendu");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    @Override
    public boolean integerEdge(int borneInferieure, int borneSuperieure) {
        String st;

        try {
            if ((st = br.readLine()) != null)
                return Integer.parseInt(st) >= borneInferieure && Integer.parseInt(st) <= borneSuperieure;

        } catch (IllegalArgumentException ignored) {
            print("ConsoleViaFichier.integer : mauvais nombre inséré, un long était attendu");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public String toString() {
        return "ConsoleViaFichier{" +
                "br=" + br +
                '}';
    }

    @Override
    public int ReturniInput() {
        return 0;
    }

    @Override
    public String string() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public char character() {
        return 0;
    }

    @Override
    public long longer() {
        return 0;
    }

    @Override
    public double doubled() {
        return 0;
    }

    @Override
    public void print(Object... values) {
        for (Object o :
                values) {
            System.out.print(o);
        }
        System.out.println();
    }
}
