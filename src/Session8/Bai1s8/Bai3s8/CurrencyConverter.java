package Session8.Bai1s8.Bai3s8;

public class CurrencyConverter {

    private static double moneyrate = 1;

    private CurrencyConverter() {

    }

    public static void setRate(double r) {

        if (r <= 0) {
            throw new IllegalArgumentException("Tỉ giá phải lớn hơn 0");
        }
        moneyrate = r;
    }


    public static double getRate() {
        return moneyrate;
    }

    public static double toUSD(double mrate) {

    return moneyrate *mrate;
    }

    public static String formatUSD(double usd) {

        String str = String.format("%.2f", usd);
        return str;
    }

}


