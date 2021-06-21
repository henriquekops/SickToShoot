import greenfoot.*;
import java.util.Random;

public class player extends Actor
{ 
    private int cooldown = 0;
    private int cooldownSS = 0;
    private Random r = new Random();
    private GreenfootSound sound = new GreenfootSound("shoot.wav");
    private GreenfootSound ss = new GreenfootSound("ss.wav");
    private GreenfootSound ss2 = new GreenfootSound("ss.wav");
    private GreenfootSound ss3 = new GreenfootSound("ss.wav");
    private int spawn1 = 0;
    private int spawn2 = 0;
    private int spawn3 = 0;
    
    private int timer = 1580;
    public void act()
    {
        ss.setVolume(80);
        ss2.setVolume(80);
        ss3.setVolume(80);
        movement();
        shoot();
        contss();
        damage();
        cooldown--;
        cooldownSS--;
        spawn();
        spawn1++;
        spawn2++;
        spawn3++;
        MyWorld myWorld = (MyWorld) getWorld();
        if(myWorld.getPower() >= 5){
            superPower();
        }
        
        if (timer>0)
        {
            timer--;
            if(timer == 0) {
                MyWorld world = (MyWorld) getWorld();
                world.endLvl();
            }
        }
    }

    public void movement(){
        if(Greenfoot.isKeyDown("s")){
            move(6);
        }
        if(Greenfoot.isKeyDown("w")){
            move(-6);
        }
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX()+6, getY());
        }
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX()-6, getY());
        }
    }

    public void shoot(){
        Shoot shoot = new Shoot();
        if(Greenfoot.isKeyDown("space")  && cooldown <= 0){
            sound.setVolume(60);
            sound.play();
            getWorld().addObject(shoot,getX(),getY());
            cooldown = 15;
        }
    }

    public void superPower(){
        MyWorld myWorld = (MyWorld) getWorld();
        SuperShotReady s = new SuperShotReady();
        boolean v = false;
        if(Greenfoot.isKeyDown("e")){
            ss.play();
            specialShoot ss = new specialShoot();
            getWorld().addObject(ss,getX(),getY());
            myWorld.setPower(true);
            v = true;
            cooldownSS = 58;
        }       
    }

    public void contss(){
        if(cooldownSS== 40 || cooldownSS == 20){
            if(cooldownSS == 20){
                ss2.play();
            } else { ss3.play();}
            specialShoot ss = new specialShoot();
            getWorld().addObject(ss,getX(),getY());
        }
    }

    public void damage(){
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Enemy1.class)){
            removeTouching(Enemy1.class);
            world.dano();
        }
        if(isTouching(Enemy2.class)){
            removeTouching(Enemy2.class);
            world.dano();
        }
        if(isTouching(Enemy3.class)){
            removeTouching(Enemy3.class);
            world.dano();
        }
    }

    public void spawn(){
        if(spawn1 > 150){
            Enemy1 enemy1 = new Enemy1();
            getWorld().addObject(enemy1,999,r.nextInt(580)+20);
            spawn1 = 0;
        }
        if(spawn2 == 225){
            Enemy2 enemy2 = new Enemy2();
            getWorld().addObject(enemy2,999,r.nextInt(580)+20);
            spawn2 = 0;
        }
        if(spawn3 == 200){
            Enemy3 enemy3 = new Enemy3();
            getWorld().addObject(enemy3,999,r.nextInt(580)+20);
            spawn3 = 0;
        }
    }
} 