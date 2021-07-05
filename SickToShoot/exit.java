import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.GreenfootSound;
import greenfoot.MouseInfo;

public class exit extends Actor {
  private GreenfootImage on = new GreenfootImage("homeOn.png");

  private GreenfootImage off = new GreenfootImage("homeOff.png");

  private int mousex;

  private int mousey;

  private int x;

  private int y;

  private boolean v = true;

  private GreenfootSound sound = new GreenfootSound("winner.wav");

  public void act() {
    if (this.v) {
      this.sound.play();
      this.v = false;
    } 
    if (Greenfoot.mouseMoved(null)) {
      MouseInfo mouse = Greenfoot.getMouseInfo();
      int mousex = mouse.getX();
      int mousey = mouse.getY();
      int x = getX();
      int y = getY();
      if (mousex > x - 65 && mousex < x + 65 && mousey > y - 20 && mousey < y + 20) {
        setImage(this.on);
      } else {
        setImage(this.off);
      } 
    } 
    if (Greenfoot.mouseClicked(this))
      Greenfoot.setWorld(new menu()); 
  }
}