import greenfoot.*;
import java.util.Random;

public class GameScreen extends World {
    private int loadPower, imageCount, spawn, spawnCooldown, spawnX, spawnY, bgSpeed;
    
    private Random r;

    public Player player;
    public SpecialIndicator specialIndicator;
    
    private GreenfootImage backgroundImage;
    private GreenfootSound backgroundSound;
    
    private LoseScreen loseScreen;
    private WinScreen winScreen;
    
    public GameScreen() {    
        super(1000, 600, 1);
        this.r = new Random();
        this.backgroundImage = new GreenfootImage("background.jpg");
        this.backgroundSound = new GreenfootSound("igm.wav");
        this.imageCount = 0;
        this.loadPower = 0;
        this.spawnCooldown = 0;
        this.loseScreen = new LoseScreen();
        this.winScreen = new WinScreen();
        this.spawnX = 999;
        this.bgSpeed = 5;
        addPlayer();
        addSpecialIndicator();
        addPlayerLives();
        //sound.playLoop();
        act();
    }
    
    public void addPlayer() {
        this.player = new Player();
        this.player.setRotation(90);
        addObject(this.player,146,314);
    }
    
    public void addSpecialIndicator() {
        this.specialIndicator = new SpecialIndicator();
        addObject(specialIndicator, specialIndicator.x, specialIndicator.y);
    }
    
    public void addPlayerLives() {
        for (int i = 0; i < player.lives.length; i++) {
            addObject(player.lives[i], (40*i)+30, 30);
        }
    }

    public void act() {
        imageCount -= bgSpeed;
        spawnCooldown++;
        drawBackground();
        //spawnEnemy();
        checkPlayerAlive();
    }
    
    public void checkPlayerAlive() {
        if (!player.alive) {
            setLoseScreen();
        }
    }

    public void drawBackground() {
        if ((-1*imageCount) == backgroundImage.getWidth()) {
            imageCount = 0;
        }
        getBackground().drawImage(backgroundImage, imageCount, 0);
    }

    public void setWinScreen() {
        backgroundSound.stop();
        Greenfoot.setWorld(winScreen);
    }
    
    public void setLoseScreen() {
        backgroundSound.stop();
        loseScreen.trigger();
        Greenfoot.setWorld(loseScreen);
    }
    
    public void spawnEnemy() {
        if (spawnCooldown >= 120) {
            spawn = r.nextInt(3)+1;
            spawnCooldown = 0;
            spawnY = r.nextInt(580)+20;
            switch(spawn) {
                case 1:
                    addObject(new Enemy1(),spawnX,spawnY);
                    break;
                case 2:
                    addObject(new Enemy2(),spawnX,spawnY);
                    break;
                case 3:
                    addObject(new Enemy3(),spawnX,spawnY);
                    break;
            }
        } 
    }
}