package railwaystation;

public class TicketKiosk implements TicketService {
    private int kioskId;

    public TicketKiosk(int kioskId) {
        this.kioskId = kioskId;
    }

    public int getKioskId() { return kioskId; }

    @Override
    public int calculateFare(int basePrice, int zones) { return basePrice * zones; }

    public int printBoardingPass(int ticketId, int copies) {
        System.out.println("[KL6 TicketKiosk #" + kioskId + "] Печать билета №" + ticketId + " (копий: " + copies + ")");
        return ticketId;
    }
}