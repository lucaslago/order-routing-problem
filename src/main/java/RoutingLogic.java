public class RoutingLogic {



    public boolean isAWarehouse(String warehouseName){
        return DefaultWarehouses.getDefaultWarehouses().contains(warehouseName);
    }

    public boolean isAShippingMethod(String shippingMethodTitle){
        return DefaultShippingMethods.getDefaultShippingMethods().contains(shippingMethodTitle);
    }
}
