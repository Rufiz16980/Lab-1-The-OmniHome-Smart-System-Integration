package az.edu.ada.modules.module04.OmniHome.test;

import az.edu.ada.modules.module04.OmniHome.automation.AutomationRoutine;
import az.edu.ada.modules.module04.OmniHome.config.DeviceConfiguration;
import az.edu.ada.modules.module04.OmniHome.devices.LuxuryLight;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// checks builder and prototype patterns
class PatternsTest {

    @Test
    void testBuilderChain() {
        LuxuryLight light = new LuxuryLight("L1");

        AutomationRoutine routine = new AutomationRoutine.RoutineBuilder("Good Morning")
                .atTime("07:00")
                .addDevice(light)
                .setRepeat(true)
                .build();

        assertEquals("Good Morning", routine.getName());
        assertEquals(1, routine.getDevices().size());
    }

    @Test
    void testPrototypeCloning() {
        // to demonstrate that creation is expensive
        long start = System.currentTimeMillis();
        DeviceConfiguration masterConfig = new DeviceConfiguration("not-WiFi", "v2.0", "SECURE-123");
        long end = System.currentTimeMillis();
        System.out.println("Original creation time: " + (end - start) + "ms");

        // to demonstrate that cloning is much faster
        start = System.currentTimeMillis();
        DeviceConfiguration cloneConfig = masterConfig.clone();
        end = System.currentTimeMillis();
        System.out.println("Cloning time: " + (end - start) + "ms");

        assertNotSame(masterConfig, cloneConfig);

        cloneConfig.setProtocol("WiFi");
        assertEquals("not-WiFi", masterConfig.getProtocol()); // Original stays not-WiFi
        assertEquals("WiFi", cloneConfig.getProtocol());    // Clone is WiFi
    }
}