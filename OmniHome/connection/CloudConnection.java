package az.edu.ada.modules.module04.OmniHome.connection;

public class CloudConnection {

    // volatile ensures that multiple threads handle the unique instance variable correctly
    private static volatile CloudConnection instance;
    private boolean isConnected;

    // Private constructor prevents instantiation from other classes
    private CloudConnection() {
        // Simulate a connection process
        System.out.println("Establishing connection to OmniHome Cloud...");
        this.isConnected = true;
    }

    // Public method to provide access to the instance
    public static CloudConnection getInstance() {
        // First check (no locking) - Performance optimization
        if (instance == null) {
            // Locking
            synchronized (CloudConnection.class) {
                // Second check (with locking) - Thread safety
                if (instance == null) {
                    instance = new CloudConnection();
                }
            }
        }
        return instance;
    }

    public void sendData(String data) {
        if (isConnected) {
            System.out.println("Sending to cloud: " + data);
        } else {
            System.out.println("Error: Not connected to cloud.");
        }
    }

    public boolean isConnected() {
        return isConnected;
    }
}