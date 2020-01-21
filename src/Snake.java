import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Snake  {
    private List<SnakeSegment> snakeSegments = new ArrayList<>();
    private MovementDirection orientation = MovementDirection.DOWN;
    private IMap2D map;
    private int snakeSize;
    private int ticks = 0;


    public Snake(Vector2D position, IMap2D map){
        this.map = map;
        Vector2D fixSegmentPosition = new Vector2D(1,0);
        SnakeSegment firstSegment = new SnakeSegment(position, map);
        SnakeSegment secondSegment = new SnakeSegment(firstSegment.position.subtract(fixSegmentPosition), map);
        SnakeSegment thirdSegment = new SnakeSegment(secondSegment.position.subtract(fixSegmentPosition), map);
        this.map.addElement(firstSegment);
        this.map.addElement(secondSegment);
        this.map.addElement(thirdSegment);
        this.addSegment(firstSegment);
        this.addSegment(secondSegment);
        this.addSegment(thirdSegment);
    }

    public void addSegment(SnakeSegment segment){
        snakeSegments.add(segment);
    }

    public Vector2D getTailPosition(){
        int lastIndex = this.snakeSegments.size() - 1;
        return snakeSegments.get(lastIndex).getPosition();
    }

    public void tick(){
        this.ticks++;
        if(ticks > 500000) {
            synchronized (this) {
                Vector2D deltaMovement = this.orientation.unitVector();
                Vector2D newSnakeSegmentPosition = this.getTailPosition().add(deltaMovement);
                SnakeSegment movedSegment = new SnakeSegment(newSnakeSegmentPosition, this.map);
                SnakeSegment segmentToDelete = this.snakeSegments.get(0);
                this.map.removeElement(segmentToDelete);
                this.map.addElement(movedSegment);
            }
            this.ticks=0;
        }
    }

    public void deleteFirstSegment(){
        this.snakeSegments.remove(0);
    }

    public void changeDirection(KeyEvent pressedKey){
        MovementDirection orientation = MovementDirection.keyPressedToDirection(pressedKey);
        if(this.orientation.canChooseThisDirection(orientation))
            this.orientation = orientation;
    }

}
