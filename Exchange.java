import java.util.ArrayList;

public class Exchange extends Engine {

    /*VARIABLES*/

    protected final String e_MIC;
    protected final String e_Name;
    protected final String e_Region;
    protected final String e_TimeZone;
    protected double e_OpenTime = 00.00;
    protected double e_CloseTime = 00.00;


    /*CONSTRUCTORS*/

    protected Exchange() {
        this.e_MIC = "EXCN";
        this.e_Name = "Exchange Name";
        this.e_Region = "Region";
        this.e_TimeZone = "TimeZone";
        this.e_OpenTime = 00.00;
        this.e_CloseTime = 00.00;
    }

    protected Exchange(String e_MIC, String e_Name, String e_Region, String e_TimeZone, double e_OpenTime, double e_CloseTime) {
        this.e_MIC = e_MIC.toUpperCase();
        this.e_Name = e_Name;
        this.e_Region = e_Region;
        this.e_TimeZone = e_TimeZone.toUpperCase();
        this.e_OpenTime = e_OpenTime;
        this.e_CloseTime = e_CloseTime;
    }

    protected Exchange(String e_MIC, String e_Name, String e_Region, String e_TimeZone, double e_OpenTime, double e_CloseTime, ArrayList<Stock> e_StockList) {
        this.e_MIC = e_MIC.toUpperCase();
        this.e_Name = e_Name;
        this.e_Region = e_Region;
        this.e_TimeZone = e_TimeZone.toUpperCase();
        this.e_OpenTime = e_OpenTime;
        this.e_CloseTime = e_CloseTime;
        this.addStocks(e_StockList);
    }

    /*GETTER & SETTER METHODS*/

    protected String getE_MIC() {
        return this.e_MIC;
    }

    protected String getE_Name() {
        return this.e_Name;
    }

    protected String getE_Region() {
        return this.e_Region;
    }

    protected String getExchange_TimeZone() {
        return this.e_TimeZone;
    }

    protected double getExchange_OpenTime() {
        return this.e_OpenTime;
    }

    protected double getExchange_CloseTime() {
        return this.e_CloseTime;
    }

    protected int getSize() {
        return stockList.size();
    }

    /*Methods*/

    public String toString() {
        return "Exchange Information: \n" + " Market Identifier Code: " + this.getE_MIC() + "\n Stock Exchange: " + this.getE_Name() + "\n Region: " + this.getE_Region() + "\n Timezone: " + this.getExchange_TimeZone() + " \n Open: " + this.getExchange_OpenTime() + "\n Close: " + this.getExchange_CloseTime();
    }

}
