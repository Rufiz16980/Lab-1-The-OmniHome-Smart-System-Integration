package az.edu.ada.modules.module04.OmniHome.legacy;

// this thermostat does not implement
// the methods from the SmartThermostat interface
// different names, units, type
public class GlorbThermostat {
    private int fahrenheitTemp = 60; // Default start temp in F

    public int getZoneTemperatureFahrenheit() {
        return fahrenheitTemp;
    }

    public void setHeatIndex(int fahrenheit) {
        this.fahrenheitTemp = fahrenheit;
        System.out.println("      GLORB SYSTEM      ");
        System.out.println("Setting temp to: " + fahrenheit + "F");
        System.out.println("                     ");
    }
}