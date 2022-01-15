package helpers;

public class RegExHelper {
    public static int getNumFromString(String str) {
        return Integer.parseInt(str.replaceAll("[^0-9]",""));
    }
}
