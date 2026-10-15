package smarthome;

public class SmokeDetector extends AbstractEnvSensor {
    private int smokeThreshold;

    public SmokeDetector(String sensorLocation, int smokeThreshold) {
        super(sensorLocation);
        this.smokeThreshold = smokeThreshold;
    }

    @Override
    public int calculatePower(int voltage, int current) { return (voltage * current) / 2; }

    @Override
    public int readSensorData(int minVal, int maxVal) { return calibrate(maxVal, -smokeThreshold); }

    @Override
    public String getEnvReport() {
        return "[KL12 SmokeDetector] Локация: " + getSensorLocation() + ", Порог дыма: " + smokeThreshold;
    }

    public void testSiren() {
        System.out.println("[KL12 SmokeDetector] Тест сирены датчика дыма в помещении: " + getSensorLocation());
    }
}