public class RectangleMap2D extends AbstractMap2D {
    private Vector2D upperRight;
    private Vector2D lowerLeft = new Vector2D(0,0);

    public RectangleMap2D(Vector2D upperRight){
        super.upperRight = upperRight;
        Vector2D startPosition = new Vector2D(upperRight.x/2,upperRight.y/2);
        super.snake = new Snake(startPosition,this);
    }
}
