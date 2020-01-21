import java.awt.*;

public class Obstacle extends AbstractMapElement{


    public Obstacle (Vector2D position){
        super.position = position;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.GRAY);
        graphics.fillRect(super.position.x*AbstractMapElement.tileSize,super.position.y*AbstractMapElement.tileSize,AbstractMapElement.tileSize,AbstractMapElement.tileSize);
    }

}
