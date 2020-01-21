import java.awt.*;

public class SnakeSegment extends AbstractMapElement {


    public SnakeSegment(Vector2D position){
        super.position = position;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        graphics.fillRect(super.position.x*AbstractMapElement.tileSize,super.position.y*AbstractMapElement.tileSize,AbstractMapElement.tileSize,AbstractMapElement.tileSize);
    }

}
