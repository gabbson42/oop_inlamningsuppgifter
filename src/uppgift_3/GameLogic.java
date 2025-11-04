package uppgift_3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameLogic extends JFrame implements ActionListener {

    private List<JButton> buttons = new ArrayList<>();
    private List<Integer> numbers = new ArrayList<>();
    private int rows = 4;
    private int cols = 4;


    private void createNumbersAndButtons(){
        for(int i = 0; i <= 15; i++){
            this.numbers.add(i);
            this.buttons.add(new JButton());
        }
    }

    private void pasteNumbers(){
        for(int i = 0; i <= 15; i++){
            int number = numbers.get(i);
            JButton button = buttons.get(i);
            if(number != 0) {
                button.setText(String.valueOf(numbers.get(i)));
            }
            else{
                button.setText("");
            }
            button.setVisible(!button.getText().isBlank());
        }
    }

    private void pasteButtons(JPanel panel){
        for(JButton button : buttons){
            panel.add(button);
        }
    }

    public void newGame(JPanel panel){
        if(numbers.isEmpty() || buttons.isEmpty()) {
            createNumbersAndButtons();
        }
        Collections.shuffle(numbers);
        pasteNumbers();
        if(!panel.contains(rows,cols)) {
            pasteButtons(panel);
        }
    }

    public void autoWin(JPanel panel){
        Collections.sort(numbers);
        pasteNumbers();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
