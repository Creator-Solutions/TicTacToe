package server;

import javax.swing.*;
import java.util.Map;


public class Player {

    //Class Reference
    public Game game;

    //Global Class Variables
    private String playerName;
    private String playerIP;
    private Map<Integer, Integer> boardSelections;

    private int playerScore;
    private String playerWinnerName = "";

    public Player(String playerName, String playerIP){
        /**
         * Player constructor
         * @params: String
         * @returns: None
         */
        this.playerName = playerName;
        this.playerIP = playerIP;
        this.playerScore = 0;
        this.game = null;
    }

    public void Set_Game(Game game){
        /**
         * Set a new game for each player
         * @params: game
         * @returns: None
         */
        this.game = game;
    }

    public String Get_PlayerName(){
        /**
         * Get player Name sent to server from client
         * @params: None
         * @returns: String
         */
        return this.playerName;
    }

    public String Get_PlayerIP(){
        /**
         * Returns each players IP
         * @params: None
         * @returns: String
         */
        return this.playerIP;
    }

    public int Get_Score(){
        /**
         * Returns each player's score
         * @params: None
         * @returns: int
         */
        return this.playerScore;
    }

    public void Update_Score(int x){
        /**
         * Returns the player score
         * @params: int
         * @returns: None
         */
        this.playerScore += x;
    }

    public void Disconnect(){
        //pass
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

    public void PlayerWon(JButton[] board){
        /**
         * Conditions Based on Selected indexes in the array
         * Winner is Selected based on conditions
         * @params: array
         * @returns: None
         */

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
