package helpers;

public class RegExHelper {

    /**
     * метод удаляет из строки всё кроме цифр и парсит оставшиеся цифры в тип данных Integer
     * @param str
     * @return
     */
    public static int getNumFromString(String str) {
        return Integer.parseInt(str.replaceAll(ConfigProperties.get("SearchDataInArow"),""));
    }

    /**
     * На вход подаётся любая строка, и если там есть пробелы,
     * то на выходе мы получаем массив отдельных слов, к которым можно обращаться по индексу
     * @param expression
     * @return
     */
    public static String[] divisionToSeparateWord(String expression){
        return expression.split("\n");
    }
}
