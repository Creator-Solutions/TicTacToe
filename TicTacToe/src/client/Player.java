package client;

import javax.swing.*;
import java.util.Scanner;

public class Player {

    private String playerName;

    private String playerIP;
    private String element = "";
    Scanner input  = new Scanner(System.in);

    public Player(String element){
        playerName = input.next();
        this.element = element;
    }

    public String Get_Name(){
        return this.playerName;
    }

    public void Set_Winner(String name){
        this.playerWinnerName = name;
    }

    public String Get_Winner(){
        return this.playerWinnerName;
    }

    public String Get_El(){
        return this.element;
    }

    public void PlayerWon(JButton[] board) {
        if (board[0].getText() == "X" && board[1].getText() == "X" && board[2].getText() == "X") {
            Set_Winner(this.playerName);
        } else if (board[0].getText() == "X" && board[4].getText() == "X" && board[8].getText() == "X") {
            Set_Winner(this.playerName);
        } else if (board[0].getText() == "X" && board[2].getText() == "X" && board[6].getText() == "X") {
            Set_Winner(this.playerName);
        } else if (board[1].getText() == "X" && board[4].getText() == "X" && board[7].getText() == "X") {
            Set_Winner(this.playerName);
        } else if (board[1].getText() == "X" && board[4].getText() == "X" && board[7].getText() == "X") {
            Set_Winner(this.playerName);
        } else if (board[2].getText() == "X" && board[5].getText() == "X" && board[8].getText() == "X") {
            Set_Winner(this.playerName);
        } else if (board[3].getText() == "X" && board[4].getText() == "X" && board[5].getText() == "X") {
            Set_Winner(this.playerName);
        } else if (board[6].getText() == "X" && board[7].getText() == "X" && board[8].getText() == "X") {
            Set_Winner(this.playerName);
        }

        if (board[0].getText() == "O" && board[1].getText() == "O" && board[2].getText() == "O") {
            Set_Winner(this.playerName);
        } else if (board[0].getText() == "O" && board[4].getText() == "O" && board[8].getText() == "O") {
            Set_Winner(this.playerName);
        } else if (board[0].getText() == "O" && board[2].getText() == "O" && board[6].getText() == "O") {
            Set_Winner(this.playerName);
        } else if (board[1].getText() == "O" && board[4].getText() == "O" && board[7].getText() == "O") {
            Set_Winner(this.playerName);
        } else if (board[1].getText() == "O" && board[4].getText() == "O" && board[7].getText() == "O") {
            Set_Winner(this.playerName);
        } else if (board[2].getText() == "O" && board[5].getText() == "O" && board[8].getText() == "O") {
            Set_Winner(this.playerName);
        } else if (board[3].getText() == "O" && board[4].getText() == "O" && board[5].getText() == "O") {
            Set_Winner(this.playerName);
        } else if (board[6].getText() == "O" && board[7].getText() == "O" && board[8].getText() == "O") {
            Set_Winner(this.playerName);
        }
    }
}
