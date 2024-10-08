public class BuyTicket {
    /**
     * Calculates discount based on customer age and number of days until event
     * @param basePrice Base price of the ticket without any discount
     * @param daysUntilEvent Number of days remaining until the event day
     * @param customerAge Age of the customer
     * @param isMember Boolean indicating if the custsomer is a member
     * @return ticket price discounted based on number of days remaining and potential age and membership discount
     */

    public static double calculatePrice(int basePrice, int daysUntilEvent, int customerAge, boolean isMember) {
        double maxDiscount = basePrice - 100;

        double discountRate = daysUntilEvent / maxDiscount; // BUG 1: potential division by zero
        
        if (isMember) discountRate += .10;

        if (customerAge >= 65 || customerAge < 18) {
            discountRate += (customerAge - 65) / maxDiscount; //BUG 2: customerAge < 18 gives negative discount
        }

        return basePrice - (basePrice * discountRate);
    }
}
