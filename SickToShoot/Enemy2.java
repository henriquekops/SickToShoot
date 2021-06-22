import greenfoot.*;

public class Enemy2 extends Actor
{
    private int vida = 2;
    private GreenfootSound sound = new GreenfootSound("eDead.wav");
    private GreenfootSound hit = new GreenfootSound("hit.wav");
    public void act() 
    {
        move(7);
        if(getRotation() > 135 && getRotation() < 225){
            setRotation(getRotation()+3);
        }else{
            setRotation(getRotation()+8);
        }
        try{
            verify();
        }catch(Exception e){
            
        }
    }

    public void verify()throws Exception{
        Shoot shoot = (Shoot)getOneIntersectingObject(Shoot.class);
        MyWorld myWorld = (MyWorld) getWorld();
        sound.setVolume(75);
        hit.setVolume(70);
        if(shoot != null){
            getWorld().removeObject(shoot);
            myWorld.setPower();
            hit.play();
            vida--;
        }
        
        if(vida == 0){
            vida = 2;
            sound.play();
            getWorld().removeObject(this);
        }
        
        if(getX() <= 5){
            vida = 2;
            sound.play();
            getWorld().removeObject(this);
            myWorld.damage();
        }
    }
}
