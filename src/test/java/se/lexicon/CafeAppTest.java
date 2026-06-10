package se.lexicon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CafeAppTest {

    @Test
    void subtotalCalculation() {
        double sub = CafeApp.calculateSubtotal(40.0, 2);
        assertEquals(80.0, sub, 0.0001);
    }

    @Test
    void loyaltyDiscountApplied() {
        double discount = CafeApp.calculateDiscount(200.0, true);
        assertEquals(30.0, discount, 0.0001); // 15% of 200
    }

    @Test
    void largeOrderDiscountApplied() {
        double discount = CafeApp.calculateDiscount(200.0, false);
        assertEquals(20.0, discount, 0.0001); // 10% of 200
    }

    @Test
    void noDiscount() {
        double discount = CafeApp.calculateDiscount(100.0, false);
        assertEquals(0.0, discount, 0.0001);
    }

    @Test
    void vatCalculation() {
        double vat = CafeApp.calculateVAT(100.0, 10.0);
        assertEquals((100.0 - 10.0) * 0.12, vat, 0.0001);
    }

    @Test
    void totalCalculation() {
        double total = CafeApp.calculateTotal(100.0, 10.0, 10.8);
        assertEquals(100.8, total, 0.0001);
    }
}

