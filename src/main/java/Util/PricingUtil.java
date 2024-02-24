package Util;

public class PricingUtil {

    public double splitPricingWithCurrency(String price) {
        return Double.parseDouble(price.split("\\$")[1]);
    }
}
