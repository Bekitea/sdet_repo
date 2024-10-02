package movement_strategy;

import drawing_objects.DirectionType;

public interface IMoveableObject {
    ObjectParameters getObjectPosition();
    int getStep();
    boolean checkCanMove(DirectionType direction);
    void moveObject(DirectionType direction);
}
