package drawing_objects;

import entities.EntityBattleship;

import java.awt.*;

public class DrawingBattleship extends DrawingShip {
    public DrawingBattleship(int speed, double weight, Color bodyColor, Color additionalColor, boolean turret,
                             boolean rocketLauncher, int width, int height, int blocksType, int blocksNumber) {
        super(speed, weight, bodyColor, width, height, blocksType, blocksNumber);
        if (entityShip != null)
            entityShip = new EntityBattleship(speed, weight, bodyColor, additionalColor, turret, rocketLauncher);
    }
    @Override
    public void drawTransport(Graphics2D graphics2D) {
        if (!(entityShip instanceof EntityBattleship))
            return;
        BasicStroke pen = new BasicStroke(2);
        graphics2D.setStroke(pen);
        Color additionalColor = ((EntityBattleship)entityShip).getAdditionalColor();
        super.drawTransport(graphics2D);
        //орудийная башня
        if (((EntityBattleship)entityShip).getTurret()) {
            int[] shieldX = new int[] {startPosX + 112, startPosX + 112, startPosX + 119, startPosX + 119, };
            int[] shieldY = new int[] {startPosY + 19, startPosY + 31, startPosY + 28, startPosY + 22};
            graphics2D.setPaint(additionalColor);
            graphics2D.fillPolygon(shieldX, shieldY, 4);
            graphics2D.fillRect(startPosX + 119, startPosY + 24, 12, 2);
            graphics2D.setPaint(Color.BLACK);
            graphics2D.drawPolygon(shieldX, shieldY, 4);
            graphics2D.drawRect(startPosX + 119, startPosY + 24, 12, 2);
        }
        //ячейки для ракет
        if (((EntityBattleship)entityShip).getRocketLauncher()) {
            graphics2D.setPaint(additionalColor);
            graphics2D.fillRect(startPosX + 14, startPosY + 14, 10, 10);
            graphics2D.fillRect(startPosX + 26, startPosY + 14, 10, 10);
            graphics2D.fillRect(startPosX + 14, startPosY + 26, 10, 10);
            graphics2D.fillRect(startPosX + 26, startPosY + 26, 10, 10);
            graphics2D.setPaint(Color.BLACK);
            graphics2D.drawRect(startPosX + 14, startPosY + 14, 10, 10);
            graphics2D.drawRect(startPosX + 26, startPosY + 14, 10, 10);
            graphics2D.drawRect(startPosX + 14, startPosY + 26, 10, 10);
            graphics2D.drawRect(startPosX + 26, startPosY + 26, 10, 10);
        }
    }
}