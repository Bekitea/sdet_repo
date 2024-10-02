package drawing_objects;

import entities.EntityShip;

import java.awt.*;

public class DrawingShip {
    protected EntityShip entityShip;
    public EntityShip getEntityShip(){return entityShip;}
    private IDrawBlocks drawingBlocks;
    private int pictureWidth;
    private int pictureHeight;
    protected int startPosX;
    public int getPosX() {return startPosX;}
    protected int startPosY;
    public int getPosY() {return startPosY;}
    private int shipWidth = 150;
    public int getWidth() {return shipWidth;}
    private int shipHeight = 50;
    public int getHeight() {return shipHeight;}
    public DrawingShip(int speed, double weight, Color bodyColor, int width, int height, int blocksType, int blocksNumber) {
        if (width < shipWidth || height < shipHeight)
            return;
        pictureWidth = width;
        pictureHeight = height;
        entityShip = new EntityShip(speed, weight, bodyColor);
        switch (blocksType) {
            case 1 -> drawingBlocks = new DrawingRoundBlocks();
            case 2 -> drawingBlocks = new DrawingCrossBlocks();
            default -> drawingBlocks = new DrawingBlocks();
        }
        drawingBlocks.setNumber(blocksNumber);
    }
    protected DrawingShip(int speed, double weight, Color bodyColor, int width, int height, int shipWidth,
                          int shipHeight, int blocksType, int blocksNumber) {
        if (width < shipWidth || height < shipHeight)
            return;
        pictureWidth = width;
        pictureHeight = height;
        this.shipWidth = shipWidth;
        this.shipHeight = shipHeight;
        entityShip = new EntityShip(speed, weight, bodyColor);
        switch (blocksType) {
            case 1 -> drawingBlocks = new DrawingRoundBlocks();
            case 2 -> drawingBlocks = new DrawingCrossBlocks();
            default -> drawingBlocks = new DrawingBlocks();
        }
        drawingBlocks.setNumber(blocksNumber);
    }
    public void setPosition(int x, int y) {
        if (x < 0 || y < 0 || x + shipWidth > pictureWidth || y + shipHeight > pictureHeight) {
            x = 0;
            y = 0;
        }
        startPosX = x;
        startPosY = y;
    }
    public void drawTransport(Graphics2D graphics2D) {
        if (entityShip == null) {
            return;
        }
        BasicStroke pen = new BasicStroke(2);
        graphics2D.setStroke(pen);
        Color bodyColor = entityShip.getBodyColor();
        //корпус
        int[] hullX = new int[] {startPosX + 5, startPosX + 100, startPosX + 150, startPosX + 100, startPosX + 5};
        int[] hullY = new int[] {startPosY, startPosY, startPosY + 25, startPosY + 50, startPosY + 50};
        graphics2D.setPaint(bodyColor);
        graphics2D.fillPolygon(hullX, hullY, 5);
        graphics2D.setPaint(Color.BLACK);
        graphics2D.drawPolygon(hullX, hullY, 5);
        graphics2D.fillRect(startPosX, startPosY + 6, 5, 13);
        graphics2D.fillRect(startPosX, startPosY + 31, 5, 13);
        //надстройки
        graphics2D.setPaint(Color.DARK_GRAY);
        graphics2D.fillRect(startPosX + 40, startPosY + 20, 30, 10);
        graphics2D.fillRect(startPosX + 70, startPosY + 12, 18, 26);
        graphics2D.fillOval(startPosX + 94, startPosY + 19, 12, 12);
        graphics2D.setPaint(Color.BLACK);
        graphics2D.drawRect(startPosX + 40, startPosY + 20, 30, 10);
        graphics2D.drawRect(startPosX + 70, startPosY + 12, 18, 26);
        graphics2D.drawOval(startPosX + 94, startPosY + 19, 12, 12);
        //блоки
        if (drawingBlocks != null){
            drawingBlocks.drawBlocks(graphics2D, startPosX, startPosY);
        }
    }
    public boolean canMove(DirectionType direction) {
        if (entityShip == null) {
            return false;
        }
        return switch (direction) {
            case LEFT -> startPosX - entityShip.step.get().intValue() > 0;
            case UP -> startPosY - entityShip.step.get().intValue() > 0;
            case RIGHT -> startPosX + entityShip.step.get().intValue() + shipWidth < pictureWidth;
            case DOWN -> startPosY + entityShip.step.get().intValue() + shipHeight < pictureHeight;
            default -> false;
        };
    }
    public void moveTransport(DirectionType direction) {
        if (!canMove(direction) || entityShip == null)
        {
            return;
        }
        switch (direction) {
            //влево
            case LEFT -> startPosX -= entityShip.step.get().intValue();
            //вверх
            case UP -> startPosY -= entityShip.step.get().intValue();
            // вправо
            case RIGHT -> startPosX += entityShip.step.get().intValue();
            //вниз
            case DOWN -> startPosY += entityShip.step.get().intValue();
        }
    }
}