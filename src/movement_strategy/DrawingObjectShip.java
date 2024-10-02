package movement_strategy;

import drawing_objects.DrawingShip;
import drawing_objects.DirectionType;

public class DrawingObjectShip implements IMoveableObject{
    private final DrawingShip drawingShip;
    public DrawingObjectShip(DrawingShip drawingShip){
        this.drawingShip = drawingShip;
    }
    @Override
    public ObjectParameters getObjectPosition(){
        if(drawingShip == null || drawingShip.getEntityShip() == null)
            return null;
        return new ObjectParameters(drawingShip.getPosX(), drawingShip.getPosY(),
                drawingShip.getWidth(), drawingShip.getHeight());
    }
    @Override
    public int getStep(){
        if(drawingShip.getEntityShip() == null)
            return 0;
        return drawingShip.getEntityShip().step.get().intValue();
    }
    @Override
    public boolean checkCanMove(DirectionType direction){
        if(drawingShip == null)
            return false;
        return drawingShip.canMove(direction);
    }
    @Override
    public void moveObject(DirectionType direction){
        if(drawingShip == null)
            return;
        drawingShip.moveTransport(direction);
    }
}