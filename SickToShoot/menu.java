import greenfoot.World;

public class menu extends World {
  public menu() {
    super(1000, 600, 1);
    prepare();
  }

  private void prepare() {
    playOff playoff = new playOff();
    addObject(playoff, 670, 220);
    control control = new control();
    addObject(control, 707, 270);
    developers developers = new developers();
    addObject(developers, 723, 320);
  }
}