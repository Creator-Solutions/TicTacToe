package client;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    //Constant Variables -> Value do not change
    private final int $WIDTH;
    private final int $HEIGHT;
    private final String $TITLE;
    private boolean $isVisible;

    private Board board; // References Board

    public Window(int width, int height, String title, boolean visible, Player player){
        /**
         * Window constructor -> Class extends JFrame
         * @params: int, String, bool, Player
         * @returns: None
         */
        this.$WIDTH = width;
        this.$HEIGHT = height;
        this.$TITLE = title;
        this.$isVisible = visible;
        this.board = new Board(350, 350, player);
    }

    public void Draw(){
        /**
         * Create a Window instance -> JFrame Window
         * @params: None
         * @returns: Extended Class -> No return
        **/

        setSize(this.$WIDTH, this.$HEIGHT); //Set window size
        setTitle(this.$TITLE); //Set Window Title

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); //Get Display Resolution: *1920x1080*
        int x =  (dim.width / 2 - getWidth() / 2); //set x-axis Value based on screen dimension width
        int y = (dim.height / 2 - getHeight() / 2); //set y value based on screen dimension height

        this.board.draw_board(this); //Draw a board on each new Window instance

        setLayout(null); //set layout to null -> manual positioning
        setLocation(x, y); //set Window location relative to x and y coordinates
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Stop all executions when window closes
        setVisible(this.$isVisible); //set visiblity of window
    }
}
