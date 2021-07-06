import greenfoot.*;

public class restart extends Actor
{
    public void act() 
    {
        if(Greenfoot.isKeyDown("r")){
            menu world = new menu();
            Greenfoot.setWorld(world);
        }
    }    
}