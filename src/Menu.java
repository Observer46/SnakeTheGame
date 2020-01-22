import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private GameVisualizer gameVisualizer;
    private JButton startButton = new JButton("START!");;
    private JButton resetButton = new JButton("RESET");

    public Menu(GameVisualizer gameVisualizer){
        this.gameVisualizer=gameVisualizer;
        this.setupButton(this.startButton);
        this.setupButton(this.resetButton);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                startTheGame();
                startButton.setVisible(false);
            }
        });
        this.startButton.setVisible(true);

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                resetTheGame();
                resetButton.setVisible(false);
            }
        });

    }

    public JButton getResetButton(){
        return this.resetButton;
    }


    public JButton getStartButton(){
        return this.startButton;
    }

    public void startTheGame(){
        this.gameVisualizer.start();
    }

    public void setupButton(JButton button){
        Vector2D frameBoundaries = this.gameVisualizer.getMap().getUpperRight();
        button.setBounds(AbstractMapElement.tileSize*frameBoundaries.x/2-50,AbstractMapElement.tileSize*frameBoundaries.y/2 - 25,100,50);
    }

    public void resetTheGame(){
        this.gameVisualizer.resetGame();
    }


}
