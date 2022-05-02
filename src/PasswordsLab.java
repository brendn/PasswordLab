import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class PasswordsLab {

    // Where we will be storing the passwords
    private static final ArrayList<String> PASSWORDS = new ArrayList<>();

    // Minimum and maximum password length
    private static final int MIN_PASSWORD_LENGTH = 7;
    private static final int MAX_PASSWORD_LENGTH = 12;

    /**
     * Attempts to add the given password to the passwords list.
     *
     * If the password does not meet the criteria, it will return false. Otherwise,
     * it will return true and add it to the list.
     *
     * @param password password to add to the list
     * @return {@code true} if the password matches the criteria
     */
    public static boolean addPassword(String password) {
        if (PASSWORDS.contains(password))
            return false;

        if (canUseInsecurePassword(password) || hasCapitalVowels(password, 2) &&
                isCorrectLength(password) && hasNumber(password) && !password.contains(" ")) {
            PASSWORDS.add(password);
            return true;
        }

        return false;
    }

    /**
     * Checks if the given password is 'admin' or 'mod' - if so, it'll check
     * if it's already been used.  If it hasn't, then it will return true.
     *
     * @param password password to check
     * @return {@code true} if the insecure password can be used
     */
    private static boolean canUseInsecurePassword(String password) {
        return password.equals("admin") && !PASSWORDS.contains("admin") ||
                password.equals("mod") && !PASSWORDS.contains("mod");
    }

    /**
     * Checks if there are the given or more capital vowels (or the letter Y twice) in the given password.
     *
     * @param password password to check
     * @param amount minimum amount of occurrences to check for
     * @return {@code true} if there are two or more capital vowels (or the letter Y twice) in the password
     */
    public static boolean hasCapitalVowels(String password, int amount) {
        Predicate<Character> check = c -> "AEIOUY".contains(String.valueOf(c));
        return password.chars().mapToObj(c -> (char)c).filter(check).count() >= amount;
    }

    /**
     * Checks if the password is within the password length requirements.
     *
     * @param password password to check
     * @return {@code true} if the password meets the requirements.
     */
    private static boolean isCorrectLength(String password) {
        return password.length() >= MIN_PASSWORD_LENGTH && password.length() <= MAX_PASSWORD_LENGTH;
    }

    /**
     * Checks if the given password contains a number but not the number 6
     *
     * @param password password to check
     * @return {@code true} if the password contains a number that isn't 6
     */
    private static boolean hasNumber(String password) {
        return password.matches(".*[0-9].*") && !password.contains("6");
    }
}
