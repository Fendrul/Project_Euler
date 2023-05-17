package be.strykers.console;

import java.util.Scanner;

public interface Console {
    public static final Scanner scan = new Scanner(System.in);

//    Toutes les fonctions jusque print utilisent le fichier ou la lecture de console afin de retourner une valeur du type désiré

    public int integer();

    public boolean integerEdge(int borneInferieure, int borneSuperieure);

    public String string();

    public char character();

    public long longer();

    public double doubled();

    public void print(Object... values);

    public int ReturniInput();
}