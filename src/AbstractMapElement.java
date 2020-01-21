import java.awt.*;

public abstract class AbstractMapElement implements IMapElement {
    protected Vector2D position;
    protected IMap2D map;
    protected static int tileSize;

    @Override
    public Vector2D getPosition() {
        return this.position;
    }


}
