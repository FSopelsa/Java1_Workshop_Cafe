package se.lexicon;

/**
 * Lexicon Café Order System
 *
 * A console application for taking customer orders, applying discounts,
 * and printing receipts.
 *
 * Workflow:
 * 1. Greet customer by name
 * 2. Display café menu
 * 3. Take order (item number and quantity)
 * 4. Ask about loyalty membership
 * 5. Calculate bill (subtotal → discount → VAT → total)
 * 6. Print formatted receipt
 */
public class CafeApp {

    // ===== MENU DATA =====
    // Menu items with their prices (in SEK)
    private static final String[] MENU_ITEMS = {
        "Espresso",
        "Cappuccino",
        "Latte",
        "Croissant",
        "Sandwich"
    };

    private static final double[] MENU_PRICES = {
        25.00,
        35.00,
        40.00,
        30.00,
        55.00
    };

    // ===== CONSTANTS =====
    private static final double LOYALTY_DISCOUNT_RATE = 0.15;      // 15%
    private static final double LARGE_ORDER_DISCOUNT_RATE = 0.10; // 10%
    private static final double LARGE_ORDER_THRESHOLD = 150.00;   // SEK
    private static final double VAT_RATE = 0.12;                  // 12%


    public static void main(String[] args) {
        // Simple single-customer flow
        String customer = greetCustomer();
        IO.println("Hi " + customer + "! Here is our menu:\n");
        displayMenu();

        int itemIndex = getItemChoice() - 1; // convert to 0-based
        int quantity = getQuantity();
        boolean isMember = askMembership();

        String itemName = MENU_ITEMS[itemIndex];
        double unitPrice = MENU_PRICES[itemIndex];

        double subtotal = calculateSubtotal(unitPrice, quantity);
        double discount = calculateDiscount(subtotal, isMember);
        double vat = calculateVAT(subtotal, discount);
        double total = calculateTotal(subtotal, discount, vat);

        printReceipt(customer, itemName, quantity, unitPrice, subtotal, discount, vat, total);

        IO.close();
    }


    // ===== CUSTOMER INTERACTION =====

    /**
     * Greet the customer and get their name.
     */
    private static String greetCustomer() {
        String name = IO.readString("Welcome! What is your name? ");
        if (name == null || name.isEmpty()) {
            return "Customer";
        }
        return name;
    }

    /**
     * Display the café menu with all items and prices.
     */
    private static void displayMenu() {
        printSeparator();
        IO.println("       Lexicon Cafe");
        printSeparator();
        for (int i = 0; i < MENU_ITEMS.length; i++) {
            IO.println((i + 1) + ". " + String.format("%-15s %6.2f SEK", MENU_ITEMS[i], MENU_PRICES[i]));
        }
        printSeparator();
    }

    /**
     * Get the item number chosen by the customer.
     */
    private static int getItemChoice() {
        while (true) {
            int choice = IO.readInt("Enter item number (1-" + MENU_ITEMS.length + "): ");
            if (choice >= 1 && choice <= MENU_ITEMS.length) {
                return choice;
            }
            IO.println("Invalid choice. Please enter a number between 1 and " + MENU_ITEMS.length + ".");
        }
    }

    /**
     * Get the quantity desired by the customer.
     */
    private static int getQuantity() {
        while (true) {
            int qty = IO.readInt("How many? ");
            if (qty > 0) return qty;
            IO.println("Please enter a positive quantity.");
        }
    }

    /**
     * Ask if the customer is a loyalty member.
     */
    private static boolean askMembership() {
        while (true) {
            String answer = IO.readString("Loyalty member? (yes/no): ").toLowerCase();
            if (answer.equals("yes")) return true;
            if (answer.equals("no")) return false;
            IO.println("Please answer 'yes' or 'no'.");
        }
    }


    // ===== CALCULATIONS =====

    /**
     * Calculate the subtotal: unit price × quantity.
     */
    static double calculateSubtotal(double unitPrice, int quantity) {
        return unitPrice * quantity;
    }

    /**
     * Calculate the discount to apply.
     *
     * Rules:
     * - Loyalty member: 15% off subtotal (takes priority)
     * - No membership but subtotal > 150 SEK: 10% off subtotal
     * - Otherwise: no discount
     *
     * @return The discount amount (positive value)
     */
    static double calculateDiscount(double subtotal, boolean isLoyaltyMember) {
        if (isLoyaltyMember) {
            return subtotal * LOYALTY_DISCOUNT_RATE;
        }
        if (subtotal > LARGE_ORDER_THRESHOLD) {
            return subtotal * LARGE_ORDER_DISCOUNT_RATE;
        }
        return 0.0;
    }

    /**
     * Calculate the VAT on the price after discount.
     *
     * VAT = (subtotal - discount) × 12%
     */
    static double calculateVAT(double subtotal, double discount) {
        return (subtotal - discount) * VAT_RATE;
    }

    /**
     * Calculate the final total.
     *
     * Total = subtotal - discount + VAT
     */
    static double calculateTotal(double subtotal, double discount, double vat) {
        return subtotal - discount + vat;
    }


    // ===== OUTPUT =====

    /**
     * Print a formatted receipt with all order details.
     */
    private static void printReceipt(
        String customerName,
        String itemName,
        int quantity,
        double unitPrice,
        double subtotal,
        double discount,
        double vat,
        double total
    ) {
        printSeparator();
        IO.println("      LEXICON CAFE");
        printSeparator();
        IO.println("Customer  : " + customerName);
        IO.println("Item      : " + itemName + " x " + quantity);
        IO.println(String.format("Subtotal  : %.2f SEK", subtotal));
        if (discount > 0.0) {
            IO.println(String.format("Discount  : -%.2f SEK", discount));
        }
        IO.println(String.format("VAT       : %.2f SEK", vat));
        IO.println("------------------------------");
        IO.println(String.format("TOTAL     : %.2f SEK", total));
        printSeparator();
        IO.println("   Thank you, " + customerName + "!");
        IO.println("   See you next time.");
        printSeparator();
    }

    /**
     * Print a horizontal separator line.
     */
    private static void printSeparator() {
        IO.println("==============================");
    }
}

