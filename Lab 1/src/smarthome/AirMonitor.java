package smarthome;

public interface AirMonitor extends Sensor, ClimateControl {
    public static final int MAX_CO2_LEVEL = 1000;
    int checkAirQuality(int co2Level);
}