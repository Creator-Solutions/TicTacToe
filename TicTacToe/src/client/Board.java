package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener{

    //JButtons array -> Board
    public JButton[] bton = new JButton[9];

    // Board Width and Height
    private final int $WIDTH;
    private final int $HEIGHT;
    Player player; //client/Player class Reference

    public Board(int width, int height, Player player){
        /**
         * Board Constructor
         * @params: int, player
         * @returns: none
         */
        this.$WIDTH = width;
        this.$HEIGHT = height;
        this.player = player;
    }

    public void draw_board(JFrame window){
        /**
         * Draw outer board Frame
         * @params: Window
         * @returns: none
         */

        setSize(this.$WIDTH, this.$HEIGHT); //Set board size

        // Center board on frame
        int x = (window.getWidth() / 2 - getWidth() / 2); //x-axis Location
        int y = (window.getHeight() / 2 - getHeight() / 2); //y-axis Location
        setLocation(new Point(x, y)); //set new Location

        //Outer Board Layout -> 3x3 Grid
        setLayout(new GridLayout(3, 3));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        draw_grid(); // Internal Method Call
        window.add(this); //Draw Outer Board to JFrame
    }

    public void draw_grid(){
        /**
         * Draw an empty 3x3 Grid
         * @params: None
         * @returns: None
         */
        for (int i=0; i < 9; i++){
            bton[i] = new JButton();

            bton[i].setFont(new Font("Ink Free", Font.BOLD, 72));
            bton[i].setFocusable(false);
            bton[i].addActionListener(this);
            add(bton[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        /**
         * On Click Event for each button(Cell) in Grid
         */
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == bton[i]) { // Get index of JButton array that was pressed
                bton[i].setText(this.player.Get_El()); // Set O/X -> Player Given
            }
        }
    }
}
