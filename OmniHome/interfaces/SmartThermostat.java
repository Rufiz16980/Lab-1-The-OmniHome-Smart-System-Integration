package az.edu.ada.modules.module04.OmniHome.interfaces;

public interface SmartThermostat {
    // Basic contract for all thermostats
    void setTemperature(double celsius);
    double getTemperature();
}