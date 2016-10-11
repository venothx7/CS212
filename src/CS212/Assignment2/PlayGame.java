package CS212.Assignment2;

import java.util.Arrays;

public class PlayGame {
    private String[][] board = new String[3][3];
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    // Create board
    public PlayGame() {
        createBoard();
    }
    //check if board has winner, tie, Full
    public void boardState(int player){
        if(checkWinner()){
            System.out.println(player +" has WON the game!!");
            counter=9;
        }
        if(counter==0){
            System.out.println("Game is a Tie");

        }
    }


    public Boolean checkWinner(){
        int col =0; int row =0;
        //Checks if there is a winner in Columns
        while(col<=2){
            if(checkThree(board[0][col],board[1][col],board[2][col])){
                return true;
            }
            col++;
        }
        //Checks if there is a winner in Rows
        while (row<=2){
            if(checkThree(board[row][0],board[row][1],board[row][2])){
                return true;
            }
        }
        /**
         * checks both diagonals
         */
        //checks the left diagonal(- slope)
        if(checkThree(board[0][0],board[1][1],board[2][2])){
            return true;
        }
        //checks right diagonal(+ slope)
        if(checkThree(board[2][0],board[2][2],board[0][2])){
            return true;
        }
        return false;
    }

    /**
     * input 3 strings
     * checks if 3 strings are equal
     */
    public Boolean checkThree(String a, String b, String c){
        //returns true if winner found
        return !a.equals(" ") && a.equals(b) && b.equals(c);
    }

    public void addMove(int row,int col) {

        if (counter % 2 == 0) { //even for 0,2,4,6,8}
            //System.out.println("even " + counter);
            board[row][col] = "X";
        } else {//Odd 1,3,5,7
            //System.out.println("odd " + counter);
            board[row][col] = "O";
        }
    }
    public Boolean validateInput(int pos){
        return false;
    }

    public Boolean validateMove(int r, int c) {
        return board[r][c] == " ";
    }

    public void createBoard() {
        for (String[] row : board) {
            Arrays.fill(row," ");
        }
    }


    public void addCounter() {
        counter++;
    }


    public Boolean checkCounter() {
        return counter < 9;
    }

    @Override
    public String toString() {
        return board[0][0] + " | " + board[0][1] + " | " + board[0][2] + "\n" +
                board[1][0] + " | " + board[1][1] + " | " + board[1][2] + "\n" +
                board[2][0] + " | " + board[2][1] + " | " + board[2][2];
    }
}
