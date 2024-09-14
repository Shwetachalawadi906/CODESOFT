package om.jsp.converter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private static Map<String, Double> exchangeRates = new HashMap<>();

    public static void main(String[] args) {
        initializeExchangeRates();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");
        System.out.println("Available currencies: USD, EUR, GBP, JPY");

        System.out.print("Enter the base currency: ");
        String baseCurrency = scanner.next();

        System.out.print("Enter the target currency: ");
        String targetCurrency = scanner.next();

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        double exchangeRate = fetchExchangeRate(baseCurrency, targetCurrency);

        if (exchangeRate != -1) {
            double convertedAmount = amount * exchangeRate;
            System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
        } else {
            System.out.println("Invalid currency selection.");
        }
    }

    private static void initializeExchangeRates() {
        
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.73);
        exchangeRates.put("JPY", 110.0);
    }

    private static double fetchExchangeRate(String baseCurrency, String targetCurrency) 
    {
        if (exchangeRates.containsKey(baseCurrency) && exchangeRates.containsKey(targetCurrency)) {
            return exchangeRates.get(targetCurrency) / exchangeRates.get(baseCurrency);
        }
        return -1;
    }
}
