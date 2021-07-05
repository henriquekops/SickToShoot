import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.MouseInfo;

public class developers extends Actor {
  private GreenfootImage on = new GreenfootImage("devOn.png");

  private GreenfootImage off = new GreenfootImage("devOff.png");

  private int mousex;

  private int mousey;

  private int x;

  private int y;

  public void act() {
    if (Greenfoot.mouseMoved(null)) {
      MouseInfo mouse = Greenfoot.getMouseInfo();
      int mousex = mouse.getX();
      int mousey = mouse.getY();
      int x = getX();
      int y = getY();
      if (mousex > x - 85 && mousex < x + 85 && mousey > y - 20 && mousey < y + 20) {
        setImage(this.on);
      } else {
        setImage(this.off);
      } 
    } 
    if (Greenfoot.mouseClicked(this))
      Greenfoot.setWorld(new dev()); 
  }
}