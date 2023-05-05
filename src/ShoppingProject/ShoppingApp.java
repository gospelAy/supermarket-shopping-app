package ShoppingProject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingApp {

    List<Integer> piecesQTY = new ArrayList<>();
    List<String> userItems = new ArrayList<>();
    List<Integer> priceOfItems = new ArrayList<>();

    int subTotal;
    int discount;
    String customer;

    Scanner input = new Scanner(System.in);

    public void promptUser() {
        System.out.println("What is the customer's name? ");
        String customer = input.nextLine();

        System.out.println("What did the user buy? ");
        String user = input.nextLine();
        userItems.add(user);

        System.out.println("How many pieces? ");
        int pieces = input.nextInt();
        piecesQTY.add(pieces);

        System.out.println("How much per unit? ");
        double unit = input.nextInt();
        input.nextLine();
        priceOfItems.add((int) unit);

        System.out.println("Add more items?");
        String item = input.nextLine();
        if (item.equalsIgnoreCase("yes")) {
            promptUser();
        } else if (item.equalsIgnoreCase("no"))
            System.out.println("What is your name? ");
        String name = input.nextLine();

        System.out.println("How much discount will he get? ");
        int discount = input.nextInt();
        input.nextLine();

        System.out.println("""
                SEMICOLON STORES
                MAIN BRANCH
                LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
                TEL: 03293828343""");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d:MMM:yy h:m:s a");
//        LocalDateTime dateTime = LocalDateTime.now();
//        System.out.println(formatter + " " + dateTime);
        System.out.println("Date: " + LocalDateTime.now());
        System.out.println("Cashier: Cashier's Name");
        System.out.println("Customer Name: " + customer);
        System.out.println("====================================================================");
        System.out.print("""
                    ITEM       QTY      PRICE     TOTAL(NGN)
                ------------------------------------------------------------
                """);
        for (int i = 0; i < userItems.size(); i++) {
            System.out.println(userItems.get(i) + "         " + piecesQTY.get(i) + "        " + priceOfItems.get(i) + "       " + piecesQTY.get(i) * priceOfItems.get(i));
            subTotal += (piecesQTY.get(i) * priceOfItems.get(i));
        }
        System.out.println("--------------------------------------------------------------------");

        System.out.println("Sub Total: " + subTotal);
        double discountAmount = discount * subTotal / 100.0;
        System.out.println("Discount: " + discountAmount);
        double vatRate = 0.175;
        double vat = subTotal * vatRate;
        System.out.printf("VAT @ %.2f%%: %.2f NGN%n", vatRate * 100, vat);
        System.out.println("=====================================================================");
        double billTotal = subTotal + vat - discountAmount;
        System.out.printf("Bill Total: %.2f NGN%n", billTotal);
        System.out.println("====================================================================");
        System.out.println("THIS IS NOT A RECEIPT KINDLY PAY " + billTotal);
        System.out.println("====================================================================");
        System.out.println();
    }
    public void payment(){
        System.out.println("How Much did the customer give to you? ");
        String pay = input.nextLine();
        System.out.println();
        lastReceipt();
    }
    public void lastReceipt(){
        System.out.println("""
                SEMICOLON STORES
                MAIN BRANCH
                LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
                TEL: 03293828343""");
        System.out.println("Date: " + LocalDateTime.now());
        System.out.println("Cashier: Cashier's Name");
        System.out.println("Customer Name: " + customer);
        System.out.println("============================================================");
        System.out.println("""
                ITEM       QTY      PRICE     TOTAL(NGN)
            ------------------------------------------------------------
            """);
        for (int i = 0; i <userItems.size() ; i++) {
            System.out.println(userItems.get(i) + "         " + piecesQTY.get(i) + "        " + priceOfItems.get(i) + "       " + piecesQTY.get(i) * priceOfItems.get(i));
            subTotal += (piecesQTY.get(i) * priceOfItems.get(i));
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("Sub Total: " + subTotal);
        System.out.println("Discount: " + ((discount * 100) / subTotal));
        System.out.println("Vat @ 17.50%: " );
        System.out.println("=================================================================");
        System.out.println("Bill Total: ");
        System.out.println("Amount paid: ");
        System.out.println("Balance: ");
        System.out.println("==================================================================");
        System.out.println("Thank you for you PATRONAGE");
        System.out.println("==================================================================");
    }
}
