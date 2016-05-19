package io.akeredolu;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mikailaakeredolu on 5/19/16.
 */
public class ConnectionManagerTest {
    @Test
    public void getConnectionObjectsTest(){
        ConnectionManager connectionManager = new ConnectionManager(5);
        Assert.assertNotNull("Should return an object", connectionManager.getConnectionObjects("12345","HTTPS"));
    }

    @Test
    public void getConnectionObjectsNULLTest(){
        ConnectionManager connectionManager = new ConnectionManager(5);
        Assert.assertNull("Should return an object", connectionManager.getConnectionObjects("1235",""));
    }

    @Test
    public void connectionManagerTest(){
        ConnectionManager connectionManagerTest = new ConnectionManager(2);
        int expectedValue = 2;
        int actualValue = connectionManagerTest.getConnectionLimit();
        Assert.assertEquals("Answer should be ", expectedValue,actualValue);
    }

    //check if counter is working
    @Test
    public void connectionsLimitCounterTest(){
        ConnectionManager connectionManagerTest = new ConnectionManager(2);
        connectionManagerTest.getConnectionObjects("12234","HTTPS");
        connectionManagerTest.getConnectionObjects("12234","HTTPS");
        int expectedValue = 2;
        int actualValue = connectionManagerTest.getConnectionsLimitCounter();
        Assert.assertEquals("Answer should be 1", expectedValue,actualValue);

    }


    //check for close test
    @Test
    public void closeMethodTest(){
        ConnectionManager connectionManager = new ConnectionManager(1);
        Connection managedConnection = connectionManager.getConnectionObjects("11234","HTTP");
        String expectedIP = "closed";
        managedConnection.closeMethod();
        String actualIP = managedConnection.getIP();
        Assert.assertEquals(expectedIP,actualIP);


    }

}
