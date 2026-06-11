# ✅ Project Status — CHALLENGE 1 COMPLETE

## 1. IO.java — Input/Output Wrapper ✓
   - println() — print with newline
   - print() — print without newline
   - readString(prompt) — read text input
   - readInt(prompt) — read integer (returns -1 if invalid)
   - readDouble(prompt) — read decimal number
   - close() — clean up resources
   Separates UI concerns from business logic.

## 2. CafeApp.java — FULLY IMPLEMENTED ✓
   ### Menu Data:
   - MENU_ITEMS[] — Espresso, Cappuccino, Latte, Croissant, Sandwich
   - MENU_PRICES[] — Corresponding prices in SEK
   - LOYALTY_DISCOUNT_RATE = 15%
   - LARGE_ORDER_DISCOUNT_RATE = 10%
   - LARGE_ORDER_THRESHOLD = 150 SEK
   - VAT_RATE = 12%

   ### Customer Interaction (fully implemented):
   - getNextCustomerName() ✓ (with "done" command support)
   - displayMenu() ✓
   - getItemChoice() ✓ (with input validation)
   - getQuantity() ✓ (with validation)
   - askMembership() ✓ (with validation)

   ### Calculations (fully implemented):
   - calculateSubtotal(unitPrice, quantity) ✓
   - calculateDiscount(subtotal, isLoyaltyMember) ✓ — both discount rules handled
   - calculateVAT(subtotal, discount) ✓
   - calculateTotal(subtotal, discount, vat) ✓

   ### Output (fully implemented):
   - printReceipt(...) ✓ — formatted receipt
   - printEndOfDayReport(...) ✓ **[NEW - Challenge 1]**
   - printSeparator() ✓

## 3. Main.java — Entry Point ✓
   Delegates to CafeApp.main(args)

## 4. CafeAppTest.java — Unit Tests ✓
   - subtotalCalculation test ✓
   - loyaltyDiscountApplied test ✓
   - largeOrderDiscountApplied test ✓
   - noDiscount test ✓
   - vatCalculation test ✓
   - totalCalculation test ✓

## 5. Build Configuration ✓
   - pom.xml configured with JUnit 5 ✓
   - Maven Surefire plugin configured ✓

## 6. Maven Wrapper ✓
   - mvnw.cmd (Windows wrapper script) ✓
   - mvnw (Unix/Mac wrapper script) ✓
   - .mvn/wrapper/maven-wrapper.properties ✓
   - Auto-downloads Maven 3.9.16 if not installed

## 7. Documentation ✓
   - README.md with build/run commands ✓
   - plan.md with architecture overview ✓

-------------------------------------------------------

# 🎯 Challenge 1 Implementation Summary

**Challenge 1 – Serve Multiple Customers** is now complete!

### What Changed:
- **main() method**: Now wraps the order-processing flow in a `while(true)` loop
- **getNextCustomerName()**: New method replaces `greetCustomer()`
  - Prompts: "Next customer name (or 'done' to close): "
  - Allows cashier to type "done" (case-insensitive) to exit
- **Revenue Tracking**: 
  - `customersServed` counter — increments after each order
  - `totalRevenue` accumulator — sums the `total` (including VAT) from each order
- **printEndOfDayReport()**: New method displays:
  - Number of customers served
  - Total revenue in SEK (with 2 decimal places)
  - Formatted with separators matching receipt style

### How It Works:
1. Loop starts; asks for a customer name
2. If "done" is entered → exit loop and print end-of-day report
3. Otherwise → process the full order (menu, item choice, quantity, membership, receipt)
4. Increment customer count and add to total revenue
5. Loop back for next customer

### Expected Output (End of Day):
```text
==============================
      END OF DAY REPORT
==============================
Customers served : 3
Total revenue    : 437.28 SEK
==============================
```

-------------------------------------------------------
# 🚀 Recommended Next Steps (Optional Challenges)

Once Challenge 1 is tested and committed:
- **Challenge 2** – Input Validation & Error Handling (enhanced error messages)
- **Challenge 3** – Create an Order Class (refactor into OOP)
- **Challenge 4** – Multiple Items per Order (ArrayList of line items)
- **Challenge 5** – GUI (Java Swing or JavaFX)