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
        String userInput = "Brazil Keyboard 2\nFrance Mouse 2\n\nDHL, None\nKeyboard 2";
        String result = routingLogic.fulfillOrder(userInput);
        assertThat(result, equalTo("Brazil Keyboard 2"));
    }

}