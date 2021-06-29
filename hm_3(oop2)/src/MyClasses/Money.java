package MyClasses;

public class Money {
    public int dollars;
    public int euro;
    public int hrn;

    public int cents;
    public int eurocents;
    public int coins;

    public Money(int dollars, int euro, int hrn, int cents, int eurocents, int coins) {
        this.dollars = dollars;
        this.euro = euro;
        this.hrn = hrn;
        this.cents = cents;
        this.eurocents = eurocents;
        this.coins = coins;
    }

    public Money() {
        this.dollars = 0;
        this.euro = 0;
        this.hrn = 0;
        this.cents = 0;
        this.eurocents = 0;
        this.coins = 0;
    }

    public int getDollars() {
        return dollars;
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    public int getEuro() {
        return euro;
    }

    public void setEuro(int euro) {
        this.euro = euro;
    }

    public int getHrn() {
        return hrn;
    }

    public void setHrn(int hrn) {
        this.hrn = hrn;
    }

    public int getCents() {
        return cents;
    }

    public void setCents(int cents) {
        this.cents = cents;
    }

    public int getEurocents() {
        return eurocents;
    }

    public void setEurocents(int eurocents) {
        this.eurocents = eurocents;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    @Override
    public String toString() {
        return "Money{" +
                "dollars=" + dollars +
                ", euro=" + euro +
                ", hrn=" + hrn +
                ", cents=" + cents +
                ", eurocents=" + eurocents +
                ", coins=" + coins +
                '}';
    }
}
