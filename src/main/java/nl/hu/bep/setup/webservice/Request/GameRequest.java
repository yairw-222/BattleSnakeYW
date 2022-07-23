package nl.hu.bep.setup.webservice.Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameRequest {
    public int turn;
    public int health;
    public int length;
    public Map<String, Object> you;

    public GameRequest(int turn, int health, int length, Map<String, Object> you) {
        this.turn = turn;
        this.health = health;
        this.length = length;
        this.you = you;
    }

    public GameRequest() {
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Map<String, Object> getYou() {
        return you;
    }

    public void setYou(Map<String, Object> you) {
        this.you = you;
    }
}
