package uppgift_3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameBase extends JFrame {

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

        List<JButton> buttons = new ArrayList<>();
        for(int i = 1; i <= 15; i++){
            buttons.add(new JButton(String.valueOf(i)));
        }
        buttons.add(new JButton(""));

        Collections.shuffle(buttons);

        for(JButton button : buttons ){
            gamePanel.add(button);
        }

        bottomPanel.add(winText);

        setSize(500,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
