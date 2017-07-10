package util;

import factory.ShippingMethodFactory;
import factory.WarehouseFactory;
import model.Warehouse;

import java.util.List;

public class InputLineTypeUtil {

    public static boolean isAWarehouse(String warehouseName){
        return WarehouseFactory.defaultWarehouseWithName(warehouseName) != null;
    }

    public static boolean isAShippingMethod(String shippingMethodTitle){
        return ShippingMethodFactory.getShippingMethods().contains(shippingMethodTitle);
    }

    public static boolean isWarehouseInArray(String warehouseName, List<Warehouse> array){
        return array.stream().anyMatch((warehouse -> warehouse.getName().equals(warehouseName)));
    }

    public static boolean isInputLineEmpty(String inputLine[]){
        return inputLine.length == 1;
    }

}
