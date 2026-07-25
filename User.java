import java.util.HashMap;

public class User {

    private String name;
    private double balance;
    private HashMap<String, Integer> portfolio;

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.portfolio = new HashMap<>();
    }

    public double getBalance() {
        return balance;
    }

    public void buyStock(String stockName, int quantity, double price) {

        double cost = quantity * price;

        if (cost <= balance) {
            balance -= cost;
            portfolio.put(stockName,
                    portfolio.getOrDefault(stockName, 0) + quantity);

            System.out.println("Stock Purchased Successfully!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void sellStock(String stockName, int quantity, double price) {

        if (portfolio.containsKey(stockName)
                && portfolio.get(stockName) >= quantity) {

            portfolio.put(stockName,
                    portfolio.get(stockName) - quantity);

            balance += quantity * price;

            System.out.println("Stock Sold Successfully!");
        } else {
            System.out.println("Not Enough Shares!");
        }
    }

    public void displayPortfolio() {

        System.out.println("\n===== Portfolio =====");
        System.out.println("Balance: ₹" + balance);

        for (String stock : portfolio.keySet()) {
            System.out.println(stock + " : "
                    + portfolio.get(stock) + " shares");
        }
    }
}