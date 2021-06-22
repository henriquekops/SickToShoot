import greenfoot.*;

public class Enemy3 extends Actor
{
    private int vida = 3;
    private GreenfootSound sound = new GreenfootSound("eDead.wav");
    private GreenfootSound hit = new GreenfootSound("hit.wav");
    public void act(){
        followPlayer();
        try{
            verify();
        }catch(Exception e){

        }
    }

    public void followPlayer(){
        player player = (player) getObjectsInRange(1200,  player.class).get(0);
        if(player.getX() < getX()){
            setLocation(getX()-7, getY());
        }
        if(player.getX() > getX()){
            setLocation(getX()+7, getY());
        }
        if(player.getY() < getY()){
            setLocation(getX(), getY()-3);
        }
        if(player.getY() > getY()){
            setLocation(getX(), getY()+3);
        }
    }

    public void verify()throws Exception{
        Shoot shoot = (Shoot)getOneIntersectingObject(Shoot.class);
        MyWorld myWorld = (MyWorld) getWorld();
        sound.setVolume(75);
        hit.setVolume(70);
        if(shoot != null){
            getWorld().removeObject(shoot);
            myWorld.setPower();
            hit.play();
            vida--;
        }
        if(vida == 0){
            vida = 3;
            sound.play();
            getWorld().removeObject(this);
        }
        if(getX() <= 5){
            vida = 3;
            sound.play();
            getWorld().removeObject(this);
            myWorld.damage();
        }
    }
}
