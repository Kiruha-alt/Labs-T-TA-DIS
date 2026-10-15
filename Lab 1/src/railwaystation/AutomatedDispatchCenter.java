package railwaystation;

public class AutomatedDispatchCenter extends AbstractDispatchUnit implements BoardingControl, StationManagement {
    private int activeTerminals;

    public AutomatedDispatchCenter(String dispatcherName, int activeTerminals) {
        super(dispatcherName);
        this.activeTerminals = activeTerminals;
    }

    @Override
    public int calculateFare(int basePrice, int zones) { return basePrice * zones; }

    @Override
    public String getTrainStatus(String trainNumber) {
        return "[KL15 AutomatedDispatchCenter] Поезд " + trainNumber + " ожидает посадки (Диспетчер: " + getDispatcherName() + ")";
    }

    @Override
    public void announceAlert(String platform) {
        System.out.println("[KL15 AutomatedDispatchCenter] Автоинформатор: Поезд прибывает на " + platform);
    }

    @Override
    public int allocateTrack(int trainLength, int priority) { return priority * 2; }

    @Override
    public boolean verifyPassenger(String ticketCode) {
        System.out.println("[KL15 AutomatedDispatchCenter] Проверка билета " + ticketCode + " через терминалы (" + activeTerminals + " шт.)");
        return ticketCode != null && ticketCode.startsWith(COUNTRY_PREFIX);
    }

    @Override
    public void coordinateArrival(String trainId) {
        System.out.println("[KL15 AutomatedDispatchCenter] Автоматическая координация состава " + trainId);
    }

    @Override
    public void updateBoard() {
        System.out.println("[KL15 AutomatedDispatchCenter] Табло обновлено. Задержка: " + calculateDelay(10, 15) + " мин.");
    }

    public void syncPlatformGates() {
        System.out.println("[KL15 AutomatedDispatchCenter] Турникеты синхронизированы с расписанием.");
    }
}