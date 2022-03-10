package server;

import java.util.ArrayList;

public class Game {

    /**
     * Main Game Class
     * Handles all other interconnect classes -> server side
     *
     */

    //Global Class Variables
    private String playerIP;
    private int id;
    public ArrayList<Player> players;
    private Player player;
    private int player_turn_ind = 0;

    //Class Refernces
    private Board board;
    private Round round;

    public Game(int id, ArrayList<Player> player){
        /**
         * Class Constructor
         * @params: int, player[]
         * @returns: None
         */
        this.id = id;
        this.players = player;
    }

    public void Set_Game_ID(int id) {
        /**
         * Set a new Game ID
         * @params: int
         * @returns: None
         */
        this.id += id;
    }

    public int Get_Game_ID(){
        /**
         * Return the set Game ID
         * @params: None
         * @returns: int
         */
        return this.id;
    }

    public void Start_Round(){
        //pass
    }

    public void Player_Choice(){
        //pass
    }

    public void Player_Disconnect(){
        //pass
    }

    public void Skip(){
        //pass
    }

    public void Round_Ended(){
        //pass
    }

    public void Update_Board(){
        //pass
    }

    public void End_Game(){
        /**
         * End the game -> Disconnect players -> Exit Windows
         * @params: None
         * @returns: None
         */
        System.out.println("Game has ended!");
        for (Player player: this.players){
            player.game = null; // Set Game to null
        }
    }

}
