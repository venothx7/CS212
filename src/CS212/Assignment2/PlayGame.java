package CS212.Assignment2;

public class PlayGame {
    private String[] board = new String[9];
    private int counter = 0;

    public int getCounter() {
        return counter;
    }


    public PlayGame() {
        createBoard();
    }
    public void boardState(int player){

    }
    public Boolean checkWinner(){
        int a=0, b=1,c=2, count=0;
        while(count!=3){//checks rows
            if(checkThree(board[a],board[b],board[c])){
                return true;
            }
            a+=3;b+=3;c+=3;
            count++;
        }
        int colum=0;
        count=0;
        while(count!=3){//check columns
            if(checkThree(board[colum],board[colum+3],board[colum+6])){
                return true;
            }
            count++;
        }

        //check both diagonal
        if(checkThree(board[0],board[4],board[8])){
            return true;
        }
        if(checkThree(board[2],board[4],board[6])){
            return true;
        }
        return false;
    }

    public Boolean checkThree(String a, String b, String c){
        //returns true if winner found
        return !a.equals(" ") & a.equals(b) & b.equals(c);
    }



    public void addMove(int pos) {

        if (counter % 2 == 0) { //even for 0,2,4,6,8}
            //System.out.println("even " + counter);
            board[pos] = "X";
        } else {//Odd 1,3,5,7
            //System.out.println("odd " + counter);
            board[pos] = "O";
        }
    }

    public Boolean validateMove(int pos) {
        return board[pos] == " ";
    }

    public void createBoard() {
        for (String s : board)
            s = " ";
    }

    public void addCounter() {
        counter++;
    }


    public Boolean checkCounter() {
        return counter < 9;
    }

    @Override
    public String toString() {
        return board[0] + " | " + board[1] + " | " + board[2] + "\n" +
                board[3] + " | " + board[4] + " | " + board[5] + "\n" +
                board[6] + " | " + board[7] + " | " + board[8];
    }
}
