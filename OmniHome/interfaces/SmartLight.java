package az.edu.ada.modules.module04.OmniHome.interfaces;

public interface SmartLight {
    void setBrightness(int level);
    void setColor(String hexColor);
    int getBrightness();
}