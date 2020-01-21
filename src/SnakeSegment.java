import java.awt.*;

public class SnakeSegment extends AbstractMapElement {


    public SnakeSegment(Vector2D position, IMap2D map){
        super.position = position;
        super.map = map;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        graphics.fillRect(super.position.x*tileSize,super.position.y*tileSize,tileSize,tileSize);
    }

    @Override
    public boolean onCollision() {
        return true;
    }
}
