import java.awt.*;

public class Apple extends AbstractMapElement {


    public Apple(Vector2D position, IMap2D map){
        super.position = position;
        super.map = map;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(super.position.x*tileSize,super.position.y*tileSize,tileSize,tileSize);
    }

    @Override
    public void onCollision() {
        super.map.removeElement(this);
    }
}
