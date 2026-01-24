package Session8.Bai1s8.Bai3s8;

public class main {


    public static void main(String[] args) {

        CurrencyConverter.setRate(5);


        double usd = CurrencyConverter.toUSD(10000);
        System.out.println(CurrencyConverter.formatUSD(usd));

    }




}
