## Starting Approach

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



## Immediate Next Steps

### ✅ Phase 1 & 2 Complete
The core Café Order System is fully implemented and ready to use.

### How to Test the Application Locally

**Option A: Using Maven (system-wide)**
```powershell
mvn -DskipTests package
java -cp target\classes se.lexicon.Main
```

**Option B: Using Maven Wrapper (no installation required)**
```powershell
.\mvnw.cmd -DskipTests package
java -cp target\classes se.lexicon.Main
```

**Run Unit Tests**
```powershell
.\mvnw.cmd test
# or
mvn test
```

### Things to Try

1. **Test the core flow** — Run the app and test with the sample inputs from Java1_Workshop_Cafe.md:
   - Loyalty member, 2 lattes
   - Non-member, 6 sandwiches
   - Single espresso, no membership

2. **Verify test output** — Run `mvn test` to confirm all unit tests pass (6 tests should pass).

3. **Commit your progress** — Once verified, commit the complete core implementation to git.

### Optional Challenges

Once the core app is working and tested, tackle the optional challenges:
- **Challenge 1** – Serve Multiple Customers (add outer loop for multiple orders)
- **Challenge 2** – Input Validation & Error Handling (enhanced error messages)
- **Challenge 3** – Create an Order Class (refactor into OOP)
- **Challenge 4** – Multiple Items per Order (ArrayList of line items)
- **Challenge 5** – GUI (Java Swing or JavaFX)
