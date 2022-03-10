package server;

import java.util.ArrayList;

public class Game {

    private String playerIP;
    private int id;
    public ArrayList<Player> players;
    private Player player;
    private int player_turn_ind = 0;

    private Board board;
    private Round round;

    public Game(int id, ArrayList<Player> player){
        this.id = id;
        this.players = player;
    }

    public void Set_Game_ID(int id) {
        this.id += id;
    }

    public int Get_Game_ID(){
        return this.id;
    }

    public void Start_Round(){

    }

    public void Player_Choice(){

    }

    public void Player_Disconnect(){

    }

    public void Skip(){

    }

    public void Round_Ended(){

    }

    public void Update_Board(){

    }

    public void End_Game(){
        System.out.println("Game has ended!");
        for (Player player: this.players){
            player.game = null;
        }
    }

}
