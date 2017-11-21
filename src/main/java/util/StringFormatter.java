package util;

import java.util.List;

public class StringFormatter {

    public static String formatStringList(List<String> stringList){
        String formattedString = "";
        for(int cont = 0; cont < stringList.size(); cont++){
            formattedString += stringList.get(cont);
            if(cont < stringList.size()-1){
                formattedString += "\n";
            }
        }
        return formattedString;
    }

    public static String stringBeforeCommaInLine(String stringLine){
        return stringLine.split(",")[0];
    }

}
