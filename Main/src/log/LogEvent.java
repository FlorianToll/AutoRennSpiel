package log;

import java.util.Arrays;
import java.util.Collection;

public class LogEvent {
    private String content = null;
    private Collection<String> contents = null;

    public LogEvent(String content) {
        this.content = content;
    }

    public LogEvent(Collection<String> contents) {
        this.contents = contents;
    }

    public Collection<String> getContent() {
        if (content == null)
            return contents;
        else
            return Arrays.asList(content);
    }
}
