import org.jsoup.Jsoup;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class Engine {

    /*VARIABLES*/
    protected static Exchange[] exchangeList = new Exchange[6];
    protected static ArrayList<Stock> stockList = new ArrayList<>();

    //Gets called to ONCE to initialize the program and never again.
    boolean wakeUp() {
        try {
            exchangeList[0] = new Exchange("XNYS", "New York Stock Exchange", "United States",
                    "EST/EDT", 09.30, 16.00);

            exchangeList[1] = new Exchange("XNAS", "Nasdaq Stock Market", "United States",
                    "EST/EDT", 09.30, 16.00);

            exchangeList[2] = new Exchange("XJPX", "Japan Exchange Group", "Japan",
                    "JST", 09.00, 15.00);

            exchangeList[3] = new Exchange("XLON", "London Stock Exchange", "United Kingdom/Italy",
                    "GMT/BST", 08.00, 16.30);

            exchangeList[4] = new Exchange("XSHG", "Shanghai Stock Exchange", "China",
                    "CST", 09.30, 15.00);

            exchangeList[5] = new Exchange("XHKG", "Hong Kong Stock Exchange", "Hong Kong",
                    "HKT", 09.30, 16.00);

            Start();
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }

    }

    //Can be called whenever but recommended to only call to it once from within wakeUp() to start running methods.
    private void Start() {

        TestRun();

    }

    //Gets called every second, Highly recommended to not do anything too intensive in here.
    protected void Update() {

    }

    //Gets called every 15 seconds, can be used to update information that isn't critical for the program to update often.
    protected void FixedUpdate() {

    }

    private void getData() {

        try {
            String webData = Jsoup.connect("").get().body().toString();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    private void TestRun() {

        Stock stock1 = new Stock("ONE", "1", 1);
        Stock stock2 = new Stock("TWO", "2", 1);
        Stock stock3 = new Stock("THREE", "3", 2);
        Stock stock4 = new Stock("ONE", "1", 1);
        Stock stock5 = new Stock("FOUR", "4", 3);

        exchangeList[0].addStock(stock1);
        exchangeList[0].addStock(stock2);
        exchangeList[0].addStock(stock3);
        exchangeList[0].addStock(stock4);
        exchangeList[0].addStock(stock5);

        ArrayList<Stock> stocks = new ArrayList<>();

        stocks.add(stock1);
        stocks.add(stock2);
        stocks.add(stock3);
        stocks.add(stock4);
        stocks.add(stock5);


        exchangeList[1].addStocks(stocks);

        Stock stock6 = new Stock("TXT", "One", 1);
        Stock stock7 = new Stock("TET", "One", 1);
        Stock stock8 = new Stock("TUT", "Two", 2);
        Stock stock9 = new Stock("XTT", "One", 1);
        Stock stock10 = new Stock("TXT", "Three", 3);
        ArrayList<Stock> stocks2 = new ArrayList<>();
        stocks2.add(stock6);
        stocks2.add(stock7);
        stocks2.add(stock8);
        stocks2.add(stock9);
        stocks2.add(stock10);

        exchangeList[1].addStocks(stocks2);
        exchangeList[1].removeStock("XTT");
        System.out.println();

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < stocks2.size(); i++) {
            arrayList.add(stocks2.get(i).getSymbol());

        }

//        exchanges[1].removeStocks(arrayList);


//        for (int i = 0; i < 3; i++) {
//            System.out.println();
//            System.out.println("i:" + i);
//            for (int j = 0; j < 15; j++) {
//                System.out.print("j:" + j);
//            }
//        }

        System.out.println();
        System.out.println("--------------------");
        exchangeList[1].searchForStock("TXT");
        exchangeList[1].searchForStock("XTT");
        System.out.println();
        exchangeList[0].newStock("test", "two", 1.78);
        System.out.println(exchangeList[0].toString());

    }

    protected boolean newStock(String s_Symbol, String s_Name, double s_Price) {
        if (s_Symbol != null && s_Name != null) {
            Stock newStock = new Stock(s_Symbol, s_Name, s_Price);
            return true;
        }
        return false;
    }

    protected boolean addStock(Stock stockToAdd) {

        if (stockToAdd != null) {
            if (stockList.size() == 0) {
                System.out.println("[SUCCESS] ---> Engine.addStock(Stock stockToAdd) ---> [" + stockToAdd.getSymbol().toUpperCase() + "] - " + stockToAdd.s_Name + "has been added to STOCKS_LIST @ " + stockToAdd.s_Price + " per share.");
                stockList.add(stockToAdd);
                return true;

            } else {

                if (!stockList.contains(stockToAdd)) {
                    stockList.add(stockToAdd);
                    return true;
                } else {
                    System.out.println("[FAILED] ---> Engine.addStock(Stock stockToAdd) ---> tried adding [" + stockToAdd.getSymbol().toUpperCase() + "] to STOCK_LIST but it already exists.");
                    return false;
                }

            }
        }
        return false;
    }

    protected boolean addStocks(ArrayList<Stock> stocksToAdd) {
        if (stocksToAdd != null) {
            if (stockList.size() == 0) {
                stockList.add(stocksToAdd.get(0));

                for (int i = 1; i < stocksToAdd.size(); i++) {
                    for (int j = 0; j < stockList.size(); j++) {
                        if (!stockList.contains(stocksToAdd.get(i))) {
                            System.out.println("[SUCCESS] ---> Exchange.addStock(Stock stockToAdd) ---> [" + stocksToAdd.get(i).getSymbol() + "] has been added to STOCKS_LIST.");
                            stockList.add(stocksToAdd.get(i));
                        } else if (stockList.contains(stocksToAdd.get(i))) {
                            break;
                        }
                    }
                }

            } else {
                for (int i = 0; i < stocksToAdd.size(); i++) {
                    if (!stockList.contains(stocksToAdd.get(i))) {
                        System.out.println("[SUCCESS] ---> Exchange.addStock(Stock stockToAdd) ---> [" + stocksToAdd.get(i).getSymbol() + "] has been added to STOCKS_LIST.");
                        stockList.add(stocksToAdd.get(i));
                    } else {
                        System.out.println("[FAILED] ---> Exchange.addStock(Stock stockToAdd) ---> tried adding [" + stocksToAdd.get(i).getSymbol() + "] to STOCK_LIST but it already exists.");
                        break;
                    }
                }
            }
        }
        return false;
    }

    protected boolean removeStock(String stockSymbol) {

        if (stockSymbol != null) {
            for (int i = 0; i < stockList.size(); i++) {
                if (stockList.get(i).getSymbol().equalsIgnoreCase(stockSymbol)) {
                    stockList.remove(i);
                    System.out.println("[SUCCESS] ---> Exchange.addStocks(ArrayList<Stock> stocksToAdd) ---> [" + stockSymbol + "] has been removed from STOCK_LIST.");

                    return true;
                }
            }
            System.out.println("[FAILED] ---> Exchange.addStock(Stock stockToAdd) ---> tried adding [" + stockSymbol + "] to STOCK_LIST but it already exists.");
            return false;
        }
        return false;
    }

    protected boolean removeStocks(ArrayList<String> stocksToRemove) {

        if (stocksToRemove != null) {

            //TODO: 3/14/2021 FINISH THIS


        }
        return false;
    }

    protected boolean searchForStock(String stockSymbol) {

        if (stockSymbol != null) {
            for (int i = 0; i < stockList.size(); i++) {
                if (stockList.get(i).getSymbol().equalsIgnoreCase(stockSymbol)) {
                    //Print info about the stock
                    System.out.println("[SUCCESS] ---> Exchange.searchForStock(String stockSymbol) ---> [" + stockSymbol + "] has been found in STOCKS_LIST.");
                    return true;
                }
            }
        }
        System.out.println("[FAILED] ---> Exchange.searchForStock(String stockSymbol) ---> Couldn't find [" + stockSymbol + "] in STOCKS_LIST.");
        return false;
    }

    protected boolean searchForStocks(ArrayList<String> stocksToFind) {
        // TODO: 3/14/2021 FINISH THIS
        return false;
    }

}
