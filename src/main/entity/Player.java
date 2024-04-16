package main.entity;

//import main.CollisionUtil;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.util.List;

public class Player extends Entity {

    Integer gravity = 1;
    KeyHandler keyH;

    public Player(GamePanel gamePanel, Integer x, Integer y, Rectangle rectangle, Color color, KeyHandler keyH, Integer id) {
        super(x, y, rectangle, color, id);
        speedX = 10;
        speedY = 4;
        //speed = 4;
        this.keyH = keyH;
        this.gamePanel = gamePanel;
    }

    @Override
    public void update() {
        //FIRE
        if (keyH.space) {
            keyH.space = false;
            ProjectTile fire = new ProjectTile(x + 8, y + 4, new Rectangle(4, 4), color, 3,gamePanel);
            if (this.getColor() != Color.MAGENTA) {
                gamePanel.entitiesWillAdd.add(fire);
            }
        }
        searchCollision(gamePanel.entities, gamePanel);

        if (this.isAnyCollision()) {
            speedX = 2;
            if (downCollision) {
                speedY = 0;
                if (keyH.upPressed) {
                    if (this.getColor() != Color.MAGENTA) {
                        speedY = 4;
                    } else {
                        speedY = 10;
                    }
                    y -= speedY;
                }
            }
            if (upCollision) {
                speedY = 0;
                fall();
            } else {
                speedY = 2;
            }
            up();
            right();
            left();
            return;
        }
        fall();
        up();
        right();
        left();
    }

    @Override
    public void searchCollision(List<Entity> entities, GamePanel gamePanel) {
        this.clearCollision();
        for (Entity entity : entities) {
            if (entity instanceof Player) {
                continue;
            }
            Boolean result = checkCollisionBetweenEntities(this, entity);
            if (result && this.isAnyCollision() && entity instanceof Monsters) {
                throw new RuntimeException("Game Over");
            }
        }
    }

    private void up() {
        if (keyH.upPressed) {
            y -= speedY;
        }
    }

    private void left() {
        if (leftCollision) {
            if (!downCollision) {
                fall();
            }
            return;
        }
        if (keyH.leftPressed) {
            x -= speedX;
        }
    }

    private void right() {
        if (rightCollision) {
            if (!downCollision) {
                fall();
            }
            return;
        }
        if (keyH.rightPressed) {
            x += speedX;
            // System.out.println("Current Position = " + playerX + "," + playerY);
        }
    }

    private void fall() {
        y += gravity;
    }
}