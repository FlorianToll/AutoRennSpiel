package log;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;

public class LogEvent {
    protected String content = null;
    protected Collection<String> contents = null;
    protected Instant time;

    public LogEvent(String content) {
        this.content = content;
        time = Instant.now();
    }

    public LogEvent(Collection<String> contents) {
        this.contents = contents;
        time = Instant.now();
    }

    public Collection<String> getContent() {
        if (content == null)
            return contents;
        else
            return Arrays.asList(content);
    }

    public Instant getTime() {
        return time;
    }
}
