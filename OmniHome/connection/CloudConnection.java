package az.edu.ada.modules.module04.OmniHome.connection;

public class CloudConnection {

    private static volatile CloudConnection instance;
    private boolean isConnected;

    private String apiKey;
    private String serverUrl;

    private CloudConnection() {
        System.out.println("Establishing connection to OmniHome Cloud...");
        this.isConnected = true;
        this.apiKey = "DEFAULT_API_KEY";
        this.serverUrl = "https://api.omnihome.cloud";
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

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getServerUrl() {
        return serverUrl;
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