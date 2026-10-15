package railwaystation;

public class SuburbanCashDesk extends AbstractCashDesk {
    private String regionName;

    public SuburbanCashDesk(String cashierName, String regionName) {
        super(cashierName);
        this.regionName = regionName;
    }

    @Override
    public int calculateFare(int basePrice, int zones) {
        return applyDiscount(basePrice * zones, 10);
    }

    @Override
    public String processRefund() {
        return "[KL12 SuburbanCashDesk] Возврат пригородного билета (" + regionName + "), кассир: " + getCashierName();
    }

    public void issueSeasonTicket() {
        System.out.println("[KL12 SuburbanCashDesk] Выдан абонемент на электричку по маршруту: " + regionName);
    }
}