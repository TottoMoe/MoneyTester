package com.bookexample;

public class Money {
    private double moneyNumber;
    private int dollars;
    private int cents;

    public Money() {
        moneyNumber = 0;
        dollars = 0;
        cents = 0;
    }

    public Money(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
        moneyNumber = this.dollars + (this.cents/100.0);
    }

    public Money add(Money m) {
        double moneyNum = this.moneyNumber + m.moneyNumber;
        Money total = new Money();
        normalize(moneyNum, total);
        return new Money(total.dollars, total.cents);
    }

    public Money substract(Money m) {
        double moneyNum = this.moneyNumber - m.moneyNumber;
        Money moneyNew = new Money();
        normalize(moneyNum, moneyNew);
        return new Money(moneyNew.dollars, moneyNew.cents);
    }

    public Money multiply(int m) {
        double moneyNum = this.moneyNumber * m;
        Money total = new Money();
        normalize(moneyNum,total);
        return new Money(total.dollars, total.cents);
    }

    public static Money[] multiply(Money[] moneys, int amt) {
        Money[] newMoneys = new Money[moneys.length];
        for (int i = 0; i < newMoneys.length; i++) {
            newMoneys [i] = new Money();
        }
        for (int j = 0; j < newMoneys.length; j++) {
            newMoneys[j].moneyNumber = moneys[j].moneyNumber * amt;
        }
        return newMoneys;
    }

    public boolean equals(Money money) {
        if (moneyNumber == money.moneyNumber) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return Double.toString(moneyNumber);
    }

    private void normalize(double moneyNum, Money m) {
        m.dollars = (int)moneyNum % 100;
        m.cents = (int)((moneyNum - m.dollars) * 100);
    }// normalize dollars and cents field
}
