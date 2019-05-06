package com.almogharel.tictactoe;

public class TicTacToeGame {
    protected char [][] board;
    private char player;
    private char computer;
    boolean isOver,isEmpty;
    private final int COMPUTER_TURNS=4 ,MAX_ROW=3 ,MAX_COL=3;

    public TicTacToeGame(){
        this.board = new char[MAX_ROW][MAX_COL];
        for(int i=0;i<MAX_ROW;i++){
            for(int j=0; j<MAX_COL;j++){
                this.board[i][j]=' ';
            }
        }
        this.player='X';
        this.computer='O';
        this.isOver=false;
        this.isEmpty=false;
    }

    public void setOnBoardX (int row, int col){
        if(this.board[row][col]==' ') {
            this.board[row][col] = this.player;
            this.isEmpty=false;
        }
    }

    public void setOnBoardO (){
        int count=0;
        if(count==COMPUTER_TURNS) {
            this.isOver=true;
            return;
        }
        while(isEmpty == false) {
            int row = (int)(Math.random()*MAX_ROW);
            int col = (int)(Math.random()*MAX_COL);
            if(this.board[row][col] == ' ') {
                this.board[row][col]=this.computer;
                count++;
                this.isEmpty=true;
            }
        }
    }

    public char isWinner() {
        char checks=' ';
        //checks Rows sequences
        for(int i=0; i<MAX_ROW; i++){
            if(this.board[i][0]==this.board[i][1] && this.board[i][0]==this.board[i][2]) {
                this.isOver = true;
                checks = this.board[i][0];
                return checks;
            }
        }
        //checks cols sequences
        for(int i=0; i<MAX_COL;i++) {
            if(this.board[0][i]==this.board[1][i]&&this.board[0][i]==this.board[2][i]) {
                this.isOver=true;
                checks=this.board[0][i];
                return checks;
            }
        }
        //checks left to right diagonal
        if(this.board[0][0]==this.board[1][1]&&this.board[0][0]==this.board[2][2]) {
            this.isOver=true;
            checks=this.board[0][0];
            return checks;
        }
        //checks right to left diagonal
        if(this.board[0][2]==this.board[1][1]&&this.board[0][2]==this.board[2][0]) {
            this.isOver=true;
            checks=this.board[0][2];
            return checks;
        }
        //checks moves left
        int count = 0;
        for (int i = 0; i < MAX_ROW; i++) {
            for (int j = 0; j < MAX_COL; j++) {
                if(board[i][j] != ' '){
                    count++;
                }
            }
        }
        if(count==9){
            return 'T';// T for tie
        }
        return ' ';
    }

    public void gameplay(int i, int j) {
        char check = isWinner();
        if(check == ' ') {
            setOnBoardX(i, j);
            check = isWinner();
            if(check == ' ') {
                setOnBoardO();
            }
        }
    }
}


