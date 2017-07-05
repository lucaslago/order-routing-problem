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
        return array.stream().anyMatch((warehouse -> warehouse.getName().equals(warehouseName)));
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
                            if (warehouseInArray.getName().equals(splittedUserInputLine[0])){
                                warehouseInArray.getProducts().add(new Product(splittedUserInputLine[1], Integer.parseInt(splittedUserInputLine[2])));
                            }
                        }
                    } else {
                        warehouse = WarehouseFabric.defaultWarehouseWithName(splittedUserInputLine[0]);
                        warehouse.getProducts().add(new Product(splittedUserInputLine[1], Integer.parseInt(splittedUserInputLine[2])));

                        if(warehouse != null){
                            inputWarehouses.add(warehouse);
                        }
                    }

                } else if (isAWarehouse(splittedUserInputLine[0] + " " + splittedUserInputLine[1])) {

                    if(isWarehouseInArray(splittedUserInputLine[0] + " " + splittedUserInputLine[1], inputWarehouses)){
                        for(Warehouse warehouseInArray: inputWarehouses){
                            if (warehouseInArray.getName().equals(splittedUserInputLine[0] + " " + splittedUserInputLine[1])){
                                warehouseInArray.getProducts().add(new Product(splittedUserInputLine[2], Integer.parseInt(splittedUserInputLine[3])));
                            }
                        }

                    } else {
                        warehouse = WarehouseFabric.defaultWarehouseWithName(splittedUserInputLine[0] + " " + splittedUserInputLine[1]);
                        warehouse.getProducts().add(new Product(splittedUserInputLine[2], Integer.parseInt(splittedUserInputLine[3])));

                        if(warehouse != null){
                            inputWarehouses.add(warehouse);
                        }
                    }

                } else if (isAShippingMethod(splittedUserInputLine[0].split(",")[0])) {
                    inputOrder.setShippingMethod(splittedUserInputLine[0].split(",")[0]);
                    inputOrder.setStrategy(splittedUserInputLine[1]);

                } else {
                    inputOrder.getProducts().add(new Product(splittedUserInputLine[0], Integer.parseInt(splittedUserInputLine[1])));

                }
            }
        }

        for(Product inputOrderProduct: inputOrder.getProducts()){

            for(Warehouse inputWarehouse: inputWarehouses){

                for(Product warehouseProduct: inputWarehouse.getProducts()){

                    if(warehouseProduct.getName().equals(inputOrderProduct.getName())
                            && warehouseProduct.getQuantity() >= inputOrderProduct.getQuantity()
                            && inputWarehouse.getShippingMethods().contains(inputOrder.getShippingMethod())){

                        int quantityLeft = 0;
                        int quantityUsed = 0;

                        if(inputWarehouse.getCapacity() >= inputOrderProduct.getQuantity()){
                            inputWarehouse.setCapacity(inputWarehouse.getCapacity() - inputOrderProduct.getQuantity());
                            quantityUsed = inputOrderProduct.getQuantity();

                        } else {
                            quantityLeft = inputOrderProduct.getQuantity() - inputWarehouse.getCapacity();
                            quantityUsed = inputOrderProduct.getQuantity() - quantityLeft;

                            inputOrderProduct.setQuantity(quantityLeft);
                            inputWarehouse.setCapacity(0);
                        }

                        warehouseOutput.add(inputWarehouse.getName() + " " + warehouseProduct.getName() + " " + (quantityUsed));

                    }
                }

            }
        }

        return formatStringList(warehouseOutput);
    }
}
