package az.edu.ada.modules.module04.OmniHome.factories;

import az.edu.ada.modules.module04.OmniHome.interfaces.SmartLight;
import az.edu.ada.modules.module04.OmniHome.interfaces.SmartThermostat;

// for now with this abstract factory set up
// u create either all luxury or all budget homes
public interface SmartHomeFactory {
    SmartLight createSmartLight();
    SmartThermostat createSmartThermostat();
}