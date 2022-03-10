package client;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private final int $WIDTH;
    private final int $HEIGHT;
    private final String $TITLE;
    private boolean $isVisible;
    private Board board;

    public Window(int width, int height, String title, boolean visible, Player player){
        this.$WIDTH = width;
        this.$HEIGHT = height;
        this.$TITLE = title;
        this.$isVisible = visible;
        this.board = new Board(350, 350, player);
    }

    public void Draw(){
        setSize(this.$WIDTH, this.$HEIGHT);
        setTitle(this.$TITLE);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x =  (dim.width / 2 - getWidth() / 2);
        int y = (dim.height / 2 - getHeight() / 2);

        this.board.draw_board(this);

        setLayout(null);
        setLocation(x, y);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(this.$isVisible);
    }
}
