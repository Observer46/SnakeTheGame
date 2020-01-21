import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

public class GameVisualizer extends JPanel implements Runnable, KeyListener {
    private int height;
    private int width;
    private IMap2D map;
    private boolean running;
    private Thread thread;

    public GameVisualizer(int width, int height){
        super.setFocusable(true);
        super.setPreferredSize(new Dimension(width,height));
        this.height=height;
        this.width=width;
        super.addKeyListener(this);

        start();
    }

    public void start(){
        this.running = true;
    }

    public void stop(){
        this.running = false;
    }

    public void paint(Graphics graphics) { // Sypie błędami bruh
        Map<Vector2D, IMapElement> objects = this.map.getObjects();
        for (IMapElement object : objects.values())
            object.draw(graphics);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {

    }
}
