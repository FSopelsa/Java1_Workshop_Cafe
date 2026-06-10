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
        // TODO: Implement main workflow
        // 1. Greet customer
        // 2. Display menu
        // 3. Get order details
        // 4. Calculate bill
        // 5. Print receipt
        // 6. Close IO
    }


    // ===== CUSTOMER INTERACTION =====

    /**
     * Greet the customer and get their name.
     */
    private static String greetCustomer() {
        // TODO: Prompt "Welcome! What is your name?"
        // Return customer name
        return "";
    }

    /**
     * Display the café menu with all items and prices.
     */
    private static void displayMenu() {
        // TODO: Print menu in formatted style
        // Show item number, name, and price for each menu item
        // Match the format from the sample session
    }

    /**
     * Get the item number chosen by the customer.
     */
    private static int getItemChoice() {
        // TODO: Prompt "Enter item number (1-5): "
        // Return selected item number
        return -1;
    }

    /**
     * Get the quantity desired by the customer.
     */
    private static int getQuantity() {
        // TODO: Prompt "How many? "
        // Return quantity
        return -1;
    }

    /**
     * Ask if the customer is a loyalty member.
     */
    private static boolean askMembership() {
        // TODO: Prompt "Loyalty member? (yes/no): "
        // Return true if "yes", false if "no"
        return false;
    }


    // ===== CALCULATIONS =====

    /**
     * Calculate the subtotal: unit price × quantity.
     */
    private static double calculateSubtotal(double unitPrice, int quantity) {
        // TODO: Return unitPrice * quantity
        return 0.0;
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
    private static double calculateDiscount(double subtotal, boolean isLoyaltyMember) {
        // TODO: Apply discount rules and return discount amount
        return 0.0;
    }

    /**
     * Calculate the VAT on the price after discount.
     *
     * VAT = (subtotal - discount) × 12%
     */
    private static double calculateVAT(double subtotal, double discount) {
        // TODO: Return VAT = (subtotal - discount) * VAT_RATE
        return 0.0;
    }

    /**
     * Calculate the final total.
     *
     * Total = subtotal - discount + VAT
     */
    private static double calculateTotal(double subtotal, double discount, double vat) {
        // TODO: Return subtotal - discount + vat
        return 0.0;
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
        // TODO: Print receipt in the format shown in sample session
        // Include:
        // - Header with "LEXICON CAFE"
        // - Customer name
        // - Item and quantity
        // - Subtotal
        // - Discount (only if > 0)
        // - VAT
        // - TOTAL
        // - Thank you message
    }

    /**
     * Print a horizontal separator line.
     */
    private static void printSeparator() {
        // TODO: Print "=============================="
    }
}

