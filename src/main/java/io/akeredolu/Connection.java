package io.akeredolu;

/**
 * Created by mikailaakeredolu on 5/19/16.
 */
public interface Connection {
    public String getIP();
    public String getPort();
    public String getProtocol();
    public String connect();
    public void closeMethod();

}
