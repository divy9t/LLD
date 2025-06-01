package tictactoe;

import java.util.*;

public class Board {
    Cell[][] cells;
    HashMap<Integer, Integer> pieceCount = new HashMap<>();
    Integer currentFilled ;


    public Board() {
        cells = new Cell[3][3];
        initialiseCells();
        this.currentFilled = 0;
    }

    private void initialiseCells() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public Integer isWinningPiece(Integer goti, int row, int col) {
        cells[row][col].piece = goti;
        currentFilled++;
        pieceCount.put(goti, pieceCount.getOrDefault(goti, 0) + 1);

        // Always check for win
        if (isCurrentWinner(goti)) return 1;

        return 0;
    }

    private boolean isCurrentWinner(Integer piece) {
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (Objects.equals(cells[i][0].piece, piece) && Objects.equals(cells[i][1].piece, piece) && Objects.equals(cells[i][2].piece, piece))
                return true;

            // Check columns
            if (Objects.equals(cells[0][i].piece, piece) && Objects.equals(cells[1][i].piece, piece) && Objects.equals(cells[2][i].piece, piece))
                return true;
        }


        // Check main diagonal
        if (Objects.equals(cells[0][0].piece, piece) && Objects.equals(cells[1][1].piece, piece) && Objects.equals(cells[2][2].piece, piece))
            return true;

        // Check anti-diagonal
        return Objects.equals(cells[0][2].piece, piece) && Objects.equals(cells[1][1].piece, piece) && Objects.equals(cells[2][0].piece, piece);

    }

    public void printBoard() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j].piece  == null ? " X " : " " + cells[i][j].piece  + " ");
                if (j < cells[i].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < cells.length - 1) {
                System.out.println("---+---+---");
            }
        }
    }


}

