package az.edu.ada.modules.module04.OmniHome.automation;

import az.edu.ada.modules.module04.OmniHome.interfaces.SmartDevice;
import java.util.ArrayList;
import java.util.List;

public class AutomationRoutine {
    private String name;
    private String triggerTime; // e.g., "08:00"
    private List<SmartDevice> devices;
    private boolean sendNotification;

    // Private constructor: Only the Builder can call this
    private AutomationRoutine(String name, String triggerTime, List<SmartDevice> devices, boolean sendNotification) {
        this.name = name;
        this.triggerTime = triggerTime;
        this.devices = devices;
        this.sendNotification = sendNotification;
    }

    //  shows how it uses devices
    public void execute() {
        System.out.println("--- Executing Routine: " + name);
        for (SmartDevice device : devices) {
            device.turnOn();
        }
        System.out.println("-----------------------------------");
    }

    // Getters for testing
    public String getName() { return name; }
    public List<SmartDevice> getDevices() { return devices; }
    public String getTriggerTime() { return triggerTime; }
    public boolean isSendNotification() { return sendNotification; }

    // Static inner class for the Builder
    public static class RoutineBuilder {
        private String name;
        private String triggerTime;
        private List<SmartDevice> devices = new ArrayList<>();
        private boolean sendNotification = false;

        public RoutineBuilder() {
        }

        public RoutineBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public RoutineBuilder atTime(String time) {
            this.triggerTime = time;
            return this; // Return this to allow chaining
        }

        public RoutineBuilder addDevice(SmartDevice device) {
            this.devices.add(device);
            return this;
        }

        public RoutineBuilder toggleNotification() {
            this.sendNotification = !this.sendNotification;
            return this;
        }

        public AutomationRoutine build() {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalStateException("Routine must have a name.");
            }
            if (devices.isEmpty()) {
                throw new IllegalStateException("Routine must contain at least one device.");
            }
            return new AutomationRoutine(name, triggerTime, devices, sendNotification);
        }
    }
}