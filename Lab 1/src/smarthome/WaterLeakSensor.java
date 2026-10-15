package smarthome;

public class WaterLeakSensor extends AbstractEnvSensor {
    private boolean valveClosed;

    public WaterLeakSensor(String sensorLocation, boolean valveClosed) {
        super(sensorLocation);
        this.valveClosed = valveClosed;
    }

    @Override
    public int calculatePower(int voltage, int current) { return voltage * current; }

    @Override
    public int readSensorData(int minVal, int maxVal) { return calibrate(minVal, 10); }

    @Override
    public String getEnvReport() {
        return "[KL13 WaterLeakSensor] Локация: " + getSensorLocation() + ", Клапан закрыт: " + valveClosed;
    }

    public void blockWaterSupply() {
        this.valveClosed = true;
        System.out.println("[KL13 WaterLeakSensor] Подача воды перекрыта в помещении: " + getSensorLocation());
    }
}