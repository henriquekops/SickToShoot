import greenfoot.*;
import java.util.Random;

public class Player extends Actor
{ 
    private int cooldownShot, cooldownSpecial;
    private boolean activeShot, activeSpecial;
    private Random random;
    private GreenfootSound shotSound;
    GameScreen gameScreen;
    int speed;
    //private int spawn1;// = 0;
    //private int spawn2;// = 0;
    //private int spawn3;// = 0;
    
    public Player() {
        cooldownShot = 0;
        cooldownSpecial = 0;
        random = new Random();
        shotSound = new GreenfootSound("shoot.wav");
        speed = 6;
        shotSound.setVolume(60);
        activeShot = false;
        activeSpecial = false;
    }
    
    public void act()
    {
        gameScreen = (GameScreen) getWorld();
        move();
        shoot();
        special(gameScreen);
        damage();
        if (cooldownShot > 0) {
            cooldownShot--;
        }
        if (cooldownSpecial > 0) {
            cooldownSpecial--;
        }
        //spawn();
        //spawn1++;
        //spawn2++;
        //spawn3++;
        //if(gameScreen.getPower() >= 5){
        //    superPower(gameScreen);
        //}
        
        //if (timer>0)
        //{
        //    timer--;
        //    if(timer == 0) {
        //        gameScreen.setLoseScreen();
        //    }
        //}
    }

    public void move() {
        if(Greenfoot.isKeyDown("s")) {
            move(speed);
        }
        if(Greenfoot.isKeyDown("w")) {
            move(-speed);
        }
        if(Greenfoot.isKeyDown("d")) {
            setLocation(getX()+speed, getY());
        }
        if(Greenfoot.isKeyDown("a")) {
            setLocation(getX()-speed, getY());
        }
    }

    public void shoot(){
        if(Greenfoot.isKeyDown("space") && cooldownShot == 0) {
            getWorld().addObject(new Shoot(), getX(), getY());
            shotSound.play();
            cooldownShot = 20;
        }
    }

    public void special(GameScreen gameScreen) {
        if(Greenfoot.isKeyDown("e") && !activeSpecial) {//&& gameScreen.getPower() >= 5) {
            activeSpecial = true;
            gameScreen.setPower(true);
            getWorld().addObject(new SpecialShot(), getX(), getY());
            cooldownSpecial = 60;
        } else if (!Greenfoot.isKeyDown("e") && activeSpecial) {
            activeSpecial = false;
        }
        if (cooldownSpecial == 40 || cooldownSpecial == 20) {
            getWorld().addObject(new SpecialShot(), getX(), getY());
        }
    }

    public void damage() {
        if(isTouching(Enemy1.class)){
            removeTouching(Enemy1.class);
            gameScreen.damage();
        }
        if(isTouching(Enemy2.class)){
            removeTouching(Enemy2.class);
            gameScreen.damage();
        }
        if(isTouching(Enemy3.class)){
            removeTouching(Enemy3.class);
            gameScreen.damage();
        }
    }
} 