package smarthome;

public interface SmartAutomation extends ClimateControl, SecurityModule, EnergySaver {
    void runScenario(String scenarioName);
}