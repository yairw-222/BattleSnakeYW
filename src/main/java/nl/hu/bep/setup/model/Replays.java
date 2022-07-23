package nl.hu.bep.setup.model;


import nl.hu.bep.setup.webservice.Request.GameRequest;

import java.util.List;

public class Replays {
    private static List<GameRequest> replays;

    public Replays(List<GameRequest> replays) {

        Replays.replays = replays;
    }

    public static List<GameRequest> getReplays() {
        return replays;
    }

    public void setReplays(List<GameRequest> replays) {
        this.replays = replays;
    }

    
}
