import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestBuyTicket {

    @Test 
    public void testWeekInAdvance() {
        int basePrice = 150;
        int daysUntilEvent = 7;
        int customerAge = 28;
        boolean isMember = true;

        double price = BuyTicket.calculatePrice(basePrice, daysUntilEvent, customerAge, isMember); 
        double expectedDiscount = basePrice * .24; //.14 discount for 7 days in advance + .10 discount for member

        assertEquals(basePrice - expectedDiscount, price, 0.0);
    }

    @Test 
    public void testDayOf() {
        int basePrice = 150;
        int daysUntilEvent = 0;
        int customerAge = 31;
        boolean isMember = true;
        
        double price = BuyTicket.calculatePrice(basePrice, daysUntilEvent, customerAge, isMember); 
        double expectedDiscount = basePrice * .10; //.10 discount for membership

        assertEquals(basePrice - expectedDiscount, price, 0.0); 
    }

    @Test
    public void testSeniorCitizen() {
        int basePrice = 150;
        int daysUntilEvent = 0;
        int customerAge = 70;
        boolean isMember = true;

        double price = BuyTicket.calculatePrice(basePrice, daysUntilEvent, customerAge, isMember);
        double expectedDiscount = basePrice * .20; // .20 discount for membership and for senior citizen

        assertEquals(basePrice - expectedDiscount, price, 0.0);
    }

    @Test
    public void testUnderEighteen() {
        int basePrice = 150;
        int daysUntilEvent = 0;
        int customerAge = 17;
        boolean isMember = true;

        double price = BuyTicket.calculatePrice(basePrice, daysUntilEvent, customerAge, isMember); 
        double expectedDiscount = basePrice * .08; //.10 discount for membership, -0.02 discount for minor

        assertEquals(basePrice - expectedDiscount, price, 0.0); 

    }
}
