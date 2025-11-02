package uppgift_3;

import javax.swing.*;
import java.awt.*;

public class GameBase extends JFrame {

    JPanel base = new JPanel(new BorderLayout());
    JPanel gamePanel = new JPanel(new GridLayout(4,4));
    JPanel sidebar = new JPanel(new GridLayout(3,1));
    JPanel bottomPanel = new JPanel(new FlowLayout());

    JButton newGame = new JButton("New Game");
    JButton autoWin = new JButton("Auto Win");

    JLabel winText = new JLabel(" ");
}
