import greenfoot.*;

public class Shoot extends Actor{
    private int conf = 0;
    public void act(){
        move(20);
        checkIfAtWorldEdge();
    }

    public void checkIfAtWorldEdge(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}

