import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class restart extends Actor
{
    public void act() 
    {
        if(Greenfoot.isKeyDown("r")){
            GameScreen world = new GameScreen();
            Greenfoot.setWorld(world);
        }
    }    
}