package net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    Socket socket;
    public Client(int port) {
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), port);
        } catch (IOException ie) {

        }
    }
}
