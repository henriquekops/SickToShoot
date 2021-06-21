import greenfoot.*;
import java.util.Random;

public class MyWorld extends World
{
    private int loadPower = 0;
    SuperShotReady supershotready = new SuperShotReady();
    private int imageCount = 0;
    private GreenfootImage bgImage = new GreenfootImage("kk.jpg");
    private int lifeCont = 3;
    private Life life = new Life();
    private Life life2 = new Life();
    private Life life3 = new Life();

    private GreenfootSound sound = new GreenfootSound("igm.wav");
    private GreenfootSound dead = new GreenfootSound("pDead.wav");
    private GreenfootSound hit = new GreenfootSound("pHit.wav");
    public MyWorld(){    
        super(1000, 600, 1); 
        prepare();
    }

    private void prepare(){
        player player = new player(); 
        addObject(player,146,314);
        player.setRotation(90);
        addObject(supershotready,40,537);
        addObject(life,30,30);
        addObject(life2,70,30);
        addObject(life3,110,30);
        act();
        sound.playLoop();
    }

    public void act() {
        imageCount -= 5;
        drawBackgroundImage();
    }

    public void drawBackgroundImage() {
        if (imageCount > bgImage.getWidth()) {
            imageCount += bgImage.getWidth();
        }
        int temp = imageCount;
        try{
            getBackground().drawImage(bgImage, temp, 0);
            getBackground().drawImage(bgImage, temp + bgImage.getWidth(), 0);
        }catch(Exception e){}
    }

    public void setPower(){
        loadPower++;
        if(getPower() >= 5){
            supershotready.accept();
        }
    }

    public void setPower(boolean q){
        if(q){
            loadPower = 0;
            supershotready.reset();
        }
    }

    public int getPower(){
        return loadPower;
    }

    public void dano(){
        hit.play();
        lifeCont--;
        if(lifeCont == 0){
            dead.play();
            sound.stop();
            Fim fim = new Fim();
            Greenfoot.setWorld(fim);
        }
        if(lifeCont == 2){
            removeObject(life3);
        }
        if(lifeCont == 1){
            removeObject(life2);
        }
    }

    public void endLvl(){
        sound.stop();
        win win = new win();
        Greenfoot.setWorld(win);
    }
}
