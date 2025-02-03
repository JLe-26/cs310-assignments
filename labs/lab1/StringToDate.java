import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.NameAlreadyBoundException;

public class StringToDate {

    public static Date parseDate(String dateStr) throws IllegalArgumentException {
        if(dateStr == null) {
            throw new NullPointerException("Input date string cannot be null");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false); // rejects parsing for invalid dates

        try {
            Date date = sdf.parse(dateStr);
            return date;
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Expected format: yyyy-MM-dd");
        }
    }
}
