import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Visualizer {
    private JFrame window = new JFrame();
    private GameVisualizer gameVisualizer;
    private Menu menu;

    public  Visualizer(IMap2D map){
        this.window.setResizable(false);
        this.gameVisualizer = new GameVisualizer(map);
        this.window.add(gameVisualizer);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setTitle("Snake the game");
        this.window.setLocationRelativeTo(null);
        this.window.pack();
        this.window.setVisible(true);
        this.menu = new Menu(gameVisualizer);
        this.gameVisualizer.setMenu(this.menu);
        this.window.add(this.menu.getStartButton());
        this.window.add(this.menu.getResetButton());
        this.window.add(this.menu.getScoreText());
        this.window.add(this.menu.getGameOverText());
        this.window.add(this.menu.getDecoy());



    }
}
