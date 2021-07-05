import greenfoot.World;

public class load extends World {
  public load() {
    super(1000, 600, 1);
    prepare();
  }

  public void prepare() {
    loading restart = new loading();
    addObject(restart, 950, 560);
  }
}