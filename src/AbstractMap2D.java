import javax.swing.text.Position;
import java.util.*;

public class AbstractMap2D implements IMap2D{
    protected Vector2D lowerLeft = new Vector2D(0,0);
    protected Vector2D upperRight;
    protected Map<Vector2D, IMapElement> objects = new HashMap<>();
    protected Snake snake;
    protected Apple apple;
    protected List<Obstacle> obstacles = new ArrayList<>();
    protected Random rand = new Random();


    public void addElement(IMapElement elem){
        this.objects.put(elem.getPosition(),elem);
        if(elem instanceof SnakeSegment){
            SnakeSegment segment = (SnakeSegment) elem;
            this.snake.addSegment(segment);
        }
        else if(elem instanceof Apple){
            Apple apple = (Apple) elem;
            this.apple = apple;
        }
        else if (elem instanceof Obstacle) {
            Obstacle obstacle = (Obstacle) elem;
            this.obstacles.add(obstacle);
        }
    }

    public void removeElement(IMapElement elem){
        this.objects.remove(elem.getPosition());
        if(elem instanceof Apple){
            Vector2D newApplePosition = this.findUnoccupiedPosition();
            this.apple = new Apple(newApplePosition,this);
        }
        else if (elem instanceof Obstacle) {
            Obstacle obstacle = (Obstacle) elem;
            this.obstacles.remove(obstacle);
        }
    }

    public Map<Vector2D,IMapElement> getObjects(){
        return this.objects;
    }

    @Override
    public Object objectAt(Vector2D position) {
        return objects.get(position);
    }

    @Override
    public boolean isOccupied(Vector2D position) {
        return this.objectAt(position)!=null;
    }

    @Override
    public Vector2D findUnoccupiedPosition() {
        int xCoord;
        int yCoord;
        Vector2D unoccupiedPosition;
        do {
            xCoord = rand.nextInt(upperRight.x);
            yCoord = rand.nextInt(upperRight.y);
            unoccupiedPosition = new Vector2D(xCoord,yCoord);
        } while(this.isOccupied(unoccupiedPosition));
        return unoccupiedPosition;
    }


}
