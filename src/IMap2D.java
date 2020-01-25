import java.util.List;
import java.util.Map;

public interface IMap2D {
     void addElement(IMapElement element);
     void removeElement(IMapElement element);
     boolean isOccupied(Vector2D position);
     Object objectAt(Vector2D position);
     Vector2D findUnoccupiedPosition();
     Map<Vector2D,IMapElement> getObjects();
     Vector2D getUpperRight();
     void createNewFood();
     void createObstacle();
     void tick();
     Snake getSnake();
     List<Obstacle> getObstacles();
     boolean inBoundaries(Vector2D position);
     void resetMap();
     void moveElement(IMapElement elem, Vector2D oldPosition, Vector2D newPosition);

     Vector2D getLowerLeft();
}
