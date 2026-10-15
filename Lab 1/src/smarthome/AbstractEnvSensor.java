package smarthome;

public abstract class AbstractEnvSensor implements Sensor {
    private String sensorLocation;

    public AbstractEnvSensor(String sensorLocation) {
        this.sensorLocation = sensorLocation;
    }

    public String getSensorLocation() { return sensorLocation; }

    public int calibrate(int rawValue, int offset) { return rawValue + offset; }

    public abstract String getEnvReport();
}