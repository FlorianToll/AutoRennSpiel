package evt;

public interface WorldListener {
    void onPlayerJoin(PlayerJoinEvent evt);
    void onPlayerLeave(PlayerLeaveEvent evt);
    void onPlayerTimeout(PlayerTimeoutEvent evt);
}
