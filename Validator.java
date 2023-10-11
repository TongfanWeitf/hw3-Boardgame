public class Validator {
    //validtor for all ints
    public static boolean isValidString(String str, int min, int max) {
        try {
            int number = Integer.parseInt(str);
            return number >= min && number <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    //validator for chars

    public static boolean isValidChar(String str, int min, int max) {
        if (str.length() != 1) {
            return false;
        }
        char c = str.charAt(0);
        try {
            int number = (int) c;
            return number >= min && number <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
