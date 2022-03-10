package client;

import javax.swing.*;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {

    static Window window; // Reference to Window class

    public void Client_Connect(){
        try {
            Socket socket = new Socket("localhost", 8081); // Create a new Socket

            //Stream to send data to server side
            DataOutputStream Dout = new DataOutputStream(socket.getOutputStream());

            Player player = new Player("X"); // Create a new player instance
            //Send player name to server
            Dout.writeUTF(player.Get_Name());

            //Create Main Window
            window = new Window(1280, 720, "Multiplayer Tic Tac Toe", true, player);
            window.Draw();

            Dout.flush();
            Dout.close();

        }catch (Exception e) {
            System.out.println("[Error Occurred]:" + e.getMessage()); //Show Exceptions Caught
        }
    }

}
