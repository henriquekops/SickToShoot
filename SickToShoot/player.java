import greenfoot.*;
import java.util.Random;

public class Player extends Actor
{ 
    private int LIFE_COUNT = 3;
    private int cooldownShot, cooldownSpecial, speed, livesLeft;
    private boolean activeShot, activeSpecial;
    public boolean alive;
    public int score, bestScore;
    private Random random;
    private GreenfootSound shotSound, hitSound;
    private GameScreen gameScreen;
    public Life[] lives;
    
    public Player(int score) {
        this.cooldownShot = 0;
        this.livesLeft = LIFE_COUNT;
        this.cooldownSpecial = 0;
        this.random = new Random();
        this.shotSound = new GreenfootSound("shoot.wav");
        this.hitSound = new GreenfootSound("pHit.wav");
        this.speed = 6;
        this.score = 0;
        this.bestScore = score;
        this.shotSound.setVolume(60);
        this.activeShot = false;
        this.activeSpecial = false;
        this.alive = true;
        this.lives = new Life[LIFE_COUNT];
        addLivesToWorld();
    }
    
    public void act()
    {
        gameScreen = (GameScreen) getWorld();
        move();
        shoot();
        special(gameScreen);
        checkCollision();
        setCooldownShot();
        setCooldownSpecial();
    }
    
    private void setCooldownShot() {
        if (cooldownShot > 0) {
            cooldownShot--;
        }
    }
    
    private void setCooldownSpecial() {
        if (cooldownSpecial > 0) {
            cooldownSpecial--;
        }
    }
    
    public void setScore(int increment) {
        score += increment;
    }
    
    public void addLivesToWorld() {
        for (int i = 0; i < LIFE_COUNT; i++) {
            lives[i] = new Life();
        }
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
        if(Greenfoot.isKeyDown("e") && !activeSpecial && gameScreen.specialIndicator.checkPower()) {
            activeSpecial = true;
            cooldownSpecial = 60;
            getWorld().addObject(new SpecialShot(), getX(), getY());
        } else if (!Greenfoot.isKeyDown("e") && activeSpecial) {
            activeSpecial = false;
        }
        if (cooldownSpecial == 40 || cooldownSpecial == 20) {
            getWorld().addObject(new SpecialShot(), getX(), getY());
        }
    }

    public void checkCollision() {
        if(isTouching(Enemy1.class)){
            removeTouching(Enemy1.class);
            damage();
        } else if(isTouching(Enemy2.class)){
            removeTouching(Enemy2.class);
            damage();
        } else if(isTouching(Enemy3.class)){
            removeTouching(Enemy3.class);
            damage();
        }
    }
    
    public void damage() {
        hitSound.play();
        livesLeft--;
        if(0 < livesLeft) {
            getWorld().removeObject(lives[livesLeft]);
        } else {
            alive = false;
            getWorld().removeObject(lives[livesLeft]);
        }
    }
} 