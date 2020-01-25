import javax.accessibility.AccessibleComponent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private GameVisualizer gameVisualizer;
    private JButton startButton = new JButton("START!");;
    private JButton resetButton = new JButton("RESET");
    private JButton scoreText = new JButton();
    private JButton gameOverText = new JButton("GAME OVER!");
    private JTextArea decoy = new JTextArea();

    public Menu(GameVisualizer gameVisualizer){
        this.gameVisualizer = gameVisualizer;
        this.scoreText.setVisible(false);
        this.setupButton(scoreText,100,0);
        this.setupButton(this.startButton,0,0);
        this.setupButton(this.resetButton,0,0);
        this.setupButton(gameOverText,150,20);
        this.gameOverText.setVisible(false);
        this.decoy.setVisible(false);
        this.resetButton.setVisible(false);
        this.startButton.setVisible(true);
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
                scoreText.setVisible(false);
                gameOverText.setVisible(false);
            }
        });

    }

    public JButton getResetButton(){
        return this.resetButton;
    }

    public JButton getScoreText(){
        return this.scoreText;
    }
    public JButton getGameOverText(){
        return this.gameOverText;
    }

    public JButton getStartButton(){
        return this.startButton;
    }

    public void startTheGame(){
        this.gameVisualizer.start();
    }

    public void setupButton(JButton button, int yOffset, int xOffset){
        Vector2D frameBoundaries = this.gameVisualizer.getMap().getUpperRight();
        button.setBounds(AbstractMapElement.tileSize * frameBoundaries.x/2 - 50 - xOffset,AbstractMapElement.tileSize * frameBoundaries.y/2 - 25 - yOffset,100 + 2*xOffset,50);
    }

    public void resetTheGame(){
        this.gameVisualizer.resetGame();
    }


    public JTextArea getDecoy() {
        return this.decoy;
    }
}
