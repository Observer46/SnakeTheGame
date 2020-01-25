import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractMap2D implements IMap2D{
    protected Vector2D lowerLeft = new Vector2D(0,0);
    protected Vector2D upperRight;
    protected Map<Vector2D, IMapElement> objects = new ConcurrentHashMap<>();
    protected Snake snake;
    protected List<Obstacle> obstacles = new ArrayList<>();
    protected Random rand = new Random();
    protected Vector2D startPosition;
    protected List<Eatable> eatables = new ArrayList<>();



    public void addElement(IMapElement elem){
        this.objects.put(elem.getPosition(),elem);
        if(elem instanceof SnakeSegment){
            SnakeSegment segment = (SnakeSegment) elem;
            if (this.snake != null)
                this.snake.addSegment(segment);
        }
        else if(elem instanceof Eatable){
            Eatable food = (Eatable) elem;
            this.eatables.add(food);
        }
        else if (elem instanceof Obstacle) {
            Obstacle obstacle = (Obstacle) elem;
            this.obstacles.add(obstacle);
        }
    }

    public void removeElement(IMapElement elem){
        this.objects.remove(elem.getPosition(), elem);
        if(elem instanceof Eatable) {
            Eatable food = (Eatable) elem;
            this.eatables.remove(food);
            this.createNewFood();
            if (elem instanceof Bug)
                this.createNewFood();
        }

        else if (elem instanceof Obstacle) {
            Obstacle obstacle = (Obstacle) elem;
            this.obstacles.remove(obstacle);
        }
        else if (elem instanceof SnakeSegment)
            this.snake.deleteFirstSegment();
    }

    public Map<Vector2D,IMapElement> getObjects(){
        return this.objects;
    }

    @Override
    public Object objectAt(Vector2D position) {
        return this.objects.get(position);
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
        } while(this.isOccupied(unoccupiedPosition) || isInSnakeSafeRange(unoccupiedPosition));
        return unoccupiedPosition;
    }

    public boolean isInSnakeSafeRange(Vector2D position){
        Vector2D snakeSafeRangeUpperRight = this.snake.getTailPosition().add( new Vector2D(2,2));
        Vector2D snakeSafeRangeLowerLeft = this.snake.getTailPosition().subtract( new Vector2D(2,2));
        return position.precedes(snakeSafeRangeUpperRight) && position.follows(snakeSafeRangeLowerLeft);
    }

    @Override
    public Vector2D getUpperRight() {
        return this.upperRight;
    }

    @Override
    public void createNewFood() {
        Vector2D newFoodPosition = this.findUnoccupiedPosition();
        Eatable newFood;
        boolean itsApple = this.rand.nextBoolean();
        if(itsApple)
            newFood = new Apple(newFoodPosition, this);
        else
            newFood = new Bug(newFoodPosition,this);
        this.addElement(newFood);
    }

    @Override
    public void createObstacle() {
        Vector2D obstaclePosition = this.findUnoccupiedPosition();
        Obstacle obstacle = new Obstacle(obstaclePosition,this);
        this.addElement(obstacle);
    }

    @Override
    public void tick() {
        this.snake.tick();
        for(Eatable food : this.eatables)
            food.tick();
    }

    @Override
    public Snake getSnake() {
        return this.snake;
    }

    public List<Obstacle> getObstacles() {
        return this.obstacles;
    }

    @Override
    public boolean inBoundaries(Vector2D position) {
        return position.precedes(this.upperRight) && position.follows(this.lowerLeft);
    }

    public void removeFromHashMap(IMapElement element){
        this.objects.remove(element.getPosition(),element);
    }

    @Override
    public Vector2D getLowerLeft() {
        return this.lowerLeft;
    }

    @Override
    public void moveElement(IMapElement elem,Vector2D oldPosition, Vector2D newPosition) {
        this.objects.remove(oldPosition,elem);
        this.objects.put(newPosition, elem);
    }

    public void resetEatables(){
        for(Eatable food : this.eatables)
            this.objects.remove(food.getPosition());
        this.eatables = new ArrayList<>();
    }
}
