public abstract class AbstractMapElement implements IMapElement {
    protected Vector2D positon;

    @Override
    public Vector2D getPosition() {
        return this.positon;
    }
}
