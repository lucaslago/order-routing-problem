package util;

import model.Warehouse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LineTypeTest {

    boolean result;

    @Test
    public void ifIsAWarehouseReturnsTrue(){
        result = LineType.isAWarehouse("Brazil");
        assertThat(result, equalTo(true));
    }

    @Test
    public void ifIsAShippingMethodReturnsTrue(){
        result = LineType.isAShippingMethod("DHL");
        assertThat(result, equalTo(true));
    }

    @Test
    public void ifIsWarehouseInArrayReturnsTrue(){
        List<Warehouse> warehouses = new ArrayList<>();
        warehouses.add(new Warehouse("Brazil", null, 0));

        result = LineType.isWarehouseInArray("Brazil", warehouses);
        assertThat(result, equalTo(true));
    }


}
