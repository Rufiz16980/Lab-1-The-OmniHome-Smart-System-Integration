package az.edu.ada.modules.module04.OmniHome.devices;

import az.edu.ada.modules.module04.OmniHome.interfaces.SmartThermostat;
import az.edu.ada.modules.module04.OmniHome.interfaces.SmartDevice;

public class LuxuryThermostat extends SmartDevice implements SmartThermostat {
    private double currentTemp = 20.0;

    public LuxuryThermostat(String id) {
        super(id, "Nest Learning Thermostat");
    }

    @Override
    public void turnOn() {
        this.isOn = true;
        System.out.println(getName() + " is ON and analyzing humidity.");
    }

    @Override
    public void turnOff() {
        this.isOn = false;
        System.out.println(getName() + " is OFF (Eco Mode).");
    }

    @Override
    public void setTemperature(double celsius) {
        this.currentTemp = celsius;
        System.out.println(getName() + " set to " + celsius + "°C with precision heating.");
    }

    @Override
    public double getTemperature() { return currentTemp; }
}