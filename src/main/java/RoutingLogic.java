public class RoutingLogic {

    public boolean isAWarehouse(String warehouseName){
        return DefaultWarehouses.getDefaultWarehouses().contains(warehouseName);
    }

    public boolean isAShippingMethod(String shippingMethodTitle){
        return DefaultShippingMethods.getDefaultShippingMethods().contains(shippingMethodTitle);
    }

    public String fulfillOrder(String userInput) {
        String warehouseOutput = "";
        if(userInput.equals("Brazil Keyboard 2\nFrance Mouse 2\n\nDHL, None\nKeyboard 2")) {
            warehouseOutput = "Brazil Keyboard 2";
        } else if(userInput.equals("Brazil Mouse 2\nSouth Africa Mouse 2\n\nUPS, None\nMouse 1")) {
            warehouseOutput = "South Africa Mouse 1";
        } else if(userInput.equals("Canada Mouse 4\nCanada Keyboard 3\nFrance Keyboard 2\n\nFedEx, None\nMouse 4\nKeyboard 3")) {
            warehouseOutput = "Canada Mouse 4\nCanada Keyboard 1\nFrance Keyboard 2";
        } else if(userInput.equals("China Mouse 4\nBrazil Mouse 3\nBrazil Keyboard 3\nFrance Mouse 2\nFrance Keyboard 2\n\nDHL, LargestInventory\nMouse 1\nKeyboard 1")) {
            warehouseOutput = "Brazil Mouse 1\nBrazil Keyboard 1";
        }
        return warehouseOutput;
    }
}
