package az.edu.ada.modules.module04.OmniHome.test;

import az.edu.ada.modules.module04.OmniHome.automation.AutomationRoutine;
import az.edu.ada.modules.module04.OmniHome.config.DeviceConfiguration;
import az.edu.ada.modules.module04.OmniHome.devices.LuxuryLight;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PatternsTest {

    @Test
    void testBuilderChain() {
        LuxuryLight light = new LuxuryLight("L1");

        // Test the fluent syntax
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
        // 1. Create original (takes ~500ms)
        long start = System.currentTimeMillis();
        DeviceConfiguration masterConfig = new DeviceConfiguration("ZigBee", "v2.0", "SECURE-123");
        long end = System.currentTimeMillis();
        System.out.println("Original creation time: " + (end - start) + "ms");

        // 2. Clone it (should be near instant)
        start = System.currentTimeMillis();
        DeviceConfiguration cloneConfig = masterConfig.clone();
        end = System.currentTimeMillis();
        System.out.println("Cloning time: " + (end - start) + "ms");

        // 3. Verify they are different objects
        assertNotSame(masterConfig, cloneConfig);

        // 4. Verify modifying clone doesn't hurt original
        cloneConfig.setProtocol("WiFi");
        assertEquals("ZigBee", masterConfig.getProtocol()); // Original stays ZigBee
        assertEquals("WiFi", cloneConfig.getProtocol());    // Clone is WiFi
    }
}