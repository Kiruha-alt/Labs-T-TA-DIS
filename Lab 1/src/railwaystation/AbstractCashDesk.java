package railwaystation;

public abstract class AbstractCashDesk implements TicketService {
    private String cashierName;

    public AbstractCashDesk(String cashierName) {
        this.cashierName = cashierName;
    }

    public String getCashierName() { return cashierName; }

    public int applyDiscount(int price, int discountPercent) {
        return price - (price * discountPercent / 100);
    }

    public abstract String processRefund();
}