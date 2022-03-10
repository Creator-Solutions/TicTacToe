package server;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    /**
     * Server side board class
     * Handles updating
     * Clearing
     */
    private final int $WIDTH = 350;
    private final int $HEIGHT = 350;

    public JButton[] bton = new JButton[9];

    JButton[] data;

    public Board(){
        this.data = create_empty_board();
    }

    public JButton[] create_empty_board(){
        for (int i=0; i < 9; i++){
            bton[i] = new JButton();
            bton[i].setFont(new Font("Ink Free", Font.BOLD, 72));
            bton[i].setFocusable(false);
        }

        return bton;
    }

    public JButton[] Get_Board(){
        return this.data;
    }

}
