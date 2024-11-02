package drawing_objects;

import java.awt.*;

public class DrawingBlocks implements IDrawBlocks{
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
        graphics2D.fillRect(_startX+52, _startY+12, 6, 6);
        graphics2D.fillRect(_startX+52, _startY+32, 6, 6);
        if (number == BlocksNumber.FOUR || number == BlocksNumber.SIX){
            graphics2D.fillRect(_startX+62, _startY+12, 6, 6);
            graphics2D.fillRect(_startX+62, _startY+32, 6, 6);
            if (number == BlocksNumber.SIX){
                graphics2D.fillRect(_startX+42, _startY+12, 6, 6);
                graphics2D.fillRect(_startX+42, _startY+32, 6, 6);
            }
        }
    }
}