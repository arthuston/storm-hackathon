package src.java;

public class StormBuzzers {

    public static void main(String[] args) throws Exception {

        if (args.length == 1 ) {
            //System.out.println("Usage: ");
            //System.out.println("\t term (text term to search for)");
            String searchTerm = args[0];
            System.out.println("Searching for "+ searchTerm + "...");
            return;
        }
        else
        {
            System.out.println("Searching...");
            return;
        }
    }

}
