import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractMap2D implements IMap2D{
    protected Vector2D lowerLeft = new Vector2D(0,0);
    protected Vector2D upperRight;
    protected Map<Vector2D, IMapElement> objects = new HashMap<>();
    protected List<Snake> snakes = new ArrayList<>();
    protected List<Food> eatableFood = new ArrayList<>();

}
