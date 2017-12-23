package core;

public class AdminPlayer extends Player {
    private Permissions[] perks = new Permissions[] { Permissions.CAN_KICK,
            Permissions.CAN_START_GAME,
            Permissions.CAN_HALT_GAME,
            Permissions.CAN_STOP_GAME,
            Permissions.CAN_BROADCAST
    };
}
