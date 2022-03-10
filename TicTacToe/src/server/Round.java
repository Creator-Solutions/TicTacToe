package server;

import java.util.ArrayList;

public class Round {

    //Class References
    private Chat chat;
    private Game game;

    //Global Class Variables
    private String element;
    private String playerStart;
    private int skips;
    private ArrayList<Integer> player_score;
    private int time;
    Player player;
    public ArrayList<Player> players_skipped;

    public Round(String element, Player player, Game game){
        /**
         * Class Constructor
         * @params: String, player, game
         * @returns: None
         */
        this.element = element;
        this.player = player;
        this.game = game;
        this.time = 75;
        this.players_skipped = new ArrayList<>();
        this.player_score.forEach(score -> this.player_score.add(score)); // Load each players score into array
    }

    public boolean Skip(Player player){
        /**
         * Handles all skip request done by clients
         * @params: player
         * @returns: bool
         */
        if (!players_skipped.contains(player)){
            this.players_skipped.add(player);
            this.skips += 1;
            this.chat.Update_Chat("Player has voted to skip " + (this.skips/this.game.players.size() - 2));
            if (this.skips >= this.game.players.size() - 2){
                return true;
            }
        }

        return false;
    }

    public int Get_Scores(){
        /**
         * Get all player's scores for current round
         * @params: None
         * @return: int
         */
       for (int i=0; i < this.player_score.size(); ++i){
            return this.player_score.get(i);
       }
       return 0;
    }

    public int Get_Score(Player player){
        /**
         * Return each player's individual score
         * @params: PLayer
         * @returns: int
         */
        if (this.game.players.contains(player)){
            return this.player_score.indexOf(player);
        }else{
            new Exception("Player not in score list");
        }

        return 0;
    }

    public void Time_Thread(){
        /**
         * Handles each countdown of current round
         */
        try{
            while (this.time > 0){
                Thread.sleep(1);
                this.time -= 1;
            }

            this.End_Round("Time is up");

        }catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }

    }

    public void Player_Wins(Board board){
        /**
         * Conditions Based on Selected indexes in the array
         * Winner is Selected based on conditions
         * @params: array
         * @returns: None
         */

        if (board.bton[0].getText() == "X" && board.bton[1].getText() == "X" && board.bton[2].getText() == "X") {
            this.player.Set_Winner(player.Get_PlayerName());
        } else if (board.bton[0].getText() == "X" && board.bton[4].getText() == "X" && board.bton[8].getText() == "X") {
            this.player.Set_Winner(player.Get_PlayerName());
        } else if (board.bton[0].getText() == "X" && board.bton[2].getText() == "X" && board.bton[6].getText() == "X") {
            this.player.Set_Winner(player.Get_PlayerName());
        } else if (board.bton[1].getText() == "X" && board.bton[4].getText() == "X" && board.bton[7].getText() == "X") {
            this.player.Set_Winner(player.Get_PlayerName());
        } else if (board.bton[1].getText() == "X" && board.bton[4].getText() == "X" && board.bton[7].getText() == "X") {
            this.player.Set_Winner(player.Get_PlayerName());
        } else if (board.bton[2].getText() == "X" && board.bton[5].getText() == "X" && board.bton[8].getText() == "X") {
            this.player.Set_Winner(player.Get_PlayerName());
        } else if (board.bton[3].getText() == "X" && board.bton[4].getText() == "X" && board.bton[5].getText() == "X") {
            this.player.Set_Winner(player.Get_PlayerName());
        } else if (board.bton[6].getText() == "X" && board.bton[7].getText() == "X" && board.bton[8].getText() == "X") {
            this.player.Set_Winner(player.Get_PlayerName());
        }

        if (board.bton[0].getText() == "O" && board.bton[1].getText() == "O" && board.bton[2].getText() == "O") {
            this.player.Set_Winner(player.Get_PlayerName());
        } else if (board.bton[0].getText() == "O" && board.bton[4].getText() == "O" && board.bton[8].getText() == "O") {
            this.player.Set_Winner(player.Get_PlayerName());
        } else if (board.bton[0].getText() == "O" && board.bton[2].getText() == "O" && board.bton[6].getText() == "O") {
            this.player.Set_Winner(player.Get_PlayerName());
        } else if (board.bton[1].getText() == "O" && board.bton[4].getText() == "O" && board.bton[7].getText() == "O") {
            this.player.Set_Winner(player.Get_PlayerName());
        } else if (board.bton[1].getText() == "O" && board.bton[4].getText() == "O" && board.bton[7].getText() == "O") {
            this.player.Set_Winner(player.Get_PlayerName());
        } else if (board.bton[2].getText() == "O" && board.bton[5].getText() == "O" && board.bton[8].getText() == "O") {
            this.player.Set_Winner(player.Get_PlayerName());
        } else if (board.bton[3].getText() == "O" && board.bton[4].getText() == "O" && board.bton[5].getText() == "O") {
            this.player.Set_Winner(player.Get_PlayerName());
        } else if (board.bton[6].getText() == "O" && board.bton[7].getText() == "O" && board.bton[8].getText() == "O") {
            this.player.Set_Winner(player.Get_PlayerName());
        }
    }

    public void Player_Left(Player player){
        /**
         * Handles if a player leaves the game
         * Game ends: Players: 1/2
         * @params: player
         * @returns: None
         */
        if (this.game.players.contains(player)){
            this.game.players.remove(player);
        }

        if (this.players_skipped.contains(player)){
            this.players_skipped.remove(player);
        }

        if (this.game.players.size() != 2){
            this.game.End_Game();
        }
    }

    public String End_Round(String msg){
        /**
         * End Round if countdown reaches 0
         * @params: String
         * @returns: String
         */
        for (Player player:this.game.players) {
            if (this.player_score.contains(player)){
                player.Update_Score(this.player_score.indexOf(player));
            }
        }
        return msg;
    }
}
