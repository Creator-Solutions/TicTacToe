# Tic Tac Toe Java Edition

<img alt="GitHub repo size" src="https://img.shields.io/github/repo-size/Creator-Solutions/TicTacToe?style=flat-square"> ![GitHub](https://img.shields.io/github/license/Creator-Solutions/TicTacToe) ![GitHub all releases](https://img.shields.io/github/downloads/Creator-Solutions/TicTacToe/total)

## Official Repo For GUI Based Tic Tac Toe Game

My first big project I took on. Although not finished 

### Project Information
-----

> Java JDK Version: JDK 17 <br>
> Project Size: 24.0KB


### How to run the project:
-----

- [x] Create a clone of the repository.
- [x] Open the project in any IDE of your Choice (As long as it can compile and run Java).
- [x] Make sure your configuration allows for multiple instances.
- [x] Open The Server.java file and execute it.
- [x] Open 2 or More Main.java files located in the client package. 
- [x] Execute The +2 Main.java file.

### Main.java File - multiple instances
```java
package client;

public class Main {

    public static void main(String[] args){
        Client client = new Client();
        client.Client_Connect();
    }
}
```

### Server.java - Single instance only
```java
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
```


- [ ] To Work on the project open a Pull Request.

## This project is open source! 

Copyright © 2022, Creator-Solutions. Released under the GPL License.







