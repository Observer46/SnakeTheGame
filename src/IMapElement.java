import java.awt.*;

public interface IMapElement {
    Vector2D getPosition();        // Returns position of the object
    void draw(Graphics graphics);        // Draws element on panel
    void onCollision();
}
