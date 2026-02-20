package az.edu.ada.modules.module04.OmniHome.config;

public class DeviceConfiguration implements Cloneable {
    private String protocol;
    private String firmwareVersion;
    private String securityKey;

    public DeviceConfiguration(String protocol, String firmwareVersion, String securityKey) {
        this.protocol = protocol;
        this.firmwareVersion = firmwareVersion;
        this.securityKey = securityKey;
        // to show that object creation is time-consuming, cloning would be faster
        try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    @Override
    public DeviceConfiguration clone() {
        try {
            // super.clone() performs a shallow copy
            // in shallow cloning both original and clone access the same object
            // but all configuration fields are strings which are
            // immutable, so it does not matter
            return (DeviceConfiguration) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Should never happen
        }
    }

    public void setProtocol(String protocol) { this.protocol = protocol; }
    public String getProtocol() { return protocol; }

    @Override
    public String toString() {
        return "Config [Protocol=" + protocol + ", Firmware=" + firmwareVersion + "]";
    }
}