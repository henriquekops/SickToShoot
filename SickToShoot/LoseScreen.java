import greenfoot.*;

public class LoseScreen extends World
{
    GreenfootSound sound = new GreenfootSound("pDead.wav");
    
    public LoseScreen()
    {    
        super(1000, 600, 1);
        addObject(new restart(),500,500);
    }
    
    public void trigger() {
        this.sound.play();
    }
}
