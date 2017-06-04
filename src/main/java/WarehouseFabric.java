import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarehouseFabric {

    public static Map<String, Warehouse> getWarehouses(){
        Map<String, Warehouse> defaultWarehouses = new HashMap<>();

        List<String> brazilShippingMethods = new ArrayList<>();
        brazilShippingMethods.add("DHL");
        brazilShippingMethods.add("FedEx");
        defaultWarehouses.put("Brazil", new Warehouse("Brazil", brazilShippingMethods, 15));

        List<String> franceShippingMethods = new ArrayList<>();
        franceShippingMethods.add("DHL");
        franceShippingMethods.add("FedEx");
        franceShippingMethods.add("UPS");
        defaultWarehouses.put("France", new Warehouse("France", franceShippingMethods, 10));

        List<String> southAfricaShippingMethods = new ArrayList<>();
        southAfricaShippingMethods.add("FedEx");
        southAfricaShippingMethods.add("UPS");
        defaultWarehouses.put("South Africa", new Warehouse("South Africa", southAfricaShippingMethods, 10));

        List<String> chinaShippingMethods = new ArrayList<>();
        chinaShippingMethods.add("DHL");
        defaultWarehouses.put("China", new Warehouse("China", chinaShippingMethods, 20));

        List<String> canadaShippingMethods = new ArrayList<>();
        canadaShippingMethods.add("FedEx");
        defaultWarehouses.put("Canada", new Warehouse("Canada", canadaShippingMethods, 5));

        return defaultWarehouses;
    }

    public static Warehouse defaultWarehouseWithName(String warehouseName){
        return WarehouseFabric.getWarehouses().get(warehouseName);
    }
}
