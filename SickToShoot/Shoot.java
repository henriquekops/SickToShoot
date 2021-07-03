import greenfoot.*;

public class Shoot extends Actor{
    private int conf = 0;
    private int speed;
    
    public Shoot() {
        this.speed = 20;
    }
    
    public void act(){
        move(speed);
        checkIfAtWorldEdge();
    }

    public void checkIfAtWorldEdge(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}

