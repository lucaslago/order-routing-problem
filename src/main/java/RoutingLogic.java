import java.util.ArrayList;
import java.util.List;

public class RoutingLogic {

    public boolean isAWarehouse(String warehouseName){
        return WarehouseFabric.defaultWarehouseWithName(warehouseName) != null;
    }

    public boolean isAShippingMethod(String shippingMethodTitle){
        return ShippingMethodFabric.getShippingMethods().contains(shippingMethodTitle);
    }

    public boolean isWarehouseInArray(String warehouseName, List<Warehouse> array){
        return array.stream().anyMatch((warehouse -> warehouse.name.equals(warehouseName)));
    }

    public String formatStringList(List<String> stringList){
        String formattedString = "";
        for(int cont = 0; cont < stringList.size(); cont++){
            formattedString += stringList.get(cont);
            if(cont < stringList.size()-1){
                formattedString += "\n";
            }
        }
        return formattedString;
    }

    public String fulfillOrder(String userInput) {
        List<String> warehouseOutput = new ArrayList<>();
        String splittedUserInput[] = userInput.split("\n");

        List<Warehouse> inputWarehouses = new ArrayList<>();
        Order inputOrder = new Order();

        for(String input: splittedUserInput) {

            String splittedUserInputLine[] = input.split(" ");
            Warehouse warehouse = null;

            boolean isBlankSpace = splittedUserInputLine.length == 1;

            if (!isBlankSpace) {
                if (isAWarehouse(splittedUserInputLine[0])) {
                    if(isWarehouseInArray(splittedUserInputLine[0], inputWarehouses)){
                        for(Warehouse warehouseInArray: inputWarehouses){
                            if (warehouseInArray.name.equals(splittedUserInputLine[0])){
                                warehouseInArray.products.add(new Product(splittedUserInputLine[1], Integer.parseInt(splittedUserInputLine[2])));
                            }
                        }
                    } else {
                        warehouse = WarehouseFabric.defaultWarehouseWithName(splittedUserInputLine[0]);
                        warehouse.products.add(new Product(splittedUserInputLine[1], Integer.parseInt(splittedUserInputLine[2])));

                        if(warehouse != null){
                            inputWarehouses.add(warehouse);
                        }
                    }

                } else if (isAWarehouse(splittedUserInputLine[0] + " " + splittedUserInputLine[1])) {

                    if(isWarehouseInArray(splittedUserInputLine[0] + " " + splittedUserInputLine[1], inputWarehouses)){
                        for(Warehouse warehouseInArray: inputWarehouses){
                            if (warehouseInArray.name.equals(splittedUserInputLine[0] + " " + splittedUserInputLine[1])){
                                warehouseInArray.products.add(new Product(splittedUserInputLine[2], Integer.parseInt(splittedUserInputLine[3])));
                            }
                        }

                    } else {
                        warehouse = WarehouseFabric.defaultWarehouseWithName(splittedUserInputLine[0] + " " + splittedUserInputLine[1]);
                        warehouse.products.add(new Product(splittedUserInputLine[2], Integer.parseInt(splittedUserInputLine[3])));

                        if(warehouse != null){
                            inputWarehouses.add(warehouse);
                        }
                    }

                } else if (isAShippingMethod(splittedUserInputLine[0].split(",")[0])) {
                    inputOrder.shippingMethod = splittedUserInputLine[0].split(",")[0];
                    inputOrder.strategy = splittedUserInputLine[1];

                } else {
                    inputOrder.products.add(new Product(splittedUserInputLine[0], Integer.parseInt(splittedUserInputLine[1])));

                }
            }
        }

        for(Product inputOrderProduct: inputOrder.products){

            for(Warehouse inputWarehouse: inputWarehouses){

                for(Product warehouseProduct: inputWarehouse.products){

                    if(warehouseProduct.name.equals(inputOrderProduct.name)
                            && warehouseProduct.quantity >= inputOrderProduct.quantity
                            && inputWarehouse.shippingMethods.contains(inputOrder.shippingMethod)){

                        int quantityLeft = 0;
                        int quantityUsed = 0;

                        if(inputWarehouse.capacity >= inputOrderProduct.quantity){
                            inputWarehouse.capacity -= inputOrderProduct.quantity;
                            quantityUsed = inputOrderProduct.quantity;

                        } else {
                            quantityLeft = inputOrderProduct.quantity - inputWarehouse.capacity;
                            quantityUsed = inputOrderProduct.quantity - quantityLeft;

                            inputOrderProduct.quantity = quantityLeft;
                            inputWarehouse.capacity = 0;
                        }

                        warehouseOutput.add(inputWarehouse.name + " " + warehouseProduct.name + " " + (quantityUsed));

                    }
                }

            }
        }

        return formatStringList(warehouseOutput);
    }
}
