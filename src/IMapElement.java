import java.awt.*;

public interface IMapElement {
    Vector2D getPosition();        // Retruns position of the object
    void draw(Graphics graphics);        // Draws element on panel
}
