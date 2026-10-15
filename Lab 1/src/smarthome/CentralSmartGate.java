package smarthome;

public class CentralSmartGate extends SecurityGuardHub implements SmartAutomation {
    private String gateCode;

    public CentralSmartGate(boolean armed, String gateCode) {
        super(armed);
        this.gateCode = gateCode;
    }

    @Override
    public String adjustClimate(String mode) {
        return "[KL14 CentralSmartGate] Климат переведен в режим: " + mode;
    }

    @Override
    public void runScenario(String scenarioName) {
        System.out.println("[KL14 CentralSmartGate] Сценарий '" + scenarioName + "' активирован (Код: " + gateCode + ")");
    }

    public void lockAllDoors() {
        System.out.println("[KL14 CentralSmartGate] Все двери дома заблокированы центральным шлюзом!");
    }
}