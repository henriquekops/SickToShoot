import greenfoot.*;

public class Shoot extends Actor{
    private int conf = 0;
    public void act(){
        move(20);
        verify();
    }

    public void verify(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}

