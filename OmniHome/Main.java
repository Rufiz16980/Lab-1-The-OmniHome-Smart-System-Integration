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
        CloudConnection cloud2 = CloudConnection.getInstance();
        System.out.println("CloudConnection instance 1 memory id: " + System.identityHashCode(cloud));
        System.out.println("CloudConnection instance 2 memory id: " + System.identityHashCode(cloud2));
        cloud.sendData("System Initialized");

        // prototype
        System.out.println("\n--- Fetching Network Config ---");
        DeviceConfiguration masterConfig = new DeviceConfiguration("192.168.1.10", 8080, "v4.5");
        System.out.println("Master Config Created: " + masterConfig);

        // abstract factory
        System.out.println("\n--- Deploying Devices ---");
        SmartHomeFactory factory = new LuxuryHomeFactory();

        SmartLight livingRoomLight = factory.createSmartLight();
        SmartThermostat mainThermostat = factory.createSmartThermostat();
        SmartLock frontDoorLock = factory.createSmartLock();

        DeviceConfiguration lightConfig = masterConfig.clone();
        lightConfig.setIpAddress("192.168.1.11");

        System.out.println("Configured " + ((SmartDevice) livingRoomLight).getName() + " with " + lightConfig);

        // adapter
        GlorbThermostat oldHeater = new GlorbThermostat();
        SmartDevice basementHeater = new GlorbAdapter("GLORB-01", oldHeater);

        // builder
        System.out.println("\n--- Building Automation Routine ---");
        AutomationRoutine movieNightRoutine = new AutomationRoutine.RoutineBuilder()
                .withName("Movie Night")
                .atTime("09:00 PM")
                .addDevice((SmartDevice) livingRoomLight)
                .addDevice((SmartDevice) mainThermostat)
                .addDevice((SmartDevice) frontDoorLock)
                .addDevice(basementHeater) // This is already a SmartDevice, so no cast needed
                .toggleNotification()
                .build();

        // turn on all devices
        movieNightRoutine.execute();

        System.out.println("\n--- Manual Control Override ---");
        livingRoomLight.setBrightness(50);
        mainThermostat.setTemperature(22.5);
        frontDoorLock.lock();

        ((SmartThermostat) basementHeater).setTemperature(22.5);

    }
}