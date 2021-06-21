import greenfoot.*;

public class Fim extends World
{
    private restart restart = new restart();
    public Fim()
    {    
        super(1000, 600, 1);
        prepare();
    }

    public void prepare(){
        addObject(restart,500,500);
    }
}
