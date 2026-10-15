package smarthome;

public interface Sensor extends SmartDevice {
    int readSensorData(int minVal, int maxVal);
}