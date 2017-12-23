package net;

import log.Logger;

import java.net.Socket;

public class SocketLogger extends Logger {
    private Socket socket;

    public SocketLogger(Socket socket) {
        this.socket = socket;
    }
}
