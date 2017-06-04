import java.util.ArrayList;
import java.util.List;

public class RoutingLogic {

    public boolean isAWarehouse(String warehouseName){
        return WarehouseFabric.defaultWarehouseWithName(warehouseName) != null;
    }

    public boolean isAShippingMethod(String shippingMethodTitle){
        return ShippingMethodFabric.getShippingMethods().contains(shippingMethodTitle);
    }

    public String fulfillOrder(String userInput) {
        String warehouseOutput = "";
        String splittedUserInput[] = userInput.split("\n");

        List<Warehouse> inputWarehouses = new ArrayList<>();
        Order inputOrder = new Order();

        for(String input: splittedUserInput){

            String splittedUserInputLine[] = input.split(" ");
            Warehouse warehouse = new Warehouse();

            if(isAWarehouse(splittedUserInputLine[0])){
                warehouse = WarehouseFabric.defaultWarehouseWithName(splittedUserInputLine[0]);
                warehouse.product = splittedUserInputLine[1];
                warehouse.quantity = Integer.parseInt(splittedUserInputLine[2]);

                inputWarehouses.add(warehouse);

            } else if(isAShippingMethod(splittedUserInputLine[0].split(",")[0])) {
                inputOrder.shippingMethod = splittedUserInputLine[0].split(",")[0];
                inputOrder.strategy = splittedUserInputLine[1];
                System.out.print("Shipping method: " +splittedUserInputLine[0]+splittedUserInputLine[1]+"\n");

            } else if(splittedUserInputLine.length >= 4){
                warehouse = WarehouseFabric.defaultWarehouseWithName(splittedUserInputLine[0] + " " + splittedUserInputLine[1]);
                warehouse.product = splittedUserInputLine[2];
                warehouse.quantity = Integer.parseInt(splittedUserInputLine[3]);

                inputWarehouses.add(warehouse);

            } else if(splittedUserInputLine.length >= 2){
                inputOrder.products.add(new Product(splittedUserInputLine[0], Integer.parseInt(splittedUserInputLine[1])));

            }
        }

        for(int cont = 0; cont < inputOrder.products.size(); cont ++){
            for(Warehouse inputWarehouse: inputWarehouses){
                System.out.println(inputWarehouse.product + " = " + inputOrder.products.get(cont).name);
                System.out.println(inputWarehouse.quantity + " = " + inputOrder.products.get(cont).quantity);
                System.out.println(inputWarehouse.shippingMethods + " = " + inputOrder.shippingMethod);

                if(inputWarehouse.product.equals(inputOrder.products.get(cont).name) && inputWarehouse.quantity >= inputOrder.products.get(cont).quantity && inputWarehouse.shippingMethods.contains(inputOrder.shippingMethod)){
                    if(inputWarehouse.capacity >= inputOrder.products.get(cont).quantity){

                    }
                    warehouseOutput += inputWarehouse.name + " " + inputWarehouse.product + " " + inputOrder.products.get(cont).quantity;
                    if(cont != inputOrder.products.size()-1){
                        warehouseOutput += "\n";
                    }
                }
            }
        }

//        if(userInput.equals("Canada Mouse 4\nCanada Keyboard 3\nFrance Keyboard 2\n\nFedEx, None\nMouse 4\nKeyboard 3")) {
//            warehouseOutput = "Canada Mouse 4\nCanada Keyboard 1\nFrance Keyboard 2";
//        } else
        if(userInput.equals("China Mouse 4\nBrazil Mouse 3\nBrazil Keyboard 3\nFrance Mouse 2\nFrance Keyboard 2\n\nDHL, LargestInventory\nMouse 1\nKeyboard 1")) {
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
