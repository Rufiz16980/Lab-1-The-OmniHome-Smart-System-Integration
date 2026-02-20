package az.edu.ada.modules.module04.OmniHome.automation;

import az.edu.ada.modules.module04.OmniHome.interfaces.SmartDevice;
import java.util.ArrayList;
import java.util.List;

public class AutomationRoutine {
    private String name;
    private String scheduleTime; // e.g., "08:00"
    private List<SmartDevice> devices;
    private boolean isRepeatEnabled;

    // Private constructor: Only the Builder can call this
    private AutomationRoutine(String name, String scheduleTime, List<SmartDevice> devices, boolean isRepeatEnabled) {
        this.name = name;
        this.scheduleTime = scheduleTime;
        this.devices = devices;
        this.isRepeatEnabled = isRepeatEnabled;
    }

    public void execute() {
        System.out.println("--- Executing Routine: " + name + " ---");
        for (SmartDevice device : devices) {
            device.turnOn();
        }
        System.out.println("-----------------------------------");
    }

    // Getters for testing
    public String getName() { return name; }
    public List<SmartDevice> getDevices() { return devices; }

    // Static inner class for the Builder
    public static class RoutineBuilder {
        private String name;
        private String scheduleTime;
        private List<SmartDevice> devices = new ArrayList<>();
        private boolean isRepeatEnabled = false;

        public RoutineBuilder(String name) {
            this.name = name;
        }

        public RoutineBuilder atTime(String time) {
            this.scheduleTime = time;
            return this; // Return "this" to allow chaining
        }

        public RoutineBuilder addDevice(SmartDevice device) {
            this.devices.add(device);
            return this;
        }

        public RoutineBuilder setRepeat(boolean repeat) {
            this.isRepeatEnabled = repeat;
            return this;
        }

        public AutomationRoutine build() {
            if (devices.isEmpty()) {
                throw new IllegalStateException("Routine must contain at least one device.");
            }
            return new AutomationRoutine(name, scheduleTime, devices, isRepeatEnabled);
        }
    }
}