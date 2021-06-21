import greenfoot.*;

public class specialShoot extends Actor{
    private int cont = 0;
    private GreenfootImage h1 = new GreenfootImage("hamburger.png");
    private GreenfootImage h2 = new GreenfootImage("hamburger2.png");
    public void act(){
        move(15);
        verify();
        cont++;
        if(cont%5 == 0 && cont%10 != 0){
            setImage(h2);
        }
        if(cont%10 == 0){
            setImage(h1);
        }
        try{
            destroyEnemies();
        }catch(Exception e){

        }
    }

    public void verify(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }

    public void destroyEnemies()
    {
        if(isTouching(Enemy1.class)){
            removeTouching(Enemy1.class);
        }
        if(isTouching(Enemy2.class)){
            removeTouching(Enemy2.class);
        }
        if(isTouching(Enemy3.class)){
            removeTouching(Enemy3.class);
        }
    }
}