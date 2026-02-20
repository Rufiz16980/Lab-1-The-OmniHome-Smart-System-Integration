package az.edu.ada.modules.module04.OmniHome.interfaces;

public interface SmartLight {
    // Basic contract for all lights (Luxury or Budget)
    void setBrightness(int level);
    void setColor(String hexColor);
    int getBrightness();
}