import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.text.NumberFormat;

public class TestStringToInteger {
    
    // @Test 
    // public void testWeekInAdvance() {
    //    int basePrice = 150;
    //    int daysUntilEvent = 7;
    //    int customerAge = 28;
    //    boolean isMember = true;

    //    double price = BuyTicket.calculatePrice(basePrice, daysUntilEvent, customerAge, isMember); 
    //    double expectedDiscount = basePrice * .24; //.14 discount for 7 days in advance + .10 discount for member

    //    assertEquals(basePrice - expectedDiscount, price, 0.0);
    // }

    // Test for valid positive integer
    @Test
    public void testParseIntPos() {
        assertEquals(123, StringToInteger.parseInt("123"));
    }

    // Test for valid negative integer
    @Test
    public void testParseIntNeg() {
        assertEquals(-123, StringToInteger.parseInt("-123"));
    }

    // Test for valid zero integer
    @Test
    public void testParseIntZero() {
        assertEquals(0, StringToInteger.parseInt("0"));
    }

    // Test for empty string
    @Test
    public void testParseIntEmptyString() {
        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> {
            StringToInteger.parseInt("");
        });
        assertEquals("Input string is null or empty", exception.getMessage());
    }

    // Test for null input 
    @Test
    public void testParseIntNull() {
        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> {
            StringToInteger.parseInt(null);
        });
        assertEquals("Input string is null or empty", exception.getMessage());
    }

    // Test for invalid string (non-numeric characters)
    public void testParseIntInvalidChars() {
        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> {
            StringToInteger.parseInt("12b");
        });
        assertEquals("Invalid character found: b", exception.getMessage());
    }
}
