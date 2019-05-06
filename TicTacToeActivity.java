package com.almogharel.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TicTacToeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button [][] board;
    private Button resetbutt;
    private TicTacToeGame game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        game = new TicTacToeGame();
        board = new Button[3][3];
        board[0][0]= (Button) findViewById(R.id.butt00);
        board[0][1]= (Button) findViewById(R.id.butt01);
        board[0][2]= (Button) findViewById(R.id.butt02);
        board[1][0]= (Button) findViewById(R.id.butt10);
        board[1][1]= (Button) findViewById(R.id.butt11);
        board[1][2]= (Button) findViewById(R.id.butt12);
        board[2][0]= (Button) findViewById(R.id.butt20);
        board[2][1]= (Button) findViewById(R.id.butt21);
        board[2][2]= (Button) findViewById(R.id.butt22);
        resetbutt = (Button) findViewById(R.id.resetbutt);

        board[0][0].setOnClickListener(this);
        board[0][1].setOnClickListener(this);
        board[0][2].setOnClickListener(this);
        board[1][0].setOnClickListener(this);
        board[1][1].setOnClickListener(this);
        board[1][2].setOnClickListener(this);
        board[2][0].setOnClickListener(this);
        board[2][1].setOnClickListener(this);
        board[2][2].setOnClickListener(this);
        resetbutt.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.butt00:
                gameAllMove(0,0);
                break;
            case R.id.butt01:
                gameAllMove(0,1);
                break;
            case R.id.butt02:
                gameAllMove(0,2);
                break;
            case R.id.butt10:
                gameAllMove(1,0);
                break;
            case R.id.butt11:
                gameAllMove(1,1);
                break;
            case R.id.butt12:
                gameAllMove(1,2);
                break;
            case R.id.butt20:
                gameAllMove(2,0);
                break;
            case R.id.butt21:
                gameAllMove(2,1);
                break;
            case R.id.butt22:
                gameAllMove(2,2);
                break;

            case R.id.resetbutt:
                game = new TicTacToeGame();
                board[0][0].setText("");
                board[0][1].setText("");
                board[0][2].setText("");
                board[1][0].setText("");
                board[1][1].setText("");
                board[1][2].setText("");
                board[2][0].setText("");
                board[2][1].setText("");
                board[2][2].setText("");
                break;
        }

    }

    private void toastMassege(){
     char winner = game.isWinner();
     if(winner=='T'){
         Toast.makeText(TicTacToeActivity.this,"It's a TIE!",Toast.LENGTH_LONG).show();
     }
     else{
         Toast.makeText(TicTacToeActivity.this,"The winner is "+winner+"!",Toast.LENGTH_LONG).show();
     }
    }
//the following connect between the java class logic to this activity
    private void gameAllMove(int i, int j){
        if(board[i][j].getText().toString().equals("")) {
            board[i][j].setText("X");
            game.gameplay(i, j);
            for (int k = 0; k <3 ; k++) {
                for (int l = 0; l < 3; l++) {
                    if(game.board[k][l] =='O' && !(board[k][l].getText().toString().equals("O"))){
                        board[k][l].setText("O");
                        break;
                    }
                }
            }
        }
        if(game.isWinner()!=' '){
            toastMassege();
        }
    }
}

