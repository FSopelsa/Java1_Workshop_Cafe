package se.lexicon;

import java.util.Scanner;

/**
 * Simple IO wrapper for console input/output.
 * Keeps the application logic separate from UI concerns.
 */
public class IO {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Print a line to console.
     */
    public static void println(String text) {
        System.out.println(text);
    }

    /**
     * Print text without a newline.
     */
    public static void print(String text) {
        System.out.print(text);
    }

    /**
     * Read a string from user input (trimmed).
     */
    public static String readString(String prompt) {
        print(prompt);
        return scanner.nextLine().trim();
    }

    /**
     * Read an integer from user input.
     * Returns the parsed int or -1 if input is invalid.
     */
    public static int readInt(String prompt) {
        print(prompt);
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Read a double from user input.
     * Returns the parsed double or -1 if input is invalid.
     */
    public static double readDouble(String prompt) {
        print(prompt);
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Close the scanner (call when program exits).
     */
    public static void close() {
        scanner.close();
    }
}

