package az.edu.ada.modules.module04.OmniHome.test;

import az.edu.ada.modules.module04.OmniHome.automation.AutomationRoutine;
import az.edu.ada.modules.module04.OmniHome.config.DeviceConfiguration;
import az.edu.ada.modules.module04.OmniHome.devices.LuxuryLight;
import az.edu.ada.modules.module04.OmniHome.devices.BudgetLight;
import az.edu.ada.modules.module04.OmniHome.devices.LuxuryThermostat;
import az.edu.ada.modules.module04.OmniHome.devices.BudgetThermostat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// checks builder and prototype patterns
class PatternsTest {

    @Test
    void testBuilderChain() {
        LuxuryLight light = new LuxuryLight("L1");
        BudgetLight light2 = new BudgetLight("L2");
        LuxuryThermostat thermo = new LuxuryThermostat("T1");
        BudgetThermostat thermo2 = new BudgetThermostat("T2");

        AutomationRoutine routine = new AutomationRoutine.RoutineBuilder()
                .withName("Vacation Mode")
                .atTime("22:00")
                .addDevice(light)
                .addDevice(light2)
                .addDevice(thermo)
                .addDevice(thermo2)
                .toggleNotification()
                .build();

        assertEquals("Vacation Mode", routine.getName());
        assertEquals(4, routine.getDevices().size());
        assertEquals("22:00", routine.getTriggerTime());
        assertTrue(routine.isSendNotification());
    }

    @Test
    void testPrototypeCloning() {
        // to demonstrate that creation is expensive
        long start = System.currentTimeMillis();
        DeviceConfiguration masterConfig = new DeviceConfiguration("192.168.1.10", 8080, "v2.0");
        long end = System.currentTimeMillis();
        System.out.println("Original creation time: " + (end - start) + "ms");

        // to demonstrate that cloning is much faster
        start = System.currentTimeMillis();
        DeviceConfiguration cloneConfig = masterConfig.clone();
        end = System.currentTimeMillis();
        System.out.println("Cloning time: " + (end - start) + "ms");

        assertNotSame(masterConfig, cloneConfig);

        cloneConfig.setIpAddress("192.168.1.99");
        assertEquals("192.168.1.10", masterConfig.getIpAddress()); // Original stays the same
        assertEquals("192.168.1.99", cloneConfig.getIpAddress());    // Clone is different
    }
}