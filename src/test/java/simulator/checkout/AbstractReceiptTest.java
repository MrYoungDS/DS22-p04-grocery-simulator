package simulator.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import simulator.grocery.GroceryInterface;
import config.Configuration;
import config.Groceries;

import java.util.List;
import java.util.LinkedList;

public class AbstractReceiptTest {

    private List<GroceryInterface> groceries;

    @BeforeEach
    public void setup() {
        groceries = new LinkedList<GroceryInterface>();
        groceries.add(Groceries.getApple());
        groceries.add(Groceries.getMilk());
        groceries.add(Groceries.getBeef());
    }

    @Test
    public void testSubTotal() {
        AbstractReceipt receipt = Configuration.getReceiptImplementation(
                groceries, 0.0);
        double expectedSubTotal = Groceries.getApple().getPrice()
                + Groceries.getMilk().getPrice()
                + Groceries.getBeef().getPrice();
        assertEquals(expectedSubTotal, receipt.getSubtotal(), 0.00001);
    }

    @Test
    public void testSaleValue1() {
        AbstractReceipt receipt = Configuration.getReceiptImplementation(
                groceries, 0.25);
        double expectedSubTotal = Groceries.getApple().getPrice()
                + Groceries.getMilk().getPrice()
                + Groceries.getBeef().getPrice();
        assertEquals(expectedSubTotal, receipt.getSubtotal(), 0.00001);

        double expectedSaleValue = expectedSubTotal - (expectedSubTotal * 0.25);
        assertEquals(expectedSaleValue, receipt.getSaleValue(), 0.00001);
    }

    @Test
    public void testSaleValue2() {
        AbstractReceipt receipt = Configuration.getReceiptImplementation(
                groceries, 0.15);
        double expectedSubTotal = Groceries.getApple().getPrice()
                + Groceries.getMilk().getPrice()
                + Groceries.getBeef().getPrice();
        assertEquals(expectedSubTotal, receipt.getSubtotal(), 0.00001);

        double expectedSaleValue = expectedSubTotal - (expectedSubTotal * 0.15);
        assertEquals(expectedSaleValue, receipt.getSaleValue(), 0.00001);
    }
}
