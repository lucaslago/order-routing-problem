import model.Warehouse;
import org.junit.Test;
import util.InputLineTypeUtil;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RoutinLogicTest {

    RoutingLogic routingLogic;

    @Test
    public void ifIsAWarehouseReturnsTrue(){
        boolean result = InputLineTypeUtil.isAWarehouse("Brazil");
        assertThat(result, equalTo(true));
    }

    @Test
    public void ifIsAShippingMethodReturnsTrue(){
        boolean result = InputLineTypeUtil.isAShippingMethod("DHL");
        assertThat(result, equalTo(true));
    }

    @Test
    public void ifIsWarehouseInArrayReturnsTrue(){
        List<Warehouse> warehouses = new ArrayList<>();
        warehouses.add(new Warehouse("Brazil", null, 0));
        boolean result = InputLineTypeUtil.isWarehouseInArray("Brazil", warehouses);
        assertThat(result, equalTo(true));
    }

    @Test
    public void returnExpectedOutputForStandardOrderInput(){
        String userInput = "Brazil Keyboard 2\n" +
                           "France Mouse 2\n\n" +
                           "DHL, None\n" +
                           "Keyboard 2";
        routingLogic = new RoutingLogic(userInput);
        String result = routingLogic.fulfillOrder();
        assertThat(result, equalTo("Brazil Keyboard 2"));
    }

    @Test
    public void returnExpectedOutputForShippingMethodTestingOrderInput(){
        String userInput = "Brazil Mouse 2\n" +
                           "South Africa Mouse 2\n\n" +
                           "UPS, None\n" +
                           "Mouse 1";
        routingLogic = new RoutingLogic(userInput);
        String result = routingLogic.fulfillOrder();
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
        routingLogic = new RoutingLogic(userInput);
        String result = routingLogic.fulfillOrder();
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
        routingLogic = new RoutingLogic(userInput);
        String result = routingLogic.fulfillOrder();
        assertThat(result, equalTo("Brazil Mouse 1\n" +
                                            "Brazil Keyboard 1"));
    }
}