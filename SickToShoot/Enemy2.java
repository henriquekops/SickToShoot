import greenfoot.*;

public class Enemy2 extends Actor {
    private int life, speed;
    private GreenfootSound sound, hit;
    
    public Enemy2() {
        this.life = 2;
        this.speed = 7;
        this.sound = new GreenfootSound("eDead.wav");
        this.hit = new GreenfootSound("hit.wav");
        sound.setVolume(50);
        hit.setVolume(50);
    }
    
    public void act() {
        move(speed);
        rotate();
        checkCollision();
    }
    
    public void rotate() {
        if(getRotation() > 135 && getRotation() < 225) {
            setRotation(getRotation()+3);
        } else {
            setRotation(getRotation()+8);
        }
    }

    public void checkCollision() {
        Shoot shoot = (Shoot)getOneIntersectingObject(Shoot.class);
        if(shoot != null) {
            GameScreen world = (GameScreen) getWorld();
            world.specialIndicator.increasePower();
            world.player.setScore(2);
            hit.play();
            life--;
            getWorld().removeObject(shoot);
        }
        if(life == 0){
            sound.play();
            getWorld().removeObject(this);
        } else if(getX() <= 5){
            GameScreen world = (GameScreen) getWorld();
            world.player.damage();
            sound.play();
            getWorld().removeObject(this);
        }
    }
}