public class Main {
    public static void main (String[] args){
        Vector2D upperRight = new Vector2D(30,30);
        IMap2D map = new RectangleMap2D(upperRight);
        Visualizer game = new Visualizer(map);
    }
}
