import greenfoot.*;
import java.util.Random;
import java.io.*;

public class GameScreen extends World {
    private int loadPower, imageCount, spawn, spawnCooldown, spawnX, spawnY, bgSpeed, lastPlayerScore;
    
    private Random r;

    public Player player;
    public Text scoreText;
    public Placeholder placeholder;
    public SpecialIndicator specialIndicator;
    
    private GreenfootImage backgroundImage, scoreLargeImage, score, bestScore;
    private GreenfootSound backgroundSound;
    
    private LoseScreen loseScreen;
    private WinScreen winScreen;
    
    public GameScreen() {    
        super(1000, 600, 1);
        this.r = new Random();
        this.backgroundImage = new GreenfootImage("background.jpg");
        this.backgroundSound = new GreenfootSound("igm.wav");
        this.imageCount = 0;
        this.loadPower = 0;
        this.spawnCooldown = 0;
        this.loseScreen = new LoseScreen();
        this.winScreen = new WinScreen();
        this.spawnX = 999;
        this.bgSpeed = 5;
        addPlayer();
        addSpecialIndicator();
        addPlayerLives();
        addScore();
        //sound.playLoop();
        act();
    }
    
    private int readScore() {
        try {
            File file = new File("score.txt");
            FileInputStream inputStream = new FileInputStream(file);
            StringBuilder resultStringBuilder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String scoreStr = reader.readLine();
            reader.close();
            return Integer.parseInt(scoreStr);
        } catch(IOException | NumberFormatException e) {
            return 0;
        }
    }
    
    private void writeScore() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("score.txt", false));
            writer.printf("%d", player.score);
            writer.close();
        } catch (IOException e) {
            System.out.println("Save failed!");
        }
    }
    
    public void addPlayer() {
        this.player = new Player(readScore());
        this.player.setRotation(90);
        addObject(this.player, 146, 314);
    }
    
    public void addSpecialIndicator() {
        this.specialIndicator = new SpecialIndicator();
        addObject(this.specialIndicator, specialIndicator.x, specialIndicator.y);
    }
    
    public void addPlayerLives() {
        for (int i = 0; i < player.lives.length; i++) {
            addObject(this.player.lives[i], (40*i)+30, 30);
        }
    }
    
    public void addScore() {
        this.scoreText = new Text();
        this.placeholder = new Placeholder();
        addObject(this.placeholder, 900, 30);
        addObject(this.scoreText, 500, 300);
        this.score = this.scoreText.createText("Score: " + player.score, 24);
        this.bestScore = this.scoreText.createText("Best Score: " + player.bestScore, 24);
        this.scoreText.addText(this.score, 810, 30);
        this.scoreText.addText(this.bestScore, 810, 60);
        this.scoreText.draw();
    }
    
    public void act() {
        imageCount -= bgSpeed;
        spawnCooldown++;
        drawBackground();
        spawnEnemy();
        checkPlayerAlive();
        if (lastPlayerScore != player.score) {
            this.scoreText.clear();
            this.score = this.scoreText.createText("Score: " + player.score, 24);
            this.bestScore = this.scoreText.createText("Best Score: " + player.bestScore, 24);
            this.scoreText.addText(this.score, 820, 30);
            this.scoreText.addText(this.bestScore, 820, 60);
            this.scoreText.draw();
        }
        lastPlayerScore = player.score;
    }
    
    public void checkPlayerAlive() {
        if (!player.alive) {
            if (player.score > player.bestScore) {
                writeScore();
                setWinScreen();
            } else {
                setLoseScreen();
            }
        }
    }

    public void drawBackground() {
        if ((-1*imageCount) == backgroundImage.getWidth()) {
            imageCount = 0;
        }
        getBackground().drawImage(backgroundImage, imageCount, 0);
    }

    public void setWinScreen() {
        backgroundSound.stop();
        winScreen.trigger(player.score, player.bestScore);
        Greenfoot.setWorld(winScreen);
    }
    
    public void setLoseScreen() {
        backgroundSound.stop();
        loseScreen.trigger(player.score, player.bestScore);
        Greenfoot.setWorld(loseScreen);
    }
    
    public void spawnEnemy() {
        if (spawnCooldown >= 120) {
            spawn = r.nextInt(3)+1;
            spawnCooldown = 0;
            spawnY = r.nextInt(201)+200;
            switch(spawn) {
                case 1:
                    addObject(new Enemy1(),spawnX, spawnY);
                    break;
                case 2:
                    addObject(new Enemy2(),spawnX, spawnY);
                    break;
                case 3:
                    addObject(new Enemy3(),spawnX, spawnY);
                    break;
            }
        } 
    }
}