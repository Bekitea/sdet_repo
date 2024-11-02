package drawing_objects;

import java.awt.*;

public interface IDrawBlocks {
    void setNumber(int x);
    void drawBlocks(Graphics2D graphics2D, int _startX, int _startY);
}
