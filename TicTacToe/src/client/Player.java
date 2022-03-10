package client;

import javax.swing.*;
import java.util.Scanner;

public class Player {

    // Player class variables
    private String playerName;
    private String playerWinnerName = "";
    private String playerIP;
    private String element = "";
    Scanner input  = new Scanner(System.in);

    public Player(String element){
        /**
         * Player class constructor
         * @params: String
         * @returns: None
         */
        playerName = input.next(); //Get user Input from console -> assign to name
        this.element = element;
    }

    public String Get_Name(){
        /**
         * Get the player's name
         * @params: none
         * @returns: String
         */
        return this.playerName;
    }

    public void Set_Winner(String name){
        /**
         * Set the winner of the current round -> set in Round
         * @params: String
         * @returns: None
         */
        this.playerWinnerName = name;
    }

    public String Get_Winner(){
        /**
         * Return the winner name
         * @params: None
         * @returns: None
         */
        return this.playerWinnerName;
    }

    public String Get_El(){
        /**
         * Returns X/O retrieved from Player
         * @params: None
         * @returns: String
         **/
        return this.element;
    }

    public void PlayerWon(JButton[] board) {
        /**
         * Conditions Based on Selected indexes in the array
         * Winner is Selected based on conditions
         * @params: array
         * @returns: None
         */
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
