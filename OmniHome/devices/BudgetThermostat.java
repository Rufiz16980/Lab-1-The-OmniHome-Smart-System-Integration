package az.edu.ada.modules.module04.OmniHome.devices;

import az.edu.ada.modules.module04.OmniHome.interfaces.SmartThermostat;
import az.edu.ada.modules.module04.OmniHome.interfaces.SmartDevice;

public class BudgetThermostat extends SmartDevice implements SmartThermostat {
    private double currentTemp = 20.0;

    public BudgetThermostat(String id) {
        super(id, "Basic Thermostat V1");
    }

    @Override
    public void turnOn() {
        this.isOn = true;
        System.out.println(getName() + " is ON.");
    }

    @Override
    public void turnOff() {
        this.isOn = false;
        System.out.println(getName() + " is OFF.");
    }

    @Override
    public void setTemperature(double celsius) {
        this.currentTemp = celsius;
        System.out.println(getName() + " set to " + (int)celsius + "°C (Rounded).");
    }

    @Override
    public double getTemperature() { return currentTemp; }
}