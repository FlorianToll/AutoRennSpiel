package net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    SocketLogger logger;
    Socket socket;
    
    public Client(String publicIPv4Address, int port) {
        try {
            socket = new Socket(InetAddress.getByName(publicIPv4Address), port);
            logger = new SocketLogger(socket);
        } catch (IOException ie) { }
    }
}
