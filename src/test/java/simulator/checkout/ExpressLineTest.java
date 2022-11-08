package simulator.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import config.Configuration;
import config.Groceries;
import simulator.grocery.GroceryInterface;
import simulator.shopper.Shopper;

import java.util.LinkedList;

public class ExpressLineTest {

    private Shopper alice;
    private Shopper bob;
    private Shopper eve;

    @BeforeEach
    public void setUp() throws Exception {
        LinkedList<GroceryInterface> shortList = new LinkedList<GroceryInterface>();
        shortList.add(Groceries.getApple());
        shortList.add(Groceries.getBeef());

        alice = new Shopper(shortList);

        LinkedList<GroceryInterface> whereIsTheBeef = new LinkedList<GroceryInterface>();
        for(int i = 0; i < 15; i++)
            whereIsTheBeef.add(Groceries.getBeef());

        bob = new Shopper(whereIsTheBeef);

        LinkedList<GroceryInterface> tooMuchBeef = new LinkedList<GroceryInterface>();
        for(int i = 0; i < 100; i++)
            tooMuchBeef.add(Groceries.getBeef());

        eve = new Shopper(tooMuchBeef);
    }

    @Test
    public void test() {
        CheckoutLineInterface col = Configuration.getExpressLine();
        assertTrue(col.canEnterLine(alice));
        col.enqueue(alice);
        assertTrue(col.canEnterLine(bob));
        col.enqueue(bob);
        assertFalse(col.canEnterLine(eve));

        assertEquals(alice, col.dequeue());
        assertEquals(bob, col.dequeue());
    }

    @Test
    public void testLongList(){
        CheckoutLineInterface col = Configuration.getExpressLine();
        assertThrows(IllegalArgumentException.class,
                () -> col.enqueue(eve));
    }

    @Test
    public void testNPE1(){
        assertThrows(NullPointerException.class,
                () -> Configuration.getExpressLine().enqueue(null));
    }

    @Test
    public void testNPE2(){
        assertThrows(NullPointerException.class,
                () -> Configuration.getExpressLine().canEnterLine(null));
    }
}
