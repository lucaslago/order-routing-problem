import java.util.ArrayList;
import java.util.List;

public class ShippingMethodFabric {

    public static List<String> getShippingMethods(){
        List<String> defaultShippingMethods = new ArrayList<>();

        defaultShippingMethods.add("DHL");
        defaultShippingMethods.add("FedEx");
        defaultShippingMethods.add("UPS");

        return defaultShippingMethods;

    }

}
