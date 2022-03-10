package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener{

    public JButton[] bton = new JButton[9];

    private final int $WIDTH;
    private final int $HEIGHT;
    Player player;

    public Board(int width, int height, Player player){
        this.$WIDTH = width;
        this.$HEIGHT = height;
        this.player = player;
    }

    public void draw_board(JFrame window){
        setSize(this.$WIDTH, this.$HEIGHT);

        int x = (window.getWidth() / 2 - getWidth() / 2);
        int y = (window.getHeight() / 2 - getHeight() / 2);

        setLocation(new Point(x, y));
        setLayout(new GridLayout(3, 3));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        draw_grid();
        window.add(this);
    }

    public void draw_grid(){
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
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == bton[i]) {
                bton[i].setText(this.player.Get_El());
            }
        }
    }
}
