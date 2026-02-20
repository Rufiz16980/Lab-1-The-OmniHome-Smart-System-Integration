package az.edu.ada.modules.module04.OmniHome.devices;

import az.edu.ada.modules.module04.OmniHome.interfaces.SmartDevice;
import az.edu.ada.modules.module04.OmniHome.interfaces.SmartLock;

public class BudgetLock extends SmartDevice implements SmartLock {

    public BudgetLock(String id) {
        super(id, "Budget Lock (No camera)");
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
        System.out.println(getName() + " locked.");
    }
}