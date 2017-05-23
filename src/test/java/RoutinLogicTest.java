import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RoutinLogicTest {

    RoutingLogic routingLogic = new RoutingLogic();

    @Test
    public void ifIsAWarehouseReturnsTrue(){
        boolean result = routingLogic.isAWarehouse("Brazil");
        assertThat(result, equalTo(true));
    }

    @Test
    public void ifIsAShippingMethodReturnsTrue(){
        boolean result = routingLogic.isAShippingMethod("DHL");
        assertThat(result, equalTo(true));
    }

    @Test
    public void returnExpectedOutputForStandardOrderInput(){
        String userInput = "Brazil Keyboard 2\n" +
                           "France Mouse 2\n\n" +
                           "DHL, None\n" +
                           "Keyboard 2";
        String result = routingLogic.fulfillOrder(userInput);
        assertThat(result, equalTo("Brazil Keyboard 2"));
    }

    @Test
    public void returnExpectedOutputForShippingMethodTestingOrderInput(){
        String userInput = "Brazil Mouse 2\n" +
                           "South Africa Mouse 2\n\n" +
                           "UPS, None\n" +
                           "Mouse 1";
        String result = routingLogic.fulfillOrder(userInput);
        assertThat(result, equalTo("South Africa Mouse 1"));
    }

    @Test
    public void returnExpectedOutputForCapacityTestingOrderInput(){
        String userInput = "Canada Mouse 4\n" +
                           "Canada Keyboard 3\n" +
                           "France Keyboard 2\n\n" +
                           "FedEx, None\n" +
                           "Mouse 4\n" +
                           "Keyboard 3";
        String result = routingLogic.fulfillOrder(userInput);
        assertThat(result, equalTo("Canada Mouse 4\n" +
                                            "Canada Keyboard 1\n" +
                                            "France Keyboard 2"));
    }

    @Test
    public void returnExpectedOutputForLargestInventoryPriorityOrderInput(){
        String userInput = "China Mouse 4\n" +
                           "Brazil Mouse 3\n" +
                           "Brazil Keyboard 3\n" +
                           "France Mouse 2\n" +
                           "France Keyboard 2\n\n" +
                           "DHL, LargestInventory\n" +
                           "Mouse 1\n" +
                           "Keyboard 1";
        String result = routingLogic.fulfillOrder(userInput);
        assertThat(result, equalTo("Brazil Mouse 1\n" +
                                            "Brazil Keyboard 1"));
    }

    @Test
    public void returnExpectedOutputForShortestInventoryPriorityOrderInput(){
        String userInput = "China Mouse 4\n" +
                "Brazil Mouse 3\n" +
                "Brazil Keyboard 3\n" +
                "France Keyboard 2\n\n" +
                "DHL, ShortestInventory\n" +
                "Mouse 1\n" +
                "Keyboard 1";
        String result = routingLogic.fulfillOrder(userInput);
        assertThat(result, equalTo("China Mouse 1\n" +
                "France Keyboard 1"));
    }

    @Test
    public void returnExpectedOutputForLargestCapacityPriorityOrderInput(){
        String userInput = "China Mouse 4\n" +
                "Brazil Mouse 3\n" +
                "Brazil Keyboard 3\n" +
                "France Keyboard 2\n\n" +
                "DHL, LargestCapacity\n" +
                "Mouse 1\n" +
                "Keyboard 1";
        String result = routingLogic.fulfillOrder(userInput);
        assertThat(result, equalTo("China Mouse 1\n" +
                "Brazil Keyboard 1"));
    }

    @Test
    public void returnExpectedOutputForManyProductsOrderInput(){
        String userInput = "Canada Mouse 2\n" +
                "Brazil Mouse 2\n" +
                "Brazil Keyboard 3\n" +
                "France Keyboard 2\n" +
                "South Africa Monitor 4\n" +
                "South Africa Camera 1\n" +
                "South Africa Mouse 2\n\n" +
                "FedEx, None\n" +
                "Mouse 6\n" +
                "Keyboard 3\n" +
                "Monitor 3\n" +
                "Camera 1";
        String result = routingLogic.fulfillOrder(userInput);
        assertThat(result, equalTo("Canada Mouse 2\n" +
                "Brazil Mouse 2\n" +
                "Brazil Keyboard 3\n" +
                "South Africa Mouse 2\n" +
                "South Africa Monitor 3\n" +
                "South Africa Camera 1"));
    }

    @Test
    public void returnExpectedOutputForInvalidOrderInput(){
        String userInput = "China Mouse 4\n" +
                "Brazil Mouse 3\n\n" +
                "FedEx, None\n" +
                "Mouse 5";
        String result = routingLogic.fulfillOrder(userInput);
        assertThat(result, equalTo("Order cannot be fulfilled."));
    }

}