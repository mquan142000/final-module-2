package src;

import java.util.regex.Pattern;

public class Utils {
    public class Validator {
        public boolean validatePrice(double price) {
            return Pattern.matches(price > 0);
        }

        public boolean validateQuantity(int quantity) {
            return Pattern.matches(quantity > 0);
        }
    }
}
