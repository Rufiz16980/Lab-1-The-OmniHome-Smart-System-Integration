package az.edu.ada.modules.module04.OmniHome.interfaces;

public abstract class SmartDevice {
    private String id;
    private String name;
    protected boolean isOn;

    public SmartDevice(String id, String name) {
        this.id = id;
        this.name = name;
        this.isOn = false;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public boolean isOn() { return isOn; }

    public abstract void turnOn();
    public abstract void turnOff();

    @Override
    public String toString() {
        return "Device [ID=" + id + ", Name=" + name + ", Status=" + (isOn ? "ON" : "OFF") + "]";
    }
}