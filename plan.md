# Project Approach

## Phase 1: Foundation (IO Helper)
Create a simple IO.java class first. This handles console input/output so your main logic stays clean:

Why do this first?
- Separates UI concerns from business logic
- Main logic doesn't need to worry about Scanner, System.out, etc.
- Makes testing easier later
- Keeps code focused


## Phase 2: Create CafeApp.java
This is your main application file. Before writing code, think about structure:

Key responsibilities to consider:
1. Menu definition — store café items (names, prices) as constants or a data structure
2. Customer greeting — ask for and store customer name
3. Order taking — get item number, quantity, membership status
4. Calculations — subtotal, discount logic, VAT
5. Receipt printing — formatted output

The golden rule from the requirements:
"main should only coordinate, not calculate"

This means:
- main() should be a high-level workflow (greet → show menu → take order → print receipt)
- Each responsibility should be its own method
- Example: calculateDiscount(), calculateVAT(), printReceipt(), etc.


Data flow to think about:
Customer Name → Item Choice → Quantity → Membership
↓
Parse inputs → Calculate subtotal → Apply discount → Calculate VAT → Print

-------------------------

## Immediate Next Steps

### ✅ Challenge 1 Complete
**Serve Multiple Customers** has been implemented!

The application now supports a cashier workflow that serves multiple customers in sequence, with end-of-day reporting.

### How to Test Challenge 1 Locally

**Build the project:**
```powershell
.\mvnw.cmd -DskipTests package
```

**Run the application:**
```powershell
java -cp target\classes se.lexicon.Main
```

**Test Workflow:**
1. Enter a customer name (e.g., "Mehrdad")
2. Select an item and quantity, choose membership status
3. Receipt is printed
4. Asked for next customer name
5. Enter another customer or type "done" to close
6. End-of-day report prints showing customers served and total revenue

**Example Test Session:**
```text
Next customer name (or 'done' to close): Mehrdad
Hi Mehrdad! Here is our menu:
[menu displays]
Enter item number (1-5): 3
How many? 2
Loyalty member? (yes/no): yes
[receipt prints]

Next customer name (or 'done' to close): Elnaz
Hi Elnaz! Here is our menu:
[menu displays]
Enter item number (1-5): 5
How many? 6
Loyalty member? (yes/no): no
[receipt prints]

Next customer name (or 'done' to close): done

==============================
      END OF DAY REPORT
==============================
Customers served : 2
Total revenue    : 409.64 SEK
==============================
```

### Run Unit Tests
```powershell
.\mvnw.cmd test
```
(All 6 tests should still pass — core calculation logic unchanged)

### Commit Your Progress
```bash
git add .
git commit -m "Complete Challenge 1: Serve Multiple Customers with end-of-day report"
git push
```

### Ready for the Next Challenge?

Once Challenge 1 is verified and committed, you can tackle:
- **Challenge 2** – Input Validation & Error Handling (advanced error messages for invalid inputs)
- **Challenge 3** – Create an Order Class (move to object-oriented design)
- **Challenge 4** – Multiple Items per Order (ArrayList of line items per customer)
- **Challenge 5** – GUI (Java Swing or JavaFX)
