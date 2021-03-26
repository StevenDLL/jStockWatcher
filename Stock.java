public class Stock {

    /*VARIABLES*/
    protected final String s_Symbol;
    protected final String s_Name;
    protected double s_Price;
    protected double s_PreviousPrice;
    protected double s_PriceChange;

    /*CONSTRUCTORS*/
    protected Stock() {
        this.s_Symbol = "STKN";
        this.s_Name = "Stock Name";
        this.s_Price = 0.0;
        this.s_PreviousPrice = 0.0;
        this.s_PriceChange = 0.0;
    }

    protected Stock(String s_Symbol, String s_Name, double s_Price) {
        this.s_Symbol = s_Symbol;
        this.s_Name = s_Name;
        this.s_PreviousPrice = this.s_Price;
        this.s_Price = s_Price;
        this.s_PriceChange = 0;
    }

    protected void setPriceChange(double newPriceChange) {
        this.s_PriceChange = newPriceChange;
    }

    protected String getSymbol() {
        return this.s_Symbol;
    }

    protected boolean updateStock(double s_Price) {
        this.s_PreviousPrice = this.s_Price;
        this.s_Price = s_Price;
        this.s_PriceChange = s_PreviousPrice - s_Price;
        return true;
    }

    public boolean equals(Object o) {
        if (o instanceof Stock) {
            return ((Stock) o).getSymbol().equalsIgnoreCase(this.getSymbol());
        } else {
            return false;
        }
    }

    public String toString() {
        return "[" + this.s_Symbol + "] - " + this.s_Name + " @ [" + this.s_Price + "] Per Share";
    }

}
