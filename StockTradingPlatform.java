import java.util.ArrayList;
import java.util.Scanner;

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Stock> market = new ArrayList<>();

        market.add(new Stock("TCS", 3500));
        market.add(new Stock("Infosys", 1500));
        market.add(new Stock("Wipro", 300));

        User user = new User("Abhinav", 100000);

        int choice;

        do {

            System.out.println("\n===== Stock Trading Platform =====");
            System.out.println("1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\nAvailable Stocks:");

                    for (Stock s : market) {
                        System.out.println(
                                s.getName() + " - ₹" + s.getPrice());
                    }

                    break;

                case 2:

                    System.out.print("Enter Stock Name: ");
                    String buyStock = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int buyQty = sc.nextInt();

                    for (Stock s : market) {

                        if (s.getName().equalsIgnoreCase(buyStock)) {

                            user.buyStock(
                                    s.getName(),
                                    buyQty,
                                    s.getPrice());

                            break;
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter Stock Name: ");
                    String sellStock = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int sellQty = sc.nextInt();

                    for (Stock s : market) {

                        if (s.getName().equalsIgnoreCase(sellStock)) {

                            user.sellStock(
                                    s.getName(),
                                    sellQty,
                                    s.getPrice());

                            break;
                        }
                    }

                    break;

                case 4:

                    user.displayPortfolio();
                    break;

                case 5:

                    System.out.println("Thank You!");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}