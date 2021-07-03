import greenfoot.*;

public class SpecialIndicator extends Actor
{
    public int x, y;
    private int power;
    GreenfootImage red;
    GreenfootImage green;
    
    public SpecialIndicator() {
        this.x = 40;
        this.y = 537;
        this.power = 0;
        red = new GreenfootImage("button-red.png");
        green = new GreenfootImage("button-green.png");
    }
    
    public void act() 
    {
        checkImage();
    }
    
    public boolean checkPower() {
        if (power > 5) {
            power = 0;
            return true;
        } else {
            return false;
        }
    }
    
    public void checkImage() {
        if (power > 5) {
            setImage(green);
        } else {
            setImage(red);
        }
    }
    
    public void increasePower() {
        power++;
    }
}
