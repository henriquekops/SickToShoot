import greenfoot.World;

public class dev extends World {
  World w;
  
  public dev(World w) {
    super(1000, 600, 1);
    this.w = w;
    back back = new back(w);
    addObject(back, 45, 30);
  }
}