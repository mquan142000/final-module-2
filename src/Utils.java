package src;

import java.util.regex.Pattern;

public class Utils {

    public static class Validator {

        public boolean validatePrice(double price) {
            return price > 0;
        }

        public boolean validateQuantity(int quantity) {
            return quantity > 0;
        }
    }
}
