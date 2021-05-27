package Util;

import java.util.regex.Pattern;

/**
 * Util class for checking format
 *
 * @author Chuxing, Fang
 * @version 1.0
 */
public class FormatUtil {
    /**
     * Check whether a telephone number is valid
     *
     * @param number The telephone number
     * @return true if valid and false if invalid
     */
    public static boolean checkTelephone(String number) {
        // A telephone number must has 11 numbers and starts with 1
        Pattern pattern = Pattern.compile("^[1]\\d{10}$");
        return pattern.matcher(number).matches();
    }

    /**
     * Check whether a password is valid
     *
     * @param password The password
     * @return true if valid and false if invalid
     */
    public static boolean checkPassword(String password) {
        // A password must be 6-20 digits of letters, numbers, and underscores
        Pattern pattern = Pattern.compile("^[\\w_]{6,20}$");
        return pattern.matcher(password).matches();
    }
}
