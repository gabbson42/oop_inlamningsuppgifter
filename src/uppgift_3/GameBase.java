package uppgift_3;

import javax.swing.*;
import java.awt.*;

public class GameBase extends JFrame {

    GameLogic logic = new GameLogic();

    JPanel base = new JPanel(new BorderLayout());
    JPanel gamePanel = new JPanel(new GridLayout(4,4));
    JPanel sidebar = new JPanel(new GridLayout(3,1));
    JPanel bottomPanel = new JPanel(new FlowLayout());

    JButton newGame = new JButton("New Game");
    JButton autoWin = new JButton("Auto Win");

    JLabel winText = new JLabel(" ");

    public GameBase(){

        this.add(base);
        base.add(gamePanel,BorderLayout.CENTER);
        base.add(sidebar, BorderLayout.EAST);
        base.add(bottomPanel, BorderLayout.SOUTH);

        sidebar.add(newGame);
        sidebar.add(autoWin);

        logic.newGame(gamePanel);

        bottomPanel.add(winText);

        newGame.addActionListener(e -> {
            logic.newGame(gamePanel);
            revalidate();
            repaint();
        });
        autoWin.addActionListener(e -> {
            logic.autoWin(gamePanel);
            revalidate();
            repaint();
        });

        setSize(500,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
