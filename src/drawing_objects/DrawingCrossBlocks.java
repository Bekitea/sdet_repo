package drawing_objects;

import java.awt.*;

public class DrawingCrossBlocks implements IDrawBlocks{
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
        graphics2D.fillRect(_startX+54, _startY+12, 2, 6);
        graphics2D.fillRect(_startX+52, _startY+14, 6, 2);
        graphics2D.fillRect(_startX+54, _startY+32, 2, 6);
        graphics2D.fillRect(_startX+52, _startY+34, 6, 2);
        if (number == BlocksNumber.FOUR || number == BlocksNumber.SIX){
            graphics2D.fillRect(_startX+64, _startY+12, 2, 6);
            graphics2D.fillRect(_startX+62, _startY+14, 6, 2);
            graphics2D.fillRect(_startX+64, _startY+32, 2, 6);
            graphics2D.fillRect(_startX+62, _startY+34, 6, 2);
            if (number == BlocksNumber.SIX){
                graphics2D.fillRect(_startX+44, _startY+12, 2, 6);
                graphics2D.fillRect(_startX+42, _startY+14, 6, 2);
                graphics2D.fillRect(_startX+44, _startY+32, 2, 6);
                graphics2D.fillRect(_startX+42, _startY+34, 6, 2);
            }
        }
    }
}
