package net;

import java.net.Socket;

public class Client {
    Socket socket;
    public Client(int port) {
        socket = new Socket(serverAddress, port);
    }
}
