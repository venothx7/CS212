package CS212.Assignment2;


public class TicTacToe {
    private String[] board;

    public TicTacToe() {
    }

    public void createBoard() {//initialize board with empty string
        String[] board = new String[9];

        for (String temp : board) {
            temp = " ";
        }

    }

    @Override
    public String toString() { // prints board
        return board[0] + " | " + board[1] + " | " + board[2] + "\n" +
                board[3] + " | " + board[4] + " | " + board[5] + "\n" +
                board[6] + " | " + board[7] + " | " + board[8];
    }
}

