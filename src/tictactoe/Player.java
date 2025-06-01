package tictactoe;

import java.util.UUID;

public class Player {
    public String id;
    public String name;

    public Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }
}
