package io.akeredolu;

/**
 * Created by mikailaakeredolu on 5/19/16.
 */
public class ConnectionManager {

    int connectionLimit ;
    int connectionsLimitCounter = 0;

    public int getConnectionLimit() {
        return connectionLimit;
    }

    public int getConnectionsLimitCounter() {
        return connectionsLimitCounter;
    }

    public ConnectionManager(int connectionLimitRequested){
        connectionLimit = connectionLimitRequested;

    }

    public ManagedConnection getConnectionObjects(String newIP, String newProtocol){

        if (newProtocol.equals("HTTP") || newProtocol.equals("HTTPS") || newProtocol.equals("SFTP") &&  connectionsLimitCounter <= connectionLimit){
            connectionsLimitCounter++;
            return new ManagedConnection(newIP, newProtocol);

        }else{
            return null;
        }

    }

    private class ManagedConnection implements Connection{

        String iP = "1234hfjkf";
        String port = "67890";
        String protocol = "ytele12";
        String status = "open";

        public ManagedConnection(String ipAddress, String protocolAddress){
            iP = ipAddress;
            protocol = protocolAddress;
        }


        public String getIP(){
            if (status.equals("close")){
                return "closed";
            }else{
                return iP;
            }
        }
        public String getPort(){
            if(status.equals("close")){
                return "closed";
            }else{
                return port;
            }
        }
        public String getProtocol(){
            if(status.equals("close")){
                return "closed";
            }else{
                return protocol;
            }

        }
        public String connect(){
            if(status.equals("close")){
                return "closed";
            }else{
                return "connect";
            }
        }

        public void closeMethod(){
           connectionsLimitCounter--;
            status = "close";
        }




    }
}
