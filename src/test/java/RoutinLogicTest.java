import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RoutinLogicTest {

//    Test Case #1 - Standard
//
//    Input
//
//    Brazil Keyboard 2
//    France Mouse 2
//
//    DHL, None
//    Keyboard 2
//    Output
//
//    Brazil Keyboard 2
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

}