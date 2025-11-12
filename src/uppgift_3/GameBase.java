package uppgift_3;

import javax.swing.*;
import java.awt.*;

public class GameBase extends JFrame {

    GameLogic logic = new GameLogic();

    JPanel base = new JPanel(new BorderLayout());
    JPanel gamePanel = new JPanel(new GridLayout(4,4));
    JPanel sidebar = new JPanel(new GridLayout(3,1));
    JLabel moveCounter = new JLabel();

    JButton newGame = new JButton("New Game");
    JButton autoWin = new JButton("Auto Win");
    Font textFont = new Font("Arial", Font.BOLD, 15);

    ImageIcon img = new ImageIcon("src/uppgift_3/xv_logo.jpg");

    public GameBase(){

        super.setTitle("Gabriels 15-Game!");
        super.setIconImage(img.getImage());
        this.add(base);
        base.add(gamePanel,BorderLayout.CENTER);
        base.add(sidebar, BorderLayout.EAST);
        gamePanel.setBackground(Color.BLACK);
        sidebar.setBackground(Color.BLACK);

        sidebar.add(newGame);
        sidebar.add(autoWin);
        sidebar.add(moveCounter);

        newGame.setFont(textFont);
        autoWin.setFont(textFont);
        newGame.setBackground(Color.GREEN);
        newGame.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        autoWin.setBackground(Color.RED);
        autoWin.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        moveCounter.setForeground(Color.CYAN);

        logic.newGame(gamePanel, moveCounter);

        newGame.addActionListener(e -> {
            logic.newGame(gamePanel, moveCounter);
            revalidate();
            repaint();
        });
        autoWin.addActionListener(e -> {
            logic.autoWin();
            revalidate();
            repaint();
        });

        setSize(500,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    static void main() {
        GameBase run = new GameBase();
    }
}
