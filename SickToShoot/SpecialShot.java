import greenfoot.*;

public class SpecialShot extends Actor {
    private int spriteInvert, speed;
    private GreenfootImage spriteUp;
    private GreenfootImage spriteDown;
    private GreenfootSound sound;
    
    public SpecialShot() {
        spriteUp = new GreenfootImage("hamburger.png");
        spriteDown = new GreenfootImage("hamburger2.png");
        sound = new GreenfootSound("ss.wav");
        sound.setVolume(80);
        sound.play();
        spriteInvert = 0;
        speed = 15;
    }
    
    public void act() {
        move(speed);
        invertSprite();
        checkCollision();
        checkIfAtWorldEdge();
        spriteInvert++;
    }
    
    public void invertSprite() {
        if(spriteInvert%5 == 0 && spriteInvert%10 != 0){
            setImage(spriteDown);
        }
        if(spriteInvert%10 == 0){
            setImage(spriteUp);
        }
    }

    public void checkIfAtWorldEdge() {
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }

    public void checkCollision()
    {
        if(isTouching(Enemy1.class)) {
            removeTouching(Enemy1.class);
        }
        if(isTouching(Enemy2.class)){
            removeTouching(Enemy2.class);
        }
        if(isTouching(Enemy3.class)){
            removeTouching(Enemy3.class);
        }
    }
}