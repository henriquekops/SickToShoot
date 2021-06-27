import greenfoot.*;

public class Enemy1 extends Actor
{
    private GreenfootSound sound;
    
    public Enemy1() {
        this.sound = new GreenfootSound("eDead.wav");
        this.sound.setVolume(75);
    }
    
    public void act() {
        setRotation(getRotation()+3);
        setLocation(getX()-6, getY());
        checkCollision();
    }

    public void checkCollision() {
        Shoot shoot = (Shoot)getOneIntersectingObject(Shoot.class);
        
        if(shoot != null) {
            GameScreen world = (GameScreen) getWorld();
            getWorld().removeObject(shoot);
            world.setPower();
            sound.play();
            getWorld().removeObject(this);
        } else if(getX() <= 5) {
            GameScreen world = (GameScreen) getWorld();
            sound.play();
            world.player.damage();
            getWorld().removeObject(this);
        }
    }  
}
