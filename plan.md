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
1. Create IO.java — wrapper around Scanner for input prompts and output
2. Start CafeApp.java with:
   - Menu data (item names and prices)
   - main() method as a coordinator
   - Helper methods for each responsibility
3. Build incrementally — get one part working before adding the next

Hint from the requirements: "Think about the receipt from the bottom up: what values must exist before the final total can be printed?"