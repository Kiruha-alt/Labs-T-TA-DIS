package railwaystation;

public class InternationalCashDesk extends AbstractCashDesk {
    private boolean visaCheckRequired;

    public InternationalCashDesk(String cashierName, boolean visaCheckRequired) {
        super(cashierName);
        this.visaCheckRequired = visaCheckRequired;
    }

    @Override
    public int calculateFare(int basePrice, int zones) {
        return basePrice * zones + BASE_COMMISSION * 10;
    }

    @Override
    public String processRefund() {
        return "[KL13 InternationalCashDesk] Возврат международного билета (Виза: " + visaCheckRequired + ")";
    }

    public void checkPassportData() {
        System.out.println("[KL13 InternationalCashDesk] Проверка паспорта кассиром " + getCashierName());
    }
}