package drawing_objects;

import java.awt.*;

public class DrawingRoundBlocks implements IDrawBlocks{
    private BlocksNumber number;
    @Override
    public void setNumber(int x){
        if(x <= 2)
            number = BlocksNumber.TWO;
        if(x == 4)
            number = BlocksNumber.FOUR;
        if(x >= 6)
            number = BlocksNumber.SIX;
    }
    @Override
    public void drawBlocks(Graphics2D graphics2D, int _startX, int _startY){
        graphics2D.fillOval(_startX+50, _startY+11, 8, 8);
        graphics2D.fillOval(_startX+50, _startY+31, 8, 8);
        if (number == BlocksNumber.FOUR || number == BlocksNumber.SIX){
            graphics2D.fillOval(_startX+60, _startY+11, 8, 8);
            graphics2D.fillOval(_startX+60, _startY+31, 8, 8);
            if (number == BlocksNumber.SIX){
                graphics2D.fillOval(_startX+40, _startY+11, 8, 8);
                graphics2D.fillOval(_startX+40, _startY+31, 8, 8);
            }
        }
    }
}
