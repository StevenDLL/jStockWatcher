import java.util.ArrayList;
import java.util.Scanner;

public class Listener extends Brain {

    //TODO:
    // - Continue programming the Investor class. Add a money property, a buy method, a sell method and any other i think of during that day.
    // -
    // DATA USED: https:en.wikipedia.org/wiki/List_of_stock_exchanges

    /*VARIABLES*/
    private static final String PREFIX = "~";


    public static void main(String[] args) {
        System.out.println("Type ~help for commands");
        Listen();
    }

    public static void Listen() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.contains(" ")) {
            String[] args = input.split(" ");
            if (args[0].equalsIgnoreCase(PREFIX + "AddStock")) {

                if (!args[1].isBlank() && !args[2].isBlank() && !args[3].isBlank() && args.length == 4) {
                    addStockCommand(args[1], args[2], Double.parseDouble(args[3]));
                }

            } else if (args[0].equalsIgnoreCase(PREFIX + "RemoveStock")) {

                if (!args[1].isBlank() && args.length == 2) {
                    removeStockCommand(args[1]);
                }

            }
        } else {
            if (input.equalsIgnoreCase(PREFIX + "Help")) {

                helpCommand();
                Listen();

            } else if (input.equalsIgnoreCase(PREFIX + "WakeUp")) {

                wakeUpCommand();
                Listen();

            } else if (input.equalsIgnoreCase(PREFIX + "Info")) {

                infoCommand();
                Listen();

            } else if (input.equalsIgnoreCase(PREFIX + "Exit")) {

                exitCommand();

            }
        }
    }

    private static void helpCommand() {

        System.out.println();
        System.out.println("Available Commands:");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("--| ~Help                                |-> Displays this menu                              |--");
        System.out.println("--|------------------------------------------------------------------------------------------|--");
        System.out.println("--| ~Info                                |-> Displays info about program creator             |--");
        System.out.println("--|------------------------------------------------------------------------------------------|--");
        System.out.println("--| ~WakeUp                              |-> Starts running the program                      |--");
        System.out.println("--|------------------------------------------------------------------------------------------|--");
        System.out.println("--| ~AddStock [Symbol] [Name] [Price]    |-> Add a stock with the given parameters           |--");
        System.out.println("--|------------------------------------------------------------------------------------------|--");
        System.out.println("--| ~RemoveStock [Symbol]                |-> Remove a stock by the given symbol              |--");
        System.out.println("--|------------------------------------------------------------------------------------------|--");
        System.out.println("--| ~RemoveStocks [Symbol] [Symbol] +... |-> Remove multiple stocks by the given symbols     |--");
        System.out.println("--|------------------------------------------------------------------------------------------|--");
        System.out.println("--| ~Exit                                |-> Exit the program                                |--");
        System.out.println("------------------------------------------------------------------------------------------------");
    }

    private static void infoCommand() {

        System.out.println();
        System.out.println("Created By: StevenDLL");
        System.out.println("Github Account: https://github.com/StevenDLL");
        System.out.println("Version: " + VERSION);
        System.out.println("Last Updated: " + LAST_UPDATED);

    }

    private static void wakeUpCommand() {
        if(ENGINE.wakeUp()){
            Brain.callUpdate();
            Brain.callFixedUpdate();
        }
    }

    private static void addStockCommand(String s_Symbol, String s_Name, double s_Price) {

        try {
            Stock newStock = new Stock(s_Symbol, s_Name, s_Price);
            ENGINE.addStock(newStock);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void removeStockCommand(String s_Symbol) {

        try {
            ENGINE.removeStock(s_Symbol);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    private static void removeStocksCommand(ArrayList<String> s_Symbols) {
        try {
            ENGINE.removeStocks(s_Symbols);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void exitCommand() {
        // TODO: 3/14/2021 Make it so when this is called everything is setup to exit and check if there were any issues.
        System.out.println("Exiting Program...");
        System.out.println("Program Exited");
        System.exit(0);

    }

}
