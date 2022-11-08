package simulator.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import simulator.grocery.GroceryInterface;
import simulator.shopper.Shopper;
import config.Configuration;
import config.Groceries;

import java.util.List;
import java.util.LinkedList;

public class SimpleRegisterTest {

    @Test
    public void testCreateTransaction1() {
        AbstractRegister register = Configuration.getSimpleRegister();

        List<GroceryInterface> groceries = new LinkedList<GroceryInterface>();
        groceries.add(Groceries.getApple());
        Shopper joe = new Shopper(groceries);

        Transaction t = register.createTransaction(joe);

        assertNotNull(t, "The returned transaction should not be null.");
        assertEquals(groceries, t.getReceipt().getGroceries(), "The grocery lists should be equal.");
        assertEquals(joe, t.getShopper(), "The shopper should match.");
        assertEquals(4, t.getTimeSteps(), "The number of time steps should be 4.");
    }

    @Test
    public void testCreateTransaction2() {
        AbstractRegister register = Configuration.getSimpleRegister();

        List<GroceryInterface> groceries = new LinkedList<GroceryInterface>();
        groceries.add(Groceries.getApple());
        groceries.add(Groceries.getBeef());

        Shopper joe = new Shopper(groceries);

        Transaction t = register.createTransaction(joe);

        assertNotNull(t, "The returned transaction should not be null.");
        assertEquals(groceries, t.getReceipt().getGroceries(), "The grocery lists should be equal.");
        assertEquals(joe, t.getShopper(), "The shopper should match.");
        assertEquals(8, t.getTimeSteps(), "The number of time steps should be 8.");
    }
}
