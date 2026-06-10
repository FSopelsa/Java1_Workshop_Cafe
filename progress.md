# ✅ Created Files
## 1. IO.java — Input/Output Wrapper
   - println() — print with newline
   - print() — print without newline
   - readString(prompt) — read text input
   - readInt(prompt) — read integer (returns -1 if invalid)
   - readDouble(prompt) — read decimal number
   - close() — clean up resources
   This keeps your business logic completely separate from console input/output.

-------------------------------------------------------
## 2. CafeApp.java — Application Structure
   ### Menu Data:
   - MENU_ITEMS[] — Espresso, Cappuccino, Latte, Croissant, Sandwich
   - MENU_PRICES[] — Corresponding prices in SEK
   - LOYALTY_DISCOUNT_RATE = 15%
   - LARGE_ORDER_DISCOUNT_RATE = 10%
   - LARGE_ORDER_THRESHOLD = 150 SEK
   - VAT_RATE = 12%

   ### Method Skeleton (organized by responsibility):
   #### Customer Interaction:
   - greetCustomer() — Get customer name
   - displayMenu() — Show all items with prices
   - getItemChoice() — Get item number
   - getQuantity() — Get order quantity
   - askMembership() — Get loyalty member status

   #### Calculations:
   calculateSubtotal(unitPrice, quantity)
   calculateDiscount(subtotal, isLoyaltyMember) — Handles both discount rules
   calculateVAT(subtotal, discount)
   calculateTotal(subtotal, discount, vat)

   #### Output:
   printReceipt(...) — Formatted receipt with all details
   printSeparator() — Helper for decorative lines


## 3. Main.java — Updated
   Now correctly delegates to CafeApp.main(args)

-------------------------------------------------------
# 📋 What This Structure Shows You
### When you look at CafeApp.java, you can see the entire project's shape:

- The menu data at the top
- Customer interaction methods (what you ask the user)
- Calculation methods (the business logic)
- Output methods (how you format results)

The main() method will be your coordinator — it orchestrates these pieces without doing the work itself.

-------------------------------------------------------

# 🚀 Next Steps 
### Implement the following methods one by one. Suggested order:

1. greetCustomer() — simplest, no calculations
2. displayMenu() — straightforward formatting
3. getItemChoice() and getQuantity() — basic input
4. askMembership() — parsing yes/no
5. calculateSubtotal(), calculateDiscount(), calculateVAT() — the math
6. calculateTotal() — combine the results
7. printReceipt() — format output
8. Wire it all together in main()