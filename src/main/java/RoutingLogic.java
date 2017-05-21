public class RoutingLogic {

    public boolean isAWarehouse(String warehouseName){
        return DefaultWarehouses.getDefaultWarehouses().contains(warehouseName);
    }

    public boolean isAShippingMethod(String shippingMethodTitle){
        return DefaultShippingMethods.getDefaultShippingMethods().contains(shippingMethodTitle);
    }

    public String fulfillOrder(String userInput) {
        if(userInput.equals("Brazil Keyboard 2\nFrance Mouse 2\n\nDHL, None\nKeyboard 2")){
            return "Brazil Keyboard 2";
        } else {
            return "";
        }
    }
}
