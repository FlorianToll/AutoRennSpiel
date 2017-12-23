package net;

import log.LogEvent;

import java.net.InetAddress;
import java.time.Instant;
import java.util.Collection;

public class SocketEvent extends LogEvent {
    private InetAddress address;

    public SocketEvent(InetAddress adr, String content) {
        super(content);
        address = adr;
        this.content = content;
        time = Instant.now();
    }

    public SocketEvent(InetAddress adr, Collection<String> contents) {
        super(contents);
        address = adr;
        this.contents = contents;
        time = Instant.now();
    }

    public InetAddress getAddress() {
        return address;
    }
}
