package console;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JOLLIBEE_RECEIPT {
    private Scanner sc = new Scanner(System.in);
    private LocalDateTime date = LocalDateTime.now();
    private DateTimeFormatter fdate = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
    private List<String> items = new ArrayList<>();
    private List<Integer> quantities = new ArrayList<>();
    private double totalAmount = 0;
    private String cashierName;
    private String mealType;
    
    private static final Map<String, String> MENU_ITEMS = new HashMap<>();
    private static final Map<String, Double> MENU_PRICES = new HashMap<>();
    
    static{
        MENU_ITEMS.put("A1", "1pc Chickenjoy with Rice");
        MENU_PRICES.put("A1", 82.0);
        MENU_ITEMS.put("A2", "2pc Chickenjoy with Rice");
        MENU_PRICES.put("A2", 163.0);
        MENU_ITEMS.put("A3", "6pc Chickenjoy Bucket Solo + 1pc");
        MENU_PRICES.put("A3", 435.0);
        MENU_ITEMS.put("B1", "Yum Burger");
        MENU_PRICES.put("B1", 40.0);
        MENU_ITEMS.put("B2", "Cheesy Yum Burger");
        MENU_PRICES.put("B2", 66.0);
        MENU_ITEMS.put("B3", "Champ Burger");
        MENU_PRICES.put("B3", 169.0);
        MENU_ITEMS.put("C1", "Jolly Spaghetti");
        MENU_PRICES.put("C1", 59.0);
        MENU_ITEMS.put("C2", "Jolly Spaghetti with Yumburger");
        MENU_PRICES.put("C2", 127.0);
        MENU_ITEMS.put("C3", "Jolly Spaghetti with Fries & Drink");
        MENU_PRICES.put("C3", 122.0);
        MENU_ITEMS.put("D1", "Jolly Crispy Fries");
        MENU_PRICES.put("D1", 48.0);
        MENU_ITEMS.put("D2", "Mashed Potatoes");
        MENU_PRICES.put("D2", 55.0);
        MENU_ITEMS.put("D3", "Mango Fudge Sundae");
        MENU_PRICES.put("D3", 63.0);
        MENU_ITEMS.put("E1", "Coke");
        MENU_PRICES.put("E1", 53.0);
        MENU_ITEMS.put("E2", "Sprite");
        MENU_PRICES.put("E2", 53.0);
        MENU_ITEMS.put("E3", "Pineapple Juice");
        MENU_PRICES.put("E3", 64.0);
        MENU_ITEMS.put("F1", "Peach Mango Pie");
        MENU_PRICES.put("F1", 48.0);
        MENU_ITEMS.put("F2", "Large Mango Pie");
        MENU_PRICES.put("F2", 63.0);
        MENU_ITEMS.put("F3", "Chocolate Sundae Twirl");
        MENU_PRICES.put("F3", 48.0);
    }
    
    public void addInfo(){
        System.out.println("Jollibee Receipt\n");
        
        System.out.print("Enter cashier name: ");
        cashierName = sc.nextLine();
        
//        Show menu and handle selection
        viewMenu();
        handleMenuSelection();
        
//        Choose meal type
        chooseMealType();
        
//        handlePayment
        handlePayment();
        
//        Print receipt
        printReceipt();
        
//        Close scanner
        sc.close();
        
    }
    
    private void viewMenu(){
        System.out.println("\nMenu:");
        System.out.println("+---+----------------------------------+-------+");
        System.out.println("| A | Chickenjoy                       | Price |");
        System.out.println("| B | Burgers                          | Price |");
        System.out.println("| C | Spaghetti                        | Price |");
        System.out.println("| D | Sides                            | Price |");
        System.out.println("| E | Beverages                        | Price |");
        System.out.println("| F | Desserts                         | Price |");
        System.out.println("+---+----------------------------------+-------+");
        
        for(Map.Entry<String, String> entry : MENU_ITEMS.entrySet()){
            System.out.printf("| %-3s | %-30s | %6.2f |\n", entry.getKey(), entry.getValue(), MENU_PRICES.get(entry.getKey()));
        }
        System.out.println("+---+----------------------------------+-------+");
    }
    
    private void handleMenuSelection(){
        String choice = null;
        do{
            System.out.print("Enter selection (e.g., A1): ");
            String menuSelect = sc.next();
            
            if(!MENU_ITEMS.containsKey(menuSelect)){
                System.out.println("Invalid selection, try again.");
                continue;
            }
            
            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            
            items.add(MENU_ITEMS.get(menuSelect));
            quantities.add(quantity);
            totalAmount += MENU_PRICES.get(menuSelect) * quantity;
            
            System.out.print("Add another item? (y/n): ");
            choice = sc.next();
        } while(choice.equalsIgnoreCase("y"));
    }
    
    private void chooseMealType(){
        System.out.println("Choose meal type:");
        System.out.println("1. Dine in");
        System.out.println("2. Take out");
        System.out.print("Enter choice: ");
        int typeChoice = sc.nextInt();
        
        switch(typeChoice){
            case 1:
                mealType = "DINE IN";
                break;
            case 2:
                mealType = "TAKE OUT";
                break;
            default:
                System.out.println("Invalid choice, defaulting to TAKE OUT");
                mealType = "TAKE OUT";
        }
    }
    
    private void handlePayment(){
        System.out.println("Total price: "+totalAmount);
        System.out.print("Enter cash amount: ");
        double cash = sc.nextDouble();
        
        if(cash < totalAmount){
            System.out.println("Insufficient cash. Transaction cancelled");
            System.exit(0);
        }
        double change = cash - totalAmount;
        System.out.println("Change: "+change);
    }
    
    private void printReceipt(){
        System.out.println("\nSales Invoice");
        System.out.println("Cashier: "+cashierName);
        System.out.println("=============================================");
        System.out.println(date.format(fdate));
        System.out.println("=============================================");
        System.out.println(mealType + "--------------------------------------\n");
        
        for(int x = 0; x < items.size(); x++){
            System.out.printf("%d x %s\n", quantities.get(x), items.get(x));
        }
        
        System.out.println("\n" + items.size() + " ITEMS --------------------------- TOTAL " + totalAmount);
    }
}
