package log;

import java.util.ArrayList;
import java.util.Collection;

public class Logger {
    protected ArrayList<String> logs = new ArrayList<>();
    protected LogListener listener;

    public Logger() { }

    public void log(String txt) {
        logs.add(txt);
        listener.onLog(new LogEvent(txt));
    }

    public void log(Collection<String> txt) {
        logs.addAll(txt);
        listener.onLog(new LogEvent(txt));
    }

    public void setListener(LogListener listener) {
        this.listener = listener;
    }
}
