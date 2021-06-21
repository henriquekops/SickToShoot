import greenfoot.*;

public class SuperShotReady extends Actor
{
    public void act() 
    {
        // Add your action code here.
    }  
    
    public void reset(){
        GreenfootImage red = new GreenfootImage("button-red.png");
        setImage(red);
    }
    
    public void accept(){
        GreenfootImage red = new GreenfootImage("button-green.png");
        setImage(red);
    }
}
