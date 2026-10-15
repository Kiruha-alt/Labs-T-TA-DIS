package smarthome;

public abstract class AbstractClimateUnit implements ClimateControl {
    private int targetTemp;

    public AbstractClimateUnit(int targetTemp) {
        this.targetTemp = targetTemp;
    }

    public int getTargetTemp() { return targetTemp; }

    public int calcTempDiff(int currentTemp) { return targetTemp - currentTemp; }

    public abstract void startVentilation();
}