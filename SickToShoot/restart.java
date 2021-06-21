import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class restart extends Actor
{
    public void act() 
    {
        if(Greenfoot.isKeyDown("r")){
            MyWorld MyWorld = new MyWorld();
            Greenfoot.setWorld(MyWorld);
        }
    }    
}