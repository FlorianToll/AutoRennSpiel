package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket listener;
    private Socket socket;

    public Server(int port) throws IOException {
        listener = new ServerSocket(port);
        try {
            while (true) {
                socket = null;
                socket = listener.accept();
            }
        } finally {
            listener.close();
        }
    }
}