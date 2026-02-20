package az.edu.ada.modules.module04.OmniHome.factories;

import az.edu.ada.modules.module04.OmniHome.interfaces.*;
import az.edu.ada.modules.module04.OmniHome.devices.LuxuryLight;
import az.edu.ada.modules.module04.OmniHome.devices.LuxuryThermostat;
import java.util.UUID;

public class LuxuryHomeFactory implements SmartHomeFactory {
    @Override
    public SmartLight createSmartLight() {
        // Generating a random ID for the device
        return new LuxuryLight(UUID.randomUUID().toString());
    }

    @Override
    public SmartThermostat createSmartThermostat() {
        return new LuxuryThermostat(UUID.randomUUID().toString());
    }
}