import java.util.List;
import java.util.Map;

public interface IMap2D {
     void addElement(IMapElement element);
     boolean isOccupied(Vector2D position);
     Object objectAt(Vector2D position);
     Vector2D findUnoccupiedPosition();
     Map<Vector2D,IMapElement> getObjects();
}
