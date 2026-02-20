package az.edu.ada.modules.module04.OmniHome.devices;

import az.edu.ada.modules.module04.OmniHome.interfaces.SmartLight;
import az.edu.ada.modules.module04.OmniHome.interfaces.SmartDevice;

public class BudgetLight extends SmartDevice implements SmartLight {
    private int brightness = 0;

    public BudgetLight(String id) {
        super(id, "Generic Budget Bulb");
    }

    @Override
    public void turnOn() {
        this.isOn = true;
        this.brightness = 100;
        System.out.println(getName() + " flickered ON.");
    }

    @Override
    public void turnOff() {
        this.isOn = false;
        this.brightness = 0;
        System.out.println(getName() + " turned OFF instantly.");
    }

    @Override
    public void setBrightness(int level) {
        System.out.println("Error: " + getName() + " does not support dimming functionality.");
    }

    @Override
    public void setColor(String hexColor) {
        System.out.println("Error: " + getName() + " only supports White color.");
    }

    @Override
    public int getBrightness() { return brightness; }
}