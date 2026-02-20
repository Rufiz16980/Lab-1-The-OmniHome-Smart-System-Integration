package az.edu.ada.modules.module04.OmniHome.factories;

import az.edu.ada.modules.module04.OmniHome.interfaces.*;
import az.edu.ada.modules.module04.OmniHome.devices.BudgetLight;
import az.edu.ada.modules.module04.OmniHome.devices.BudgetThermostat;
import az.edu.ada.modules.module04.OmniHome.devices.BudgetLock;
import java.util.UUID;

public class BudgetHomeFactory implements SmartHomeFactory {
    @Override
    public SmartLight createSmartLight() {
        return new BudgetLight(UUID.randomUUID().toString());
    }

    @Override
    public SmartThermostat createSmartThermostat() {
        return new BudgetThermostat(UUID.randomUUID().toString());
    }

    @Override
    public SmartLock createSmartLock() {
        return new BudgetLock(UUID.randomUUID().toString());
    }
}