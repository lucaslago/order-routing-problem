public class RoutingLogic {

    public boolean isAWarehouse(String warehouseName){
        return DefaultWarehouses.getDefaultWarehouses().contains(warehouseName);
    }

    public boolean isAShippingMethod(String shippingMethodTitle){
        if(shippingMethodTitle.equals("DHL")){
            return true;
        } else {
           return false;
        }
    }
}
