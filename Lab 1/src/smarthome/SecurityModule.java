package smarthome;

public interface SecurityModule extends SmartDevice {
    void triggerAlarm(String zone);
}