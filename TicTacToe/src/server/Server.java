package server;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    //Class Score Variables
    private ArrayList<Player> connection_queue;
    private int gameID;
    private final int PLAYERS = 2;

    //Class Reference
    private Game game;


    public Server(){
        /**
         * Class Constructor -> creates empty queue on execution
         * @params: None
         * @returns: None
         */
        this.connection_queue = new ArrayList<>();
        this.gameID = 0;
    }

    public void Handle_queue(Player player){
        /**
         * Handles player queue -> set new game for each player
         * Set new game id for each game
         * @params: player
         * @returns: None
         */
        this.connection_queue.add(player);

        if (this.connection_queue.size() == this.PLAYERS){
            this.game = new Game(gameID, this.connection_queue);

            for (Player players : game.players){
                players.Set_Game(game);
            }

            this.game.Set_Game_ID(1);
          //  this.connection_queue.removeAll(this.connection_queue);
            System.out.println("Game " + this.game.Get_Game_ID() + " has Started");
        }

    }

    public void Connection_Thread(){
        /**
         * Handles incoming connections and data
         * @params: None
         * @returns: None
         */

        //Set server host and port
        String server = "localhost";
        int port = 8081;

        // Declare a new server instance
        ServerSocket serverSocket;
        Socket sock; //Declare a new Socket instance
        try {

            //Creates a new server socket with port binded
            serverSocket = new ServerSocket(port);

            while (true) {
                //Accept incoming request from client side
                sock = serverSocket.accept();

                //Read incoming data from client
                DataInputStream stream = new DataInputStream(sock.getInputStream());
                String str = (String)stream.readUTF(); //Convert to String

                //Create a new server/Player object
                Player player = new Player(str, "127.0.0.1");
                Handle_queue(player); //Add players to queue
                System.out.println(str + " Connected To The Server");

                //Return all players in queue if sized maxed out
                if (this.connection_queue.size() == this.PLAYERS){
                    for (Player connPlayer : this.connection_queue){
                        System.out.println("Player ["+this.connection_queue.indexOf(connPlayer)+"]: " + connPlayer.Get_PlayerName());
                    }
                }

                //
            }

        }catch (Exception e) {
            System.out.println(e.getMessage()); //print exception thrown
        }
    }

    public static void main(String[] args){
        /**
         * Main method to execute the server
         */
        Server s = new Server();
        s.Connection_Thread();
    }
}
