package smarthome;

public class MotionSensor implements Sensor {
    private int sensitivity;

    public MotionSensor(int sensitivity) {
        this.sensitivity = sensitivity;
    }

    public int getSensitivity() { return sensitivity; }
    public void setSensitivity(int sensitivity) { this.sensitivity = sensitivity; }

    @Override
    public int calculatePower(int voltage, int current) { return voltage * current; }

    @Override
    public int readSensorData(int minVal, int maxVal) { return (minVal + maxVal) / 2 + sensitivity; }

    public int detectMotion(int zoneId, int speed) {
        System.out.println("[KL6 MotionSensor] Движение в зоне " + zoneId + " со скоростью " + speed);
        return zoneId * 100 + speed;
    }
}