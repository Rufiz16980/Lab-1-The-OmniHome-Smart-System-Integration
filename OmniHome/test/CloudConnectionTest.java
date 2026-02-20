package az.edu.ada.modules.module04.OmniHome.test;

import az.edu.ada.modules.module04.OmniHome.connection.CloudConnection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CloudConnectionTest {

    @Test
    void testSingletonUniqueness() {
        // Get the instance twice
        CloudConnection conn1 = CloudConnection.getInstance();
        CloudConnection conn2 = CloudConnection.getInstance();

        // Assert they are the EXACT same object in memory
        assertSame(conn1, conn2, "Both instances should point to the same memory address");
    }

    @Test
    void testConnectionStatus() {
        CloudConnection conn = CloudConnection.getInstance();
        assertTrue(conn.isConnected(), "Connection should be active upon initialization");
    }
}