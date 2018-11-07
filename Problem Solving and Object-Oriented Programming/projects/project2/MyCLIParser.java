public class MyCLIParser {
    public static void main(String[] args) {
        // if no arguments, print help and return
        if (args.length == 0) {
            help(args);
            return;
        }
        //-help
        else if (args[0].equals("-help"))  help(args);
        //-add
        else if (args[0].equals("-add"))   add(args);
        //-sub
        else if (args[0].equals("-sub"))   sub(args);
        //-mul
        else if (args[0].equals("-mul"))   mul(args);
        //-div
        else if (args[0].equals("-div"))   div(args);
        //-stats
        else if (args[0].equals("-stats")) stats(args);
        //-table
        else if (args[0].equals("-seq")) seq(args);
    }

    public static boolean isInteger(String s) {
        // CODE HERE
        return false;
    }

    private static void help(String[] args) {
        // CODE HERE
    }

    private static void add(String[] args) {
        // CODE HERE
    }

    private static void sub(String[] args) {
        // CODE HERE
    }

    private static void mul(String[] args) {
        // CODE HERE
    }

    private static void div(String[] args) {
        // CODE HERE
    }

    private static void stats(String[] args) {
        // CODE HERE
    }

    private static void seq(String[] args) {
        // CODE HERE
    }
}
