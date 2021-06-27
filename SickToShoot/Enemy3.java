import greenfoot.*;

public class Enemy3 extends Actor {
    private int life, speedX, speedY;
    private GreenfootSound sound, hit;
    
    public Enemy3() {
        this.life = 3;
        this.speedX = 7;
        this.speedY = 3;
        this.sound = new GreenfootSound("eDead.wav");
        this.hit = new GreenfootSound("hit.wav");
    }
    
    public void act() {
        followPlayer();
        try{ checkCollision(); } catch(Exception e ) {}
    }

    public void followPlayer() {
        Player player = (Player) getObjectsInRange(1200,  Player.class).get(0);
        if(player.getX() < getX()){
            setLocation(getX()-speedX, getY());
        }
        if(player.getX() > getX()){
            setLocation(getX()+speedX, getY());
        }
        if(player.getY() < getY()){
            setLocation(getX(), getY()-speedY);
        }
        if(player.getY() > getY()){
            setLocation(getX(), getY()+speedY);
        }
    }

    public void checkCollision() {
        Shoot shoot = (Shoot)getOneIntersectingObject(Shoot.class);
        sound.setVolume(75);
        hit.setVolume(70);
        if(shoot != null) {
            GameScreen world = (GameScreen) getWorld();
            world.setPower();
            hit.play();
            life--;
            getWorld().removeObject(shoot);
        }
        if(life == 0) {
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