import greenfoot.*;

public class LoseScreen extends World
{
    private GreenfootSound sound;
    
    private Text scoreText;
    
    public LoseScreen()
    {    
        super(1000, 600, 1);
        this.sound = new GreenfootSound("pDead.wav");
        this.scoreText = new Text();
        addObject(this.scoreText, 500, 300);
    }
    
    public void trigger(int currentScore, int bestScore) {
        sound.play();
        GreenfootImage bestScoreImg = this.scoreText.createText("Best score: " + bestScore, 35);
        GreenfootImage currentScoreImg = this.scoreText.createText("Current Score: " + currentScore, 45);
        this.scoreText.addTitleText(currentScoreImg, 500, 460);
        this.scoreText.addTitleText(bestScoreImg, 500, 495);
        this.scoreText.draw();
    }
}
