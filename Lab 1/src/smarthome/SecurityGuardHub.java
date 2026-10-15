package smarthome;

public class SecurityGuardHub implements SecurityModule, EnergySaver {
    private boolean armed;

    public SecurityGuardHub(boolean armed) {
        this.armed = armed;
    }

    public boolean isArmed() { return armed; }

    @Override
    public int calculatePower(int voltage, int current) { return voltage * current; }

    @Override
    public void triggerAlarm(String zone) {
        System.out.println("[KL11 SecurityGuardHub] ТРЕВОГА! Сектор: " + zone + " (Охрана активна: " + armed + ")");
    }

    @Override
    public int optimizeConsumption(int baseLoad, int limit) { return Math.min(baseLoad, limit); }

    public String checkPerimeter(String sector) {
        return "Периметр сектора [" + sector + "] защищен.";
    }
}