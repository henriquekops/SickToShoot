import greenfoot.*;

public class Enemy1 extends Actor
{
    private GreenfootSound sound;
    
    private int rotationSpeed, moveSpeed;
    
    public Enemy1() {
        this.sound = new GreenfootSound("eDead.wav");
        this.sound.setVolume(75);
        this.rotationSpeed = 3;
        this.moveSpeed = 6;
    }
    
    public void act() {
        setRotation(getRotation()+3);
        setLocation(getX()-6, getY());
        checkCollision();
    }

    public void checkCollision() {
        Shoot shoot = (Shoot)getOneIntersectingObject(Shoot.class);
        
        if(shoot != null) {
            GameScreen gameScreen = (GameScreen) getWorld();
            gameScreen.specialIndicator.increasePower();
            sound.play();
            getWorld().removeObject(shoot);
            getWorld().removeObject(this);
        } else if(getX() <= 5) {
            GameScreen world = (GameScreen) getWorld();
            world.player.damage();
            sound.play();
            getWorld().removeObject(this);
        }
    }  
    
    public void move() {
        setRotation(getRotation()+3);
    }
}
