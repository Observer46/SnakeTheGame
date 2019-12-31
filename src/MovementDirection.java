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
}
