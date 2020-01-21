import javax.swing.*;

public class Visualizer {
    private JFrame window = new JFrame();
    private GameVisualizer gameVisualizer;

    public  Visualizer(int width, int height){
        this.gameVisualizer = new GameVisualizer(width,height);
        window.add(gameVisualizer);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Snake the game");
        window.setLocationRelativeTo(null);
        window.pack();
        window.setVisible(true);
    }
}
