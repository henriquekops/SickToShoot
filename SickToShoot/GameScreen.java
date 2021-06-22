import greenfoot.*;
import java.util.Random;

public class GameScreen extends World
{
    private int LIFE_COUNT = 3;
    private int loadPower;
    private int imageCount;
    private int livesLeft;
    
    private GreenfootImage backgroundImage;
    private SuperShotReady superShotReady;
    private Life[] lives;
    private player player;
    
    private GreenfootSound backgroundSound;
    private GreenfootSound hitSound;
    
    LoseScreen loseScreen;
    WinScreen winScreen;
    
    public GameScreen(){    
        super(1000, 600, 1);
        this.superShotReady = new SuperShotReady();
        this.backgroundImage = new GreenfootImage("kk.jpg");
        this.backgroundSound = new GreenfootSound("igm.wav");
        this.hitSound = new GreenfootSound("pHit.wav");
        this.imageCount = 0;
        this.loadPower = 0;
        this.livesLeft = LIFE_COUNT;
        this.lives = new Life[3];
        this.player = new player();
        this.loseScreen = new LoseScreen();
        this.winScreen = new WinScreen();
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
        drawBackground();
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
}
