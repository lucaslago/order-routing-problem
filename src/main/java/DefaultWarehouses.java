import java.util.ArrayList;
import java.util.List;

public class DefaultWarehouses {

    public static List<String> getDefaultWarehouses(){
        List<String> defaultWarehouses = new ArrayList<>();

        defaultWarehouses.add("Brazil");
        defaultWarehouses.add("France");
        defaultWarehouses.add("South Africa");
        defaultWarehouses.add("China");
        defaultWarehouses.add("Canada");

        return defaultWarehouses;
    }
}
