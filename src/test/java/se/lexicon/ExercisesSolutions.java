package se.lexicon;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

/**
 * # Exercises
 * <p>
 * This class contains multiple small Java exercises as separate methods.
 * Each method demonstrates a different fundamental concept.
 */
public class ExercisesSolutions {

    /**
     * Simple record to represent a shopping item.
     * Records are perfect for immutable data containers with minimal boilerplate.
     */
    record Item(String name, int quantity, double price) {
        double totalCost() {
            return quantity * price;
        }
    }

    public static void main(String[] args) {
        System.out.println("Exercise 1:");
        profileCard();

        // Uncomment the ones you want to test:

        // System.out.println("\nExercise 2:");
        // checkLeapYear();

        // System.out.println("\nExercise 3:");
        // shoppingReceipt();

         System.out.println("\nExercise 4:");
         averageOfThreeNumbers();

        // System.out.println("\nExercise 5:");
        // greetTheUser();

        // System.out.println("\nExercise 6:");
        // arithmeticWithUserInput();

        // System.out.println("\nExercise 7:");
        // convertSeconds();

        // System.out.println("\nExercise 8:");
        // guessTheNumber();
    }

    /**
     * # Exercise 1
     * <p>
     * ### Question
     * Store your name, age, and city in variables. Then use those variables to print a formatted profile card.
     * Do not hardcode the values directly inside println — they must come from variables.
     */
    static void profileCard() {
        // Use a single Scanner for console input and validate the age input.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Read age as a line and parse it to avoid InputMismatchException when user types non-numeric input.
        Integer age = null;
        while (age == null) {
            System.out.print("Enter your age: ");
            String ageLine = scanner.nextLine();
            try {
                age = Integer.parseInt(ageLine.trim());
                if (age < 0) {
                    System.out.println("Please enter a non-negative age.");
                    age = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid integer for age.");
            }
        }

        System.out.print("Enter your city: ");
        String city = scanner.nextLine();

        System.out.println("====================");
        System.out.println("     My Profile");
        System.out.println("====================");
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
        System.out.println("City : " + city);
        System.out.println("====================");
    }

    /**
     * # Exercise 2
     * <p>
     * ### Question
     * Ask the user to enter a year. Print whether it is a leap year or not.
     */
    static void checkLeapYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");

        int year = 0;
        try {
            year = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid year. Please enter a valid integer.");
            return;
        }

        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is NOT a leap year.");
        }
    }

    /**
     * # Exercise 3
     * <p>
     * ### Question
     * A customer buys 3 items. Each item has a name, a quantity, and a price per unit.
     * Store all values in variables, calculate the total cost for each item and
     * the overall grand total, then print a formatted receipt.
     */
    static void shoppingReceipt() {
        Scanner scanner = new Scanner(System.in);
        Item[] items = new Item[3];

        // Read and parse 3 items
        for (int i = 0; i < 3; i++) {
            System.out.print("Please enter item " + (i + 1) + "'s name, quantity and price(with a point (.) before decimals if any) - separated by commas): ");
            String input = scanner.nextLine();
            items[i] = parseItem(input);
        }

        // Calculate grand total
        double grandTotal = 0;
        for (Item item : items) {
            grandTotal += item.totalCost();
        }

        // Print receipt
        System.out.println("==============================");
        System.out.println("           Receipt");
        System.out.println("==============================");
        for (Item item : items) {
            System.out.printf("%-13s %d x %.2f = %.2f SEK%n",
                item.name(), item.quantity(), item.price(), item.totalCost());
        }
        System.out.println("------------------------------");
        System.out.printf("Grand Total:           %.2f SEK%n", grandTotal);
        System.out.println("==============================");
    }
    /**
     * Parse a comma-separated line into an Item.
     * Expected format: "Apple, 2, 15.00"
     */
    static Item parseItem(String line) {
        String[] parts = line.split(",");
        String name = parts[0].trim();
        int quantity = Integer.parseInt(parts[1].trim());
        double price = Double.parseDouble(parts[2].trim());
        return new Item(name, quantity, price);
    }

    /**
     * # Exercise 4
     * <p>
     * ### Question
     * Ask the user to enter three integers. Calculate and print their average.
     * Make sure the result shows the decimal part.
     */
    static void averageOfThreeNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter three integers to calculate their average.");
        System.out.print("\nEnter first number:  ");
        int num1 = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter second number: ");
        int num2 = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter third number:  ");
        int num3 = Integer.parseInt(scanner.nextLine().trim());

        double average = (num1 + num2 + num3) / 3.0;
        System.out.println("Average: " + average);
    }

}