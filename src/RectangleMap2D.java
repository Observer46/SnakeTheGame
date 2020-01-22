public class RectangleMap2D extends AbstractMap2D {


    public RectangleMap2D(Vector2D upperRight){
        super.upperRight = upperRight;
        super.startPosition = new Vector2D(upperRight.x/2,upperRight.y/2);
        super.snake = new Snake(super.startPosition,this);
        super.createAnotherApple();
        for (int i=0; i<10; i++)
            super.createObstacle();
    }

    @Override
    public void resetMap() {
        for(SnakeSegment segment : this.snake.getSnakeSegments())
            super.removeFromHashMap(segment);
        GameVisualizer.score = 0;
        GameVisualizer.gameOver = false;
        super.snake = new Snake(super.startPosition, this);
    }
}
