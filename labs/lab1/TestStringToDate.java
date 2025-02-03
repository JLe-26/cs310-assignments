import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestStringToDate {
    // Test for valid date (format and logically valid date)
    @Test
    public void testStringToDateValid() throws IllegalArgumentException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals(sdf.parse("2025-04-01"), StringToDate.parseDate("2025-04-01"));
    }

    // Test for valid leap year date (Feb 29 on leap year)
    @Test
    public void testStringToDateLeapYear() throws IllegalArgumentException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals(sdf.parse("2024-02-29"), StringToDate.parseDate("2024-02-29"));
    }

    // Test for invalid date (Feb 30)
    @Test
    public void testStringToDateInvalidDate(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                    StringToDate.parseDate("2025-02-30");
        });
        assertEquals("Invalid date format. Expected format: yyyy-MM-dd", exception.getMessage());
    }
    
    // Test for invalid format ("MM-dd-yyyy")
    @Test
    public void testStringToDateInvalidFormat(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                    StringToDate.parseDate("02-14-2025");
        });
        assertEquals("Invalid date format. Expected format: yyyy-MM-dd", exception.getMessage());
    }

    // Test for empty string
    @Test
    public void testStringToDateEmptyString(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                    StringToDate.parseDate("");
        });
        assertEquals("Invalid date format. Expected format: yyyy-MM-dd", exception.getMessage());
    }

    // Test for null input
    @Test
    public void testStringToDateNull(){
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
                    StringToDate.parseDate(null);
        });
        assertEquals("Input date string cannot be null", exception.getMessage());
    }

}

