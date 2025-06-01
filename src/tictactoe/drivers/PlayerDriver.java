package tictactoe.drivers;

import java.util.*;
import tictactoe.Player;

public class PlayerDriver {
    List<Player> players;

    public PlayerDriver() {
        players = new ArrayList<>();
    }

    public Player cretePlayer(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
        return player;
    }
}
