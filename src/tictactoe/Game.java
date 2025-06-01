package tictactoe;

import java.util.*;

public class Game {
    enum STATES {
        INITIALISED,
        COMPLETED,
        DRAW

    }
    Deque<Player> players;
    Long startTimeStamp;
    Board board;
    Player winner;
    String uuid;
    STATES state;

    int[] visited;

    public Game(Player player1, Player player2) {
        players = new LinkedList<>();
        players.push(player1);
        players.push(player2);

        startTimeStamp = System.currentTimeMillis();
        board = new Board();
        winner = null;
        uuid = UUID.randomUUID().toString();

        state = STATES.INITIALISED;
        visited = new int[9];
        Arrays.fill(visited, -1);
    }

    public void startGame() {
        int currentPiece = 0;
        while (true) {
            if (board.currentFilled == 9) {
                System.out.println("Game draw hui hai mitron !!");
                state = STATES.DRAW;
                break;
            }
            Player currentPlayer = players.pollFirst();
            int random = getRandomNumberUsingNextInt(0,9);
            int row = random / 3;
            int col = random % 3;
            Integer winningPiece = board.isWinningPiece(currentPiece, row, col);
            if (winningPiece == 1) {
                winner = currentPlayer;
                state = STATES.COMPLETED;
                break;
            }
            players.addLast(currentPlayer);
            currentPiece = 1 - currentPiece;
        }

        if (winner != null) {
            System.out.println("\n"+"The current winner is 🥇 " + winner.name+"\n");
        }
        board.printBoard();

    }

    private int getRandomNumberUsingNextInt(int min, int max) {
        while (true) {
            Random random = new Random();
            int i = random.nextInt(max - min) + min;
            if (visited[i] != -1) {
                continue;
            }
            visited[i] = 1;
            return i;
        }

    }
}
