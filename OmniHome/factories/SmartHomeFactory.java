package az.edu.ada.modules.module04.OmniHome.factories;

import az.edu.ada.modules.module04.OmniHome.interfaces.SmartLight;
import az.edu.ada.modules.module04.OmniHome.interfaces.SmartThermostat;

public interface SmartHomeFactory {
    SmartLight createSmartLight();
    SmartThermostat createSmartThermostat();
}