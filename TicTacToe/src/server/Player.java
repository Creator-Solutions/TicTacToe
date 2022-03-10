package server;

import javax.swing.*;
import java.util.Map;


public class Player {

    public Game game;

    private String playerName;
    private String playerIP;
    private Map<Integer, Integer> boardSelections;

    private int playerScore;
    private String playerWinnerName = "";

    public Player(String playerName, String playerIP){
        this.playerName = playerName;
        this.playerIP = playerIP;
        this.playerScore = 0;
        this.game = null;
    }

    public void Set_Game(Game game){
        this.game = game;
    }

    public String Get_PlayerName(){
        return this.playerName;
    }

    public String Get_PlayerIP(){
        return this.playerIP;
    }

    public int Get_Score(){
        return this.playerScore;
    }

    public void Update_Score(int x){
        this.playerScore += x;
    }

    public void Disconnect(){

    }

    public void Set_Winner(String name){
        this.playerWinnerName = name;
    }

    public String Get_Winner(){
        return this.playerWinnerName;
    }

    public void PlayerWon(JButton[] board){
        if (board[0].getText() == "X" && board[1].getText() == "X" && board[2].getText() == "X"){
            System.out.println(this.playerName + " Won the game!");
        }else if (board[0].getText() == "X" && board[4].getText() == "X" && board[8].getText() == "X"){
            System.out.println(this.playerName + " Won the game!");
        }else if (board[0].getText() == "X" && board[2].getText() == "X" && board[6].getText() == "X") {
            System.out.println(this.playerName + " Won the game!");
        }else if (board[1].getText() == "X" && board[4].getText() == "X" && board[7].getText() == "X"){
            System.out.println(this.playerName + " Won the game!");
        }else if (board[1].getText() == "X" && board[4].getText() == "X" && board[7].getText() == "X"){
            System.out.println(this.playerName + " Won the game!");
        }else if (board[2].getText() == "X" && board[5].getText() == "X" && board[8].getText() == "X"){
            System.out.println(this.playerName + " Won the game!");
        }else if (board[3].getText() == "X" && board[4].getText() == "X" && board[5].getText() == "X"){
            System.out.println(this.playerName + " Won the game!");
        }else if (board[6].getText() == "X" && board[7].getText() == "X" && board[8].getText() == "X"){
            System.out.println(this.playerName + " Won the game!");
        }

        if (board[0].getText() == "O" && board[1].getText() == "O" && board[2].getText() == "O"){
            System.out.println(this.playerName + " Won the game!");
        }else if (board[0].getText() == "O" && board[4].getText() == "O" && board[8].getText() == "O"){
            System.out.println(this.playerName + " Won the game!");
        }else if (board[0].getText() == "O" && board[2].getText() == "O" && board[6].getText() == "O") {
            System.out.println(this.playerName + " Won the game!");
        }else if (board[1].getText() == "O" && board[4].getText() == "O" && board[7].getText() == "O"){
            System.out.println(this.playerName + " Won the game!");
        }else if (board[1].getText() == "O" && board[4].getText() == "O" && board[7].getText() == "O"){
            System.out.println(this.playerName + " Won the game!");
        }else if (board[2].getText() == "O" && board[5].getText() == "O" && board[8].getText() == "O"){
            System.out.println(this.playerName + " Won the game!");
        }else if (board[3].getText() == "O" && board[4].getText() == "O" && board[5].getText() == "O"){
            System.out.println(this.playerName + " Won the game!");
        }else if (board[6].getText() == "O" && board[7].getText() == "O" && board[8].getText() == "O"){
            System.out.println(this.playerName + " Won the game!");
        }
    }
}
