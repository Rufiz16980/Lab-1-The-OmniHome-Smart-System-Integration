package az.edu.ada.modules.module04.OmniHome.interfaces;

// Abstract base class for all devices
public abstract class SmartDevice {
    private String id;
    private String name;
    protected boolean isOn;

    public SmartDevice(String id, String name) {
        this.id = id;
        this.name = name;
        this.isOn = false;
    }

    // Common methods
    public String getId() { return id; }
    public String getName() { return name; }
    public boolean isOn() { return isOn; }

    // Abstract methods that children MUST implement
    public abstract void turnOn();
    public abstract void turnOff();

    // Using simple string representation for debugging
    @Override
    public String toString() {
        return "Device [ID=" + id + ", Name=" + name + ", Status=" + (isOn ? "ON" : "OFF") + "]";
    }
}