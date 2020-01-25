import java.awt.*;
import java.util.Random;

public class Bug extends AbstractMapElement implements Eatable {

    private Random rand = new Random();

    public Bug(Vector2D position, IMap2D map){
        super.position = position;
        super.map = map;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(super.position.x*tileSize,super.position.y*tileSize,tileSize,tileSize);
    }

    @Override
    public void onCollision() {
        super.map.removeElement(this);
    }

    public void tick(){
        int moveIf0 = this.rand.nextInt(5);
        if(moveIf0 == 0){
            Vector2D movedPosition = this.getMovePosition();
            super.map.moveElement(this,super.position,movedPosition);
            super.position = movedPosition;
        }
    }

    public Vector2D getMovePosition(){
        Vector2D newPosition;
        int x,y;
        int tries = 10;
        do{
            if(tries < 0)   return super.position;
            x = this.rand.nextInt(3)-1;
            y = this.rand.nextInt(3)-1;
            newPosition =  super.position.add(new Vector2D(x,y));
            tries--;
        }while(super.map.isOccupied(newPosition) || !super.map.inBoundaries(newPosition) );
        return newPosition;

    }
}
