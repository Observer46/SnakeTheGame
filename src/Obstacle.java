import java.awt.*;
import java.sql.Struct;

public class Obstacle extends AbstractMapElement{


    public Obstacle (Vector2D position,IMap2D map){
        super.map = map;
        super.position = position;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.GRAY);
        graphics.fillRect(super.position.x*tileSize,super.position.y*tileSize,tileSize,tileSize);
    }

    //public static Vector2D findPositionForObstacle()


    @Override
    public void onCollision() {
        GameVisualizer.gameOver=true;
    }
}
