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

    public GameVisualizer(IMap2D map){
        AbstractMapElement.tileSize = 20;
        super.setFocusable(true);
        this.height=map.getUpperRight().y * AbstractMapElement.tileSize;
        this.width=map.getUpperRight().x * AbstractMapElement.tileSize;
        super.setPreferredSize(new Dimension(this.width,this.height));
        this.map = map;

        super.addKeyListener(this);
        start();
    }

    public void start(){
        this.running = true;
        this.thread = new Thread(this);
        this.thread.start();
    }

    public void stop(){
        this.running = false;
        try{
            thread.join();
        } catch (InterruptedException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    public void paint(Graphics graphics) {
        graphics.clearRect(0,0,this.width,this.height);
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,this.width,this.height);
        Map<Vector2D, IMapElement> objects = this.map.getObjects();
        for (IMapElement object : objects.values()) {
            object.draw(graphics);
            System.out.println(object);
        }
        System.out.println("---");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent pressedKey) {
        this.map.getSnake().changeDirection(pressedKey);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (this.running){
            this.map.tick();
            super.repaint();
        }
    }
}
