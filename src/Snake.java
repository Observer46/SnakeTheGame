import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Snake  {
    private List<SnakeSegment> snakeSegments = new ArrayList<>();
    private MovementDirection orientation = MovementDirection.DOWN;
    private IMap2D map;


    public Snake(Vector2D position, IMap2D map){
        this.map = map;
        Vector2D fixSegmentPosition = new Vector2D(1,0);
        SnakeSegment firstSegment = new SnakeSegment(position, this.map);
        SnakeSegment secondSegment = new SnakeSegment(firstSegment.position.subtract(fixSegmentPosition), this.map);
        SnakeSegment thirdSegment = new SnakeSegment(secondSegment.position.subtract(fixSegmentPosition), this.map);
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

    public boolean tick(){
        Vector2D deltaMovement = this.orientation.unitVector();
        Vector2D newSnakeSegmentPosition = this.getTailPosition().add(deltaMovement);
        if(this.map.isOccupied(newSnakeSegmentPosition)){
            IMapElement element = (IMapElement) this.map.objectAt(newSnakeSegmentPosition);
            System.out.println(element);
            boolean gameOver = element.onCollision();
            if(gameOver)
                return true;
        }

        SnakeSegment movedSegment = new SnakeSegment(newSnakeSegmentPosition, this.map);
        SnakeSegment segmentToDelete = this.snakeSegments.get(0);
        this.map.removeElement(segmentToDelete);
        this.map.addElement(movedSegment);
        return false;

    }

    public void deleteFirstSegment(){
        this.snakeSegments.remove(0);
    }

    public void changeDirection(KeyEvent pressedKey){
        MovementDirection orientation = MovementDirection.keyPressedToDirection(pressedKey);
        if(orientation==null)
            return;
        if(this.orientation.canChooseThisDirection(orientation))
            this.orientation = orientation;
    }

}
