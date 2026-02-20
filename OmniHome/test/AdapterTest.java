package az.edu.ada.modules.module04.OmniHome.test;

import az.edu.ada.modules.module04.OmniHome.legacy.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdapterTest {

    @Test
    void testCelsiusToFahrenheitConversion() {
        GlorbThermostat oldDevice = new GlorbThermostat();

        GlorbAdapter adapter = new GlorbAdapter("LEGACY-01", oldDevice);

        // Send a command in Celsius (20°C)
        adapter.setTemperature(20.0);

        // (20 * 1.8) + 32 = 68
        assertEquals(68, oldDevice.getZoneTemperatureFahrenheit(), "Adapter failed to convert 20C to 68F");
    }

    @Test
    void testFahrenheitToCelsiusConversion() {
        GlorbThermostat oldDevice = new GlorbThermostat();
        GlorbAdapter adapter = new GlorbAdapter("LEGACY-02", oldDevice);

        // Set Glorb to 212F
        oldDevice.setHeatIndex(212);

        // Adapter should read it as 100C
        assertEquals(100.0, adapter.getTemperature(), 0.1, "Adapter failed to convert 212F back to 100C");
    }
}