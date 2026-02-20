package az.edu.ada.modules.module04.OmniHome.test;

import az.edu.ada.modules.module04.OmniHome.factories.*;
import az.edu.ada.modules.module04.OmniHome.interfaces.*;
import az.edu.ada.modules.module04.OmniHome.devices.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {

    @Test
    void testLuxuryFactoryCreatesCorrectDevices() {
        SmartHomeFactory factory = new LuxuryHomeFactory();
        SmartLight light = factory.createSmartLight();
        SmartThermostat thermostat = factory.createSmartThermostat();

        // Assert that the factory actually returned the specific class we expected
        assertInstanceOf(LuxuryLight.class, light);
        assertInstanceOf(LuxuryThermostat.class, thermostat);
    }

    @Test
    void testBudgetFactoryRestrictions() {
        SmartHomeFactory factory = new BudgetHomeFactory();
        SmartLight light = factory.createSmartLight();

        // Budget lights should not support dimming (check console or behavior)
        assertInstanceOf(BudgetLight.class, light);
    }
}