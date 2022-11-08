package config;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import simulator.grocery.GroceryInterface;

public class ConfigurationTest {

    @Test
    public void testQueueSet() {
        assertNotNull(Configuration.getQueueImplementation(),
            "You have not set your queue in the configuration class.");
    }

    @Test
    public void testReceiptSet() {
        assertNotNull(Configuration.getReceiptImplementation(new LinkedList<GroceryInterface>(), 0.0),
            "You have not set your receipt implementation in the configuration class.");
    }

    @Test
    public void testNormalLine() {
        assertNotNull(Configuration.getNormalLine(),
            "You have not set your normal line implementation in the configuration class.");
    }

    @Test
    public void testExpressLine() {
        assertNotNull(Configuration.getExpressLine(),
            "You have not set your express line implementation in the configuration class.");
    }

    @Test
    public void testRegister() {
        assertNotNull(Configuration.getSimpleRegister(),
            "You have not set your register implementation in the configuration class.");
    }

    @Test
    public void testSimpleStore() {
        assertNotNull(Configuration.getSimpleStore(),
            "You have not set your simple store implementation in the configuration class.");
    }

    @Test
    public void testProfitableStore() {
        assertNotNull(Configuration.getProfitableStore(),
            "You have not set your profitable store implementation in the configuration class.");
    }


}
