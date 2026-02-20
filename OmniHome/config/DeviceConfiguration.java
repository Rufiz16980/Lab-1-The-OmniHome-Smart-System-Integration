package az.edu.ada.modules.module04.OmniHome.config;

// Implements Cloneable interface to mark it as valid for cloning
public class DeviceConfiguration implements Cloneable {
    private String protocol;
    private String firmwareVersion;
    private String securityKey;

    public DeviceConfiguration(String protocol, String firmwareVersion, String securityKey) {
        this.protocol = protocol;
        this.firmwareVersion = firmwareVersion;
        this.securityKey = securityKey;
        // Simulate a slow setup process (e.g., database lookup)
        try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    // The method that performs the copy
    @Override
    public DeviceConfiguration clone() {
        try {
            // super.clone() performs a shallow copy, which is fine for Strings
            return (DeviceConfiguration) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Should never happen
        }
    }

    // Getters and Setters
    public void setProtocol(String protocol) { this.protocol = protocol; }
    public String getProtocol() { return protocol; }

    @Override
    public String toString() {
        return "Config [Protocol=" + protocol + ", Firmware=" + firmwareVersion + "]";
    }
}