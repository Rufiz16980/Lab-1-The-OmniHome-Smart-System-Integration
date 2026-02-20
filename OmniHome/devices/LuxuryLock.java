package az.edu.ada.modules.module04.OmniHome.devices;

import az.edu.ada.modules.module04.OmniHome.interfaces.SmartDevice;
import az.edu.ada.modules.module04.OmniHome.interfaces.SmartLock;

public class LuxuryLock extends SmartDevice implements SmartLock {

    public LuxuryLock(String id) {
        super(id, "Luxury Lock (Face ID)");
    }

    @Override
    public void turnOn() {
        this.isOn = true;
        System.out.println(getName() + " is ON.");
    }

    @Override
    public void turnOff() {
        this.isOn = false;
        System.out.println(getName() + " is OFF.");
    }

    @Override
    public void lock() {
        System.out.println(getName() + " locked with Face ID.");
    }
}