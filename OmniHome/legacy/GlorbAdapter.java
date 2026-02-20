package az.edu.ada.modules.module04.OmniHome.legacy;

import az.edu.ada.modules.module04.OmniHome.interfaces.SmartThermostat;
import az.edu.ada.modules.module04.OmniHome.interfaces.SmartDevice;

// It extends SmartDevice to fit into your device list
// It implements SmartThermostat so factories can return it if needed
public class GlorbAdapter extends SmartDevice implements SmartThermostat {

    private final GlorbThermostat glorb;

    public GlorbAdapter(String id, GlorbThermostat glorb) {
        super(id, "Legacy Glorb Adapter");
        this.glorb = glorb;
    }

    @Override
    public void turnOn() {
        this.isOn = true;
        System.out.println(getName() + " is active.");
    }

    @Override
    public void turnOff() {
        this.isOn = false;
        System.out.println(getName() + " is dormant.");
    }

    @Override
    public void setTemperature(double celsius) {
        // CONVERSION LOGIC: (C * 9/5) + 32
        int fahrenheit = (int) ((celsius * 9.0 / 5.0) + 32);

        System.out.println("Adapter converting " + celsius + "°C -> " + fahrenheit + "°F");
        glorb.setFahrenheitValue(fahrenheit);
    }

    @Override
    public double getTemperature() {
        // Convert back to Celsius for the system to read
        int f = glorb.getZoneTemperatureFahrenheit();
        return (f - 32) * 5.0 / 9.0;
    }
}