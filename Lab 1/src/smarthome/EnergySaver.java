package smarthome;

public interface EnergySaver extends SmartDevice {
    int optimizeConsumption(int baseLoad, int limit);
}