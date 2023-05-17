package be.strykers.console;

public class ConsoleBuilder implements Console {
    private final Console console;

    //si aucun lien n'est donné, le builder crée un lecteur de console.
    //Sinon, il cére un lecteur de fichier.
    public ConsoleBuilder() {
        console = new ConsoleViaScan();
    }

    public ConsoleBuilder(String filePath) {
        console = new ConsoleViaFichier(filePath);
    }

    @Override
    public int integer() {
        return console.integer();
    }

    @Override
    public boolean integerEdge(int borneInferieure, int borneSuperieure) {
        return console.integerEdge(borneInferieure, borneSuperieure);
    }

    @Override
    public String string(){
        return console.string();
    }

    @Override
    public char character() {
        return console.character();
    }

    @Override
    public long longer() {
        return console.longer();
    }

    @Override
    public double doubled() {
        return console.doubled();
    }

    @Override
    public void print(Object... values) {
        console.print(values);
    }

    @Override
    public int ReturniInput() {
        return 0;
    }
}
