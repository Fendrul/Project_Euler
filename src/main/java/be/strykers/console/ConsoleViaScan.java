package be.strykers.console;

public class ConsoleViaScan implements Console {

    public int iInput = 0;
    @Override
    public int integer() {
        int returnValue = 0;
        boolean correctInput = false;

        while (!correctInput)  {
            try {
                returnValue = Integer.parseInt(scan.nextLine());
                correctInput = true;
            } catch (IllegalArgumentException ignored) {
                print("mauvais nombre inséré, un entier était attendu");
            }
        }

        return returnValue;
    }

    public boolean integerEdge(int borneInferieure, int borneSuperieure) {
        int returnValue = 0;
        boolean correctInput = false;

        while (!correctInput)  {
            try {
                returnValue = Integer.parseInt(scan.nextLine());
                correctInput = true;
            } catch (IllegalArgumentException ignored) {
                print("mauvais nombre inséré, un entier était attendu");
            }
        }

        return returnValue >= borneInferieure && iInput <= borneSuperieure;
    }

    /**
     * Cette méthode devra être supprimée dans une version ultérieure, n'ajoutant pas de fonctionnalité utile
     * @return
     */
    @Override
    public int ReturniInput() {
        int tempIIinput = iInput;
        iInput = 0;
        return tempIIinput;
    }

    @Override
    public String string() {
        return scan.nextLine() ;
    }

    @Override
    public char character() {
        return scan.next().charAt(0);
    }

    @Override
    public long longer() {
        long returnValue = 0;
        boolean correctInput = false;

        while (!correctInput)  {
            try {
                returnValue = Long.parseLong(scan.nextLine());
                correctInput = true;
            } catch (IllegalArgumentException ignored) {
                print("mauvais nombre inséré, un long était attendu");
            }
        }

        return returnValue;
    }

    @Override
    public double doubled() {
        double returnValue = 0;
        boolean correctInput = false;

        while (!correctInput)  {
            try {
                returnValue = Double.parseDouble(scan.nextLine());
                correctInput = true;
            } catch (IllegalArgumentException ignored) {
                print("mauvais nombre inséré, un double était attendu");
            }
        }

        return returnValue;
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
