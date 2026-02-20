package az.edu.ada.modules.module04.OmniHome.connection;

public class CloudConnection {

    private static volatile CloudConnection instance;
    private boolean isConnected;

    private CloudConnection() {
        System.out.println("Establishing connection to OmniHome Cloud...");
        this.isConnected = true;
    }

    public static CloudConnection getInstance() {
        if (instance == null) {
            synchronized (CloudConnection.class) {
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