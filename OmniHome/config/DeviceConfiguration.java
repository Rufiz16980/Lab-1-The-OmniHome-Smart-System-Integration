package az.edu.ada.modules.module04.OmniHome.config;

public class DeviceConfiguration implements Cloneable {
    private String ipAddress;
    private int port;
    private String firmwareVersion;

    public DeviceConfiguration(String ipAddress, int port, String firmwareVersion) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.firmwareVersion = firmwareVersion;
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

    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }
    public String getIpAddress() { return ipAddress; }

    @Override
    public String toString() {
        return "Config [IP=" + ipAddress + ", Port=" + port + ", Firmware=" + firmwareVersion + "]";
    }
}