import java.util.ArrayList;
import java.util.List;

public class DefaultWarehouses {

    public static List<Warehouse> getDefaultWarehouses(){
        List<Warehouse> defaultWarehouses = new ArrayList<>();

        List<String> brazilShippingMethods = new ArrayList<>();
        brazilShippingMethods.add("DHL");
        brazilShippingMethods.add("FedEx");
        defaultWarehouses.add(new Warehouse("Brazil", brazilShippingMethods));

        List<String> franceShippingMethods = new ArrayList<>();
        franceShippingMethods.add("DHL");
        franceShippingMethods.add("FedEx");
        franceShippingMethods.add("UPS");
        defaultWarehouses.add(new Warehouse("France", franceShippingMethods));

        List<String> southAfricaShippingMethods = new ArrayList<>();
        southAfricaShippingMethods.add("FedEx");
        southAfricaShippingMethods.add("UPS");
        defaultWarehouses.add(new Warehouse("South Africa", southAfricaShippingMethods));

        List<String> chinaShippingMethods = new ArrayList<>();
        chinaShippingMethods.add("DHL");
        defaultWarehouses.add(new Warehouse("China", chinaShippingMethods));

        List<String> canadaShippingMethods = new ArrayList<>();
        canadaShippingMethods.add("FedEx");
        defaultWarehouses.add(new Warehouse("Canada", canadaShippingMethods));

        return defaultWarehouses;
    }

    public static Warehouse defaultWarehouseWithName(String warehouseName){
        for(Warehouse warehouse: DefaultWarehouses.getDefaultWarehouses()){
            if(warehouse.name.equals(warehouseName)){
                return warehouse;
            }
        }
        return null;
    }
}
