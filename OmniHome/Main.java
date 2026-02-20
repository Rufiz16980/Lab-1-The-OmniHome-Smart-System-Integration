package az.edu.ada.modules.module04.OmniHome;

import az.edu.ada.modules.module04.OmniHome.connection.CloudConnection;
import az.edu.ada.modules.module04.OmniHome.factories.*;
import az.edu.ada.modules.module04.OmniHome.interfaces.*;
import az.edu.ada.modules.module04.OmniHome.legacy.*;
import az.edu.ada.modules.module04.OmniHome.automation.AutomationRoutine;
import az.edu.ada.modules.module04.OmniHome.config.DeviceConfiguration;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== OMNIHOME SYSTEM STARTUP ===\n");

        // 1. SINGLETON
        CloudConnection cloud = CloudConnection.getInstance();
        cloud.sendData("System Initialized");

        // 2. PROTOTYPE
        System.out.println("\n--- Fetching Network Config ---");
        DeviceConfiguration masterConfig = new DeviceConfiguration("ZigBee Pro", "v4.5", "AES-256");
        System.out.println("Master Config Created: " + masterConfig);

        // 3. ABSTRACT FACTORY
        System.out.println("\n--- Deploying Devices ---");
        SmartHomeFactory factory = new LuxuryHomeFactory();

        SmartLight livingRoomLight = factory.createSmartLight();
        SmartThermostat mainThermostat = factory.createSmartThermostat();

        DeviceConfiguration lightConfig = masterConfig.clone();

        // FIX 1: Cast to (SmartDevice) to access getName()
        System.out.println("Configured " + ((SmartDevice) livingRoomLight).getName() + " with " + lightConfig);

        // 4. ADAPTER
        GlorbThermostat oldHeater = new GlorbThermostat();
        SmartDevice basementHeater = new GlorbAdapter("GLORB-01", oldHeater);

        // 5. BUILDER
        System.out.println("\n--- Building Automation Routine ---");
        AutomationRoutine morningRoutine = new AutomationRoutine.RoutineBuilder("Morning Wake Up")
                .atTime("07:00 AM")
                // FIX 2: Cast to (SmartDevice) so it fits into the List<SmartDevice>
                .addDevice((SmartDevice) livingRoomLight)
                .addDevice((SmartDevice) mainThermostat)
                .addDevice(basementHeater) // This is already a SmartDevice, so no cast needed
                .setRepeat(true)
                .build();

        // 6. EXECUTE
        morningRoutine.execute();

        System.out.println("\n--- Manual Control Override ---");
        livingRoomLight.setBrightness(50);
        mainThermostat.setTemperature(22.5);

        ((SmartThermostat) basementHeater).setTemperature(22.5);

        System.out.println("\n=== SYSTEM SHUTDOWN ===");
    }
}