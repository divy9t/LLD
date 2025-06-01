package tictactoe;

import tictactoe.drivers.GameDriver;

public class TTTMain {
    public static void main(String[] args) {
        GameDriver gameDriver = new GameDriver();
        Game game = gameDriver.createGame("Navdeep", "Divyansh");
        game.startGame();
    }
}
