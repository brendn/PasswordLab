import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordLabTest {

    @Test
    void testVowels() {
        assertTrue(PasswordsLab.hasCapitalVowels("AAwesome", 2));
        assertFalse(PasswordsLab.hasCapitalVowels("test", 2));
        assertFalse(PasswordsLab.hasCapitalVowels("teeth", 2));
        assertTrue(PasswordsLab.hasCapitalVowels("sOmeTING", 2));
    }

    @Test
    void testAddPassword() {
        //Adding a password that meets the criteria, which will return true
        assertTrue(PasswordsLab.addPassword("12345AEi"));
        //Adding the same password, which won't return true
        assertFalse(PasswordsLab.addPassword("12345AEi"));
        //Adding a password that doesn't meet the criteria, which will return false
        assertFalse(PasswordsLab.addPassword("test"));
        //Adding the admin password, which will return true
        assertTrue(PasswordsLab.addPassword("admin"));
        //But not the second time!
        assertFalse(PasswordsLab.addPassword("admin"));
        //Adding the mod password, which will return true
        assertTrue(PasswordsLab.addPassword("mod"));
        //But not the second time!
        assertFalse(PasswordsLab.addPassword("mod"));
        //Adding a password with a number and two capital vowels, which returns true
        assertTrue(PasswordsLab.addPassword("pAsswOrd2"));
        //Adding a password with the number 6, which returns false
        assertFalse(PasswordsLab.addPassword("password6"));
        //Adding a password too short, which returns false
        assertFalse(PasswordsLab.addPassword("pass"));
        //Adding a password too long, which returns false
        assertFalse(PasswordsLab.addPassword("passwordpasswordpassword"));
        //Adding a password with a space, which returns false
        assertFalse(PasswordsLab.addPassword("password 1"));
    }
}
