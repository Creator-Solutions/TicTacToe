package server;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private ArrayList<Player> connection_queue;
    private int gameID;
    private Game game;
    private final int PLAYERS = 2;

    public Server(){
        this.connection_queue = new ArrayList<>();
        this.gameID = 0;
    }

    public void Handle_queue(Player player){
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
        String server = "";
        int port = 8081;

        ServerSocket serverSocket;
        Socket sock;
        try {

            serverSocket = new ServerSocket(port);

            while (true) {
                sock = serverSocket.accept();

                DataInputStream stream = new DataInputStream(sock.getInputStream());
                String str = (String)stream.readUTF();

                Player player = new Player(str, "127.0.0.1");
                Handle_queue(player);
                System.out.println(str + " Connected To The Server");


                if (this.connection_queue.size() == this.PLAYERS){
                    for (Player connPlayer : this.connection_queue){
                        System.out.println("Player ["+this.connection_queue.indexOf(connPlayer)+"]: " + connPlayer.Get_PlayerName());
                    }
                }

                //
            }

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        Server s = new Server();
        s.Connection_Thread();
    }
}
