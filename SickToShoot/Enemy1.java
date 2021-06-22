import greenfoot.*;

public class Enemy1 extends Actor
{
    private GreenfootSound sound = new GreenfootSound("eDead.wav");
    public void act() 
    {
        setRotation(getRotation()+3);
        setLocation(getX()-6, getY());
        try{
            verify();
        }catch(Exception e){
            
        }
    }

    public void verify()throws Exception{
        Shoot shoot = (Shoot)getOneIntersectingObject(Shoot.class);
        MyWorld myWorld = (MyWorld) getWorld();
        sound.setVolume(75);
        if(shoot != null){
            getWorld().removeObject(shoot);
            myWorld.setPower();
            sound.play();
            getWorld().removeObject(this);
        }
        if(getX() <= 5){
            sound.play();
            getWorld().removeObject(this);
            myWorld.dano();
        }
    }  
}
