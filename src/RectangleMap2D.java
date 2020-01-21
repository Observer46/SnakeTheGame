public class RectangleMap2D extends AbstractMap2D {
    public RectangleMap2D(Vector2D upperRight){
        super.upperRight = upperRight;
        Vector2D startPosition = new Vector2D(upperRight.x/2,upperRight.y/2);
        super.snake = new Snake(startPosition,this);
        super.createAnotherApple();
        for (int i=0; i<10; i++)
            super.createObstacle();
    }
}
