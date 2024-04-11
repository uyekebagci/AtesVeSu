package main;

import main.entity.Entity;
import main.entity.Monsters;
import main.entity.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GamePanel extends JPanel implements Runnable {
    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16
    final int scale = 3;
    final int tileSize = originalTileSize * scale; // 48x48 tile
    final int maxScreenCol = 24;
    final int maxScreenRow = 16;
    final int screenWidth = tileSize * maxScreenCol; // 768 px
    final int screenHeight = tileSize * maxScreenRow; // 768 px

    //FPS
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    // Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    Player player = new Player(this, 76, 720, new Rectangle(tileSize / 2, tileSize / 2), Color.BLUE, keyH, 1);

    public List<Entity> entities = new ArrayList<>();
    public List<Entity> entitiesWillAdd = new ArrayList<>();
    public List<Entity> entitiesWillRemove = new ArrayList<>();

    Monsters monster = new Monsters(this,460, 590 - tileSize/2, new Rectangle(tileSize/2, tileSize/2),Color.ORANGE,10);

    public GamePanel() {
        entities.add(player);
        entities.add(monster);
        //entities.add(new Entity(400,400,new Rectangle(tileSize/2,tileSize/2),Color.GRAY));
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS; // 0.016666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        createWalls();
        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                //gravity();
                update();
                repaint();
                delta--;
                drawCount++;
            }
        }
    }

    public void gravity() {
        int gravity = player.getSpeedY() - 2;
        int umut = player.getY();
        umut += gravity;
        player.setY(umut);
    }

    private void createWalls() {
        int x = 400, y = 400;
        int size = tileSize / 2;
        for (int i = 0; i < 21; i++) {
            entities.add(new Entity(x + (i * (size / 2)), 400, new Rectangle(size, size), Color.WHITE, 2));
        }
        for (int i = 0; i < 80; i++) {
            entities.add(new Entity(x -376 + (i * (size / 2)), 645, new Rectangle(size, size), Color.WHITE, 2));
        }
        //top and bottom
        for (int i = 0; i < screenWidth; i++) {
            entities.add(new Entity(i, 0, new Rectangle(size, size), Color.WHITE, 2));
            entities.add(new Entity(i, 744, new Rectangle(size, size), Color.WHITE, 2));
        }
        // left and right walls
        for (int i = 0; i < screenHeight; i++) {
            entities.add(new Entity(0, 24 + i, new Rectangle(size, size), Color.WHITE, 2));
            entities.add(new Entity(1128, i + 24, new Rectangle(size, size), Color.WHITE, 2));
        }

        entities.add(new Entity(x, 400 - (size / 2), new Rectangle(size, size), Color.WHITE, 2));
        entities.add(new Entity(x, 400 - (size), new Rectangle(size, size), Color.WHITE, 2));
    }

    public void update() {
        if (keyH.player_1){
            player.setColor(Color.BLUE);
        }
        if (keyH.player_2){
            player.setColor(Color.RED);


        }
        if (keyH.player_3){
            player.setColor(Color.MAGENTA);
        }
        for (Entity entity : entities) {
            entity.update();
        }
        entities.addAll(entitiesWillAdd);
        entitiesWillAdd.clear();
        entities.removeAll(entitiesWillRemove);
        entitiesWillRemove.clear();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        List<Entity> entitiesCopy = new ArrayList<>(entities);

        Graphics2D g2 = (Graphics2D) g;
        for (Entity entity : entitiesCopy) {
            g2.setColor(entity.getColor());
            g2.fillRect(entity.getX(), entity.getY(), (int) entity.getRectangle().getWidth()
                    , (int) entity.getRectangle().getHeight());
            g2.setColor(Color.green);
            g2.drawString("X:" + player.getX() + "," + "Y:" + player.getY(), screenWidth - 90, 40);

        }
        g2.dispose();
    }

}