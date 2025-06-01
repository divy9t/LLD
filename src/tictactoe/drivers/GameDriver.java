package tictactoe.drivers;

import tictactoe.Game;
import tictactoe.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameDriver {
    List<Game> games;
    HashMap<String, List<Game>> playerGames;
    PlayerDriver playerDriver;

    public GameDriver() {
        playerDriver = new PlayerDriver();
        games= new ArrayList<>();
        playerGames = new HashMap<>();
    }

    public Game createGame(String player1, String player2) {
        Player playerOne = playerDriver.cretePlayer(player1);
        Player playerTwo = playerDriver.cretePlayer(player2);

        Game game = new Game(playerOne, playerTwo);
        games.add(game);
        List<Game> play1 = playerGames.getOrDefault(playerOne.id, new ArrayList<>());
        play1.add(game);
        List<Game> play2 = playerGames.getOrDefault(playerTwo.id, new ArrayList<>());
        play2.add(game);
        playerGames.put(playerOne.id,play1);
        playerGames.put(playerTwo.id,play2);
        return game;
    }
}
