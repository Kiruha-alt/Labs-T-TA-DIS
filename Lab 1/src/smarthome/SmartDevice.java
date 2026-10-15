package smarthome;

public interface SmartDevice {
    public static final int DEFAULT_VOLTAGE = 220;
    int calculatePower(int voltage, int current);
}