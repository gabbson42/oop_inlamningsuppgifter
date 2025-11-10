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
        for(int i = 0; i <= rows * cols - 1; i++){
            JButton button = new JButton();
            this.numbers.add(i);
            this.buttons.add(button);
            button.addActionListener(this);
            button.setActionCommand(String.valueOf(i));
        }
    }

    private void pasteNumbers(){
        for(int i = 0; i <= rows * cols - 1; i++){
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
        if(!panel.contains(rows,cols)) {
            pasteButtons(panel);
        }
        Collections.shuffle(numbers);
        pasteNumbers();

    }

    public void autoWin(JPanel panel){
        Collections.sort(numbers);
        Collections.rotate(numbers, -1);
        pasteNumbers();
    }

    public void swapNumbers(int num1, int num2){
        Collections.swap(numbers,num1, num2);
    }

    public void winCondition(){
        boolean isSorted = false;
        for (int i = 0; i < numbers.size()-1; i++) {
            if(numbers.get(i) == i+1){
                isSorted = true;
            }
            else{
                isSorted = false;
                break;
            }
        }
        if(isSorted && numbers.getLast() == 0){
            JOptionPane.showMessageDialog(null,"Congratulations, you win!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        int commandIndex = Integer.parseInt(command);
        int indexOfZero = numbers.indexOf(0);

        boolean swapped = false;

        if(commandIndex == indexOfZero - 1 && !(indexOfZero % cols == 0)){
            swapped = true;
        }
        if(commandIndex == indexOfZero + 1 && !(indexOfZero % cols == cols - 1)){
            swapped = true;
        }
        if(commandIndex == indexOfZero + cols && !(indexOfZero >= cols * (rows - 1))){
            swapped = true;
        }
        if(commandIndex == indexOfZero - cols && !(indexOfZero < cols)){
            swapped = true;
        }
        if(swapped){
            swapNumbers(commandIndex, indexOfZero);
            pasteNumbers();
        }
        winCondition();
    }
}
