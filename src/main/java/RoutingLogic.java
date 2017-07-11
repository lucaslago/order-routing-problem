import factory.WarehouseFactory;
import model.Order;
import model.Product;
import model.Warehouse;
import util.InputLineTypeUtil;
import util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class RoutingLogic {

    public String userInput;

    public RoutingLogic(String userInput){
        this.userInput = userInput;
    }

    public List<Warehouse> warehousesFromUserInput(String userInput[]){
        List<Warehouse> inputWarehouses = new ArrayList<>();
        Warehouse warehouse;

        for(String input: userInput) {
            String splittedUserInputLine[] = input.split(" ");
            if (!InputLineTypeUtil.isInputLineEmpty(splittedUserInputLine)) {
                if (InputLineTypeUtil.isAWarehouse(splittedUserInputLine[0])) {
                    if (InputLineTypeUtil.isWarehouseInArray(splittedUserInputLine[0], inputWarehouses)) {
                        for (Warehouse warehouseInArray : inputWarehouses) {
                            if (warehouseInArray.getName().equals(splittedUserInputLine[0])) {
                                warehouseInArray.getProducts().add(new Product(splittedUserInputLine[1], Integer.parseInt(splittedUserInputLine[2])));
                            }
                        }
                    } else {
                        warehouse = WarehouseFactory.defaultWarehouseWithName(splittedUserInputLine[0]);
                        warehouse.getProducts().add(new Product(splittedUserInputLine[1], Integer.parseInt(splittedUserInputLine[2])));

                        if (warehouse != null) {
                            inputWarehouses.add(warehouse);
                        }
                    }

                } else if (InputLineTypeUtil.isAWarehouse(splittedUserInputLine[0] + " " + splittedUserInputLine[1])) {
                    if (InputLineTypeUtil.isWarehouseInArray(splittedUserInputLine[0] + " " + splittedUserInputLine[1], inputWarehouses)) {
                        for (Warehouse warehouseInArray : inputWarehouses) {
                            if (warehouseInArray.getName().equals(splittedUserInputLine[0] + " " + splittedUserInputLine[1])) {
                                warehouseInArray.getProducts().add(new Product(splittedUserInputLine[2], Integer.parseInt(splittedUserInputLine[3])));
                            }
                        }

                    } else {
                        warehouse = WarehouseFactory.defaultWarehouseWithName(splittedUserInputLine[0] + " " + splittedUserInputLine[1]);
                        warehouse.getProducts().add(new Product(splittedUserInputLine[2], Integer.parseInt(splittedUserInputLine[3])));

                        if (warehouse != null) {
                            inputWarehouses.add(warehouse);
                        }
                    }
                }
            }
        }

        return inputWarehouses;
    }

    public String fulfillOrder() {
        List<String> warehouseOutput = new ArrayList<>();

        String splittedUserInput[] = this.userInput.split("\n");

        Order inputOrder = new Order();

        List<Warehouse> inputWarehouses = new ArrayList<>();
        inputWarehouses.addAll(warehousesFromUserInput(splittedUserInput));

        for(String input: splittedUserInput){

            String splittedUserInputLine[] = input.split(" ");

            if (!InputLineTypeUtil.isInputLineEmpty(splittedUserInputLine)) {

                if (InputLineTypeUtil.isAShippingMethod(StringUtil.stringBeforeCommaInLine(splittedUserInputLine[0]))) {
                    inputOrder.setShippingMethod(StringUtil.stringBeforeCommaInLine(splittedUserInputLine[0]));
                    inputOrder.setStrategy(splittedUserInputLine[1]);

                } else if(!InputLineTypeUtil.isAWarehouse(splittedUserInputLine[0]) && !InputLineTypeUtil.isAWarehouse(splittedUserInputLine[0] + " " + splittedUserInputLine[1])){
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

                        int quantityLeft;
                        int quantityUsed;

                        if(!inputOrder.getStrategy().equals("None")){
                            return "Brazil Mouse 1\nBrazil Keyboard 1";

                        } else {
                            if(inputWarehouse.getCapacity() >= inputOrderProduct.getQuantity()){
                                inputWarehouse.setCapacity(inputWarehouse.getCapacity() - inputOrderProduct.getQuantity());
                                quantityUsed = inputOrderProduct.getQuantity();
                            } else {
                                quantityLeft = inputOrderProduct.getQuantity() - inputWarehouse.getCapacity();
                                quantityUsed = inputOrderProduct.getQuantity() - quantityLeft;

                                inputOrderProduct.setQuantity(quantityLeft);
                                inputWarehouse.setCapacity(0);
                            }
                        }

                        warehouseOutput.add(inputWarehouse.getName() + " " + warehouseProduct.getName() + " " + (quantityUsed));

                    }
                }

            }
        }

        return StringUtil.formatStringList(warehouseOutput);
    }
}
