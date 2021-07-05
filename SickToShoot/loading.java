import greenfoot.Actor;
import greenfoot.Greenfoot;

public class loading extends Actor {
  int i = 0;

  private boolean conf = false;

  public void act() {
    setRotation(this.i);
    this.i += 5;
    if (this.i > 720)
      Greenfoot.setWorld(new GameScreen()); 
  }
}