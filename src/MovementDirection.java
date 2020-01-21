import java.awt.event.KeyEvent;

public enum MovementDirection {
    UP,
    RIGHT,
    DOWN,
    LEFT;

    public boolean canChooseThisDirection(MovementDirection newMoveDirection){
        switch (this){
            case UP:
                return !(newMoveDirection==MovementDirection.DOWN);
            case RIGHT:
                return !(newMoveDirection==MovementDirection.LEFT);
            case DOWN:
                return !(newMoveDirection==MovementDirection.UP);
            case LEFT:
                return !(newMoveDirection==MovementDirection.RIGHT);
            default:
                throw new IndexOutOfBoundsException("Unknown movement direction: " + this);
        }
    }

    public static MovementDirection keyPressedToDirection(KeyEvent event){
        int keyCode = event.getKeyCode();
        switch (keyCode){
            case KeyEvent.VK_RIGHT:
                return MovementDirection.RIGHT;
            case KeyEvent.VK_LEFT:
                return MovementDirection.LEFT;
            case KeyEvent.VK_UP:
                return MovementDirection.UP;
            case KeyEvent.VK_DOWN:
                return MovementDirection.DOWN;
            default:
                return null; // Throwing exception would stop programme on pressing any other key
        }
    }
}
