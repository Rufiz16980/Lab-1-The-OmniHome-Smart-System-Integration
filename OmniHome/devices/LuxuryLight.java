package az.edu.ada.modules.module04.OmniHome.devices;

import az.edu.ada.modules.module04.OmniHome.interfaces.SmartLight;
import az.edu.ada.modules.module04.OmniHome.interfaces.SmartDevice;

public class LuxuryLight extends SmartDevice implements SmartLight {
    private int brightness = 0;
    private String color = "Warm White";

    public LuxuryLight(String id) {
        super(id, "Luxury Phillips Hue Gen4");
    }

    @Override
    public void turnOn() {
        this.isOn = true;
        this.brightness = 100; // Luxury lights fade on to 100%
        System.out.println(getName() + " is gently fading ON.");
    }

    @Override
    public void turnOff() {
        this.isOn = false;
        this.brightness = 0;
        System.out.println(getName() + " is gently fading OFF.");
    }

    @Override
    public void setBrightness(int level) {
        if (isOn) {
            this.brightness = level;
            System.out.println(getName() + " adjusted brightness to " + level + "%.");
        }
    }

    @Override
    public void setColor(String hexColor) {
        this.color = hexColor;
        System.out.println(getName() + " changed color to " + hexColor);
    }

    @Override
    public int getBrightness() { return brightness; }
}