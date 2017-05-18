import java.util.ArrayList;
import java.util.List;

public class DefaultShippingMethods {

    public static List<String> getDefaultShippingMethods(){
        List<String> defaultShippingMethods = new ArrayList<>();

        defaultShippingMethods.add("DHL");
        defaultShippingMethods.add("Fedex");
        defaultShippingMethods.add("UPS");

        return defaultShippingMethods;

    }

}
