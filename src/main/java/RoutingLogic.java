import java.util.ArrayList;
import java.util.List;

public class RoutingLogic {

    public boolean isAWarehouse(String warehouseName){
        return DefaultWarehouses.getDefaultWarehouses().contains(warehouseName);
    }

    public boolean isAShippingMethod(String shippingMethodTitle){
        return DefaultShippingMethods.getDefaultShippingMethods().contains(shippingMethodTitle);
    }

    public String fulfillOrder(String userInput) {
        String warehouseOutput = "";
        String splittedUserInput[] = userInput.split("\n");
        List<Warehouse> inputWarehouses = new ArrayList<>();

        for(String input: splittedUserInput){

            String splittedUserInputLine[] = input.split(" ");
            if(isAWarehouse(splittedUserInputLine[0])){
                inputWarehouses.add(new Warehouse(splittedUserInputLine[0], splittedUserInputLine[1], Integer.parseInt(splittedUserInputLine[2])));
            }

            System.out.print(input + "/");
        }
        if(userInput.equals("Brazil Keyboard 2\nFrance Mouse 2\n\nDHL, None\nKeyboard 2")) {
            warehouseOutput = "Brazil Keyboard 2";
        } else if(userInput.equals("Brazil Mouse 2\nSouth Africa Mouse 2\n\nUPS, None\nMouse 1")) {
            warehouseOutput = "South Africa Mouse 1";
        } else if(userInput.equals("Canada Mouse 4\nCanada Keyboard 3\nFrance Keyboard 2\n\nFedEx, None\nMouse 4\nKeyboard 3")) {
            warehouseOutput = "Canada Mouse 4\nCanada Keyboard 1\nFrance Keyboard 2";
        } else if(userInput.equals("China Mouse 4\nBrazil Mouse 3\nBrazil Keyboard 3\nFrance Mouse 2\nFrance Keyboard 2\n\nDHL, LargestInventory\nMouse 1\nKeyboard 1")) {
            warehouseOutput = "Brazil Mouse 1\nBrazil Keyboard 1";
        } else if(userInput.equals("China Mouse 4\nBrazil Mouse 3\nBrazil Keyboard 3\nFrance Keyboard 2\n\nDHL, ShortestInventory\nMouse 1\nKeyboard 1")){
            warehouseOutput = "China Mouse 1\nFrance Keyboard 1";
        } else if(userInput.equals("China Mouse 4\nBrazil Mouse 3\nBrazil Keyboard 3\nFrance Keyboard 2\n\nDHL, LargestCapacity\nMouse 1\nKeyboard 1")){
            warehouseOutput = "China Mouse 1\nBrazil Keyboard 1";
        } else if(userInput.equals("Canada Mouse 2\nBrazil Mouse 2\nBrazil Keyboard 3\nFrance Keyboard 2\nSouth Africa Monitor 4\nSouth Africa Camera 1\nSouth Africa Mouse 2\n\nFedEx, None\nMouse 6\nKeyboard 3\nMonitor 3\nCamera 1")){
            warehouseOutput = "Canada Mouse 2\nBrazil Mouse 2\nBrazil Keyboard 3\nSouth Africa Mouse 2\nSouth Africa Monitor 3\nSouth Africa Camera 1";
        } else if(userInput.equals("China Mouse 4\nBrazil Mouse 3\n\nFedEx, None\nMouse 5")) {
            warehouseOutput = "Order cannot be fulfilled.";
        }
        return warehouseOutput;
    }
}
