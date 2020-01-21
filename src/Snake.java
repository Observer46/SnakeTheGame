import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake extends AbstractMapElement {
    private List<SnakeSegment> snakeSegments = new ArrayList<>();
    private MovementDirection orientation = MovementDirection.RIGHT;


    public Snake(Vector2D position, IMap2D map){
        super.position = position;
        super.map = map;
        Vector2D fixSegmentPosition = new Vector2D(-1,0);
        SnakeSegment firstSegment = new SnakeSegment(position.subtract(fixSegmentPosition));
        SnakeSegment secondSegment = new SnakeSegment(firstSegment.position.subtract(fixSegmentPosition));
        SnakeSegment thirdSegment = new SnakeSegment(secondSegment.position.subtract(fixSegmentPosition));
        super.map.addElement(firstSegment);
        super.map.addElement(secondSegment);
        super.map.addElement(thirdSegment);
    }

    public void addSegment(SnakeSegment segment){
        snakeSegments.add(segment);
    }

    public Vector2D getTailPosition(){
        int lastIndex = this.snakeSegments.size() - 1;
        return snakeSegments.get(lastIndex).getPosition();
    }

    @Override
    public void draw(Graphics graphics) {
        for(SnakeSegment seg : snakeSegments)
            seg.draw(graphics);
    }
}
