package az.edu.ada.modules.module04.OmniHome;

import az.edu.ada.modules.module04.OmniHome.connection.CloudConnection;
import az.edu.ada.modules.module04.OmniHome.factories.*;
import az.edu.ada.modules.module04.OmniHome.interfaces.*;
import az.edu.ada.modules.module04.OmniHome.legacy.*;
import az.edu.ada.modules.module04.OmniHome.automation.AutomationRoutine;
import az.edu.ada.modules.module04.OmniHome.config.DeviceConfiguration;

public class Main {
    public static void main(String[] args) {

        // singleton
        CloudConnection cloud = CloudConnection.getInstance();
        cloud.sendData("System Initialized");

        // prototype
        System.out.println("\n--- Fetching Network Config ---");
        DeviceConfiguration masterConfig = new DeviceConfiguration("ExtraCoolWiFI Pro", "v4.5", "KYS-1488");
        System.out.println("Master Config Created: " + masterConfig);

        // abstract factory
        System.out.println("\n--- Deploying Devices ---");
        SmartHomeFactory factory = new LuxuryHomeFactory();

        SmartLight livingRoomLight = factory.createSmartLight();
        SmartThermostat mainThermostat = factory.createSmartThermostat();

        DeviceConfiguration lightConfig = masterConfig.clone();

        System.out.println("Configured " + ((SmartDevice) livingRoomLight).getName() + " with " + lightConfig);

        // adapter
        GlorbThermostat oldHeater = new GlorbThermostat();
        SmartDevice basementHeater = new GlorbAdapter("GLORB-01", oldHeater);

        // builder
        System.out.println("\n--- Building Automation Routine ---");
        AutomationRoutine morningRoutine = new AutomationRoutine.RoutineBuilder("Morning Wake Up")
                .atTime("07:00 AM")
                .addDevice((SmartDevice) livingRoomLight)
                .addDevice((SmartDevice) mainThermostat)
                .addDevice(basementHeater) // This is already a SmartDevice, so no cast needed
                .setRepeat(true)
                .build();

        // turn on all devices
        morningRoutine.execute();

        System.out.println("\n--- Manual Control Override ---");
        livingRoomLight.setBrightness(50);
        mainThermostat.setTemperature(22.5);

        ((SmartThermostat) basementHeater).setTemperature(22.5);

        System.out.println("\n=== SYSTEM SHUTDOWN ===");
    }
}