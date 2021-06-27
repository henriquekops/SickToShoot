import greenfoot.*;
import java.util.Random;
import java.util.LinkedList;

public class GameScreen extends World {
    private int LIFE_COUNT = 3;
    private int spawnX;
    private int loadPower, imageCount, livesLeft, spawn, spawnCooldown, spawnY;
    
    private Random r;
    
    private Life[] lives;
    private LinkedList<Actor> enemies;
    private Player player;
    private SuperShotReady superShotReady;
    
    private GreenfootImage backgroundImage;
    private GreenfootSound backgroundSound, hitSound;
    
    LoseScreen loseScreen;
    WinScreen winScreen;
    
    public GameScreen(){    
        super(1000, 600, 1);
        this.r = new Random();
        this.enemies = new LinkedList<Actor>();
        this.superShotReady = new SuperShotReady();
        this.backgroundImage = new GreenfootImage("background.jpg");
        this.backgroundSound = new GreenfootSound("igm.wav");
        this.hitSound = new GreenfootSound("pHit.wav");
        this.imageCount = 0;
        this.loadPower = 0;
        this.spawnCooldown = 0;
        this.livesLeft = LIFE_COUNT;
        this.lives = new Life[3];
        this.player = new Player();
        this.loseScreen = new LoseScreen();
        this.winScreen = new WinScreen();
        this.spawnX = 999;
        addObjectsToWorld();
        act();
    }
    
    private void addObjectsToWorld(){
        this.player.setRotation(90);
        addObject(this.player,146,314);
        addObject(new SuperShotReady(),40,537);
        for (int i = 0; i < LIFE_COUNT; i++ ) { 
            lives[i] = new Life();
            addObject(lives[i], (40*i)+30, 30);
        }
        //sound.playLoop();
    }

    public void act() {
        imageCount -= 5;
        spawnCooldown++;
        drawBackground();
        spawnEnemy();
    }

    public void drawBackground() {
        if (imageCount > backgroundImage.getWidth()) {
            imageCount += backgroundImage.getWidth();
        }
        int temp = imageCount;
        try{
            getBackground().drawImage(backgroundImage, temp, 0);
            getBackground().drawImage(backgroundImage, temp + backgroundImage.getWidth(), 0);
        }catch(Exception e){}
    }

    public void setPower(){
        loadPower++;
        if(getPower() >= 5){
            superShotReady.accept();
        }
    }

    public void setPower(boolean used){
        if(used){
            loadPower = 0;
            superShotReady.reset();
        }
    }

    public void damage(){
        hitSound.play();
        livesLeft--;
        if(0 < livesLeft && livesLeft < LIFE_COUNT){
            removeObject(lives[livesLeft]);
        } else {
            setLoseScreen();
        }
    }
    
    public int getPower(){
        return loadPower;
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