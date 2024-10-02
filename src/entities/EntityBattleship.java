package entities;

import java.awt.*;

public class EntityBattleship extends EntityShip {
    private Color additionalColor;
    public Color getAdditionalColor(){
        return additionalColor;
    }
    private boolean turret;
    public boolean getTurret() {return turret;}
    private boolean rocketLauncher;
    public boolean getRocketLauncher() {return rocketLauncher;}
    public EntityBattleship(int speed, double weight, Color bodyColor, Color additionalColor, boolean turret, boolean rocketLauncher) {
        super(speed, weight, bodyColor);
        this.additionalColor = additionalColor;
        this.turret = turret;
        this.rocketLauncher = rocketLauncher;
    }
}