package smarthome;

public class SmartHvacSystem extends AbstractClimateUnit implements AirMonitor, SmartAutomation {
    private int filterStatus;

    public SmartHvacSystem(int targetTemp, int filterStatus) {
        super(targetTemp);
        this.filterStatus = filterStatus;
    }

    @Override
    public int calculatePower(int voltage, int current) { return voltage * current * 2; }

    @Override
    public int readSensorData(int minVal, int maxVal) { return (minVal + maxVal) / 2; }

    @Override
    public String adjustClimate(String mode) {
        return "[KL15 SmartHvacSystem] Режим: " + mode + " (Целевая температура: " + getTargetTemp() + "°C)";
    }

    @Override
    public void triggerAlarm(String zone) {
        System.out.println("[KL15 SmartHvacSystem] Аварийное отключение вентиляции в зоне: " + zone);
    }

    @Override
    public int optimizeConsumption(int baseLoad, int limit) {
        return baseLoad > limit ? limit : baseLoad - 10;
    }

    @Override
    public int checkAirQuality(int co2Level) {
        System.out.println("[KL15 SmartHvacSystem] CO2: " + co2Level + " ppm (Норма до " + MAX_CO2_LEVEL + ", фильтр: " + filterStatus + "%)");
        return co2Level;
    }

    @Override
    public void runScenario(String scenarioName) {
        System.out.println("[KL15 SmartHvacSystem] Выполнение климатического сценария: " + scenarioName);
    }

    @Override
    public void startVentilation() {
        System.out.println("[KL15 SmartHvacSystem] Вентиляция запущена. Разница температур: " + calcTempDiff(20) + "°C");
    }

    public void purifyAir() {
        System.out.println("[KL15 SmartHvacSystem] Очистка и ионизация воздуха включены.");
    }
}