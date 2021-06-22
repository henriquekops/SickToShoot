import greenfoot.*;
import java.util.Random;

public class MyWorld extends World
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
    private GreenfootSound deadSound;
    private GreenfootSound hitSound;
    
    public MyWorld(){    
        super(1000, 600, 1);
        this.superShotReady = new SuperShotReady();
        this.backgroundImage = new GreenfootImage("kk.jpg");
        this.backgroundSound = new GreenfootSound("igm.wav");
        this.deadSound = new GreenfootSound("pDead.wav");
        this.hitSound = new GreenfootSound("pHit.wav");
        this.imageCount = 0;
        this.loadPower = 0;
        this.livesLeft = LIFE_COUNT;
        this.lives = new Life[3];
        this.player = new player();
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
        if(livesLeft == 0){
            deadSound.play();
            backgroundSound.stop();
            Fim fim = new Fim();
            Greenfoot.setWorld(fim);
        }
        if(livesLeft == 2){
            removeObject(lives[livesLeft]);
        }
        if(livesLeft == 1){
            removeObject(lives[livesLeft]);
        }
    }
    
    public int getPower(){
        return loadPower;
    }

    public void endLvl() {
        backgroundSound.stop();
        win win = new win();
        Greenfoot.setWorld(win);
    }
}
