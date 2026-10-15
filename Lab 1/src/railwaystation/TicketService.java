package railwaystation;

public interface TicketService {
    public static final int BASE_COMMISSION = 5;
    int calculateFare(int basePrice, int zones);
}