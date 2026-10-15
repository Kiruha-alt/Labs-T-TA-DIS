package railwaystation;

public interface BoardingControl extends TicketService, ScheduleInfo {
    public static final String COUNTRY_PREFIX = "BY";
    boolean verifyPassenger(String ticketCode);
}