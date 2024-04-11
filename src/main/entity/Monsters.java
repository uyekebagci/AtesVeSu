package main.entity;

import main.CollisionUtil;
import main.GamePanel;

import java.awt.*;

public class Monsters extends Entity {

    Integer gravity = 1;
    Integer speedLeft = 2;
    Integer speedRight = 2;

    public Monsters(GamePanel gamePanel, Integer x, Integer y,
                    Rectangle rectangle,
                    Color color, Integer id) {
        super(x, y, rectangle, color, id);
        this.gamePanel = gamePanel;
    }

    public void update() {
        gravity = 1;
        CollisionUtil.checkCollision(this, gamePanel.entities);
        if (isAnyCollision()) {
            if (downCollision){
                gravity = 0;
            }
            if (rightCollision || leftCollision){
                speedRight = -speedRight;
            }
        }
        x += speedRight;
        fall();
    }

    public void right() {
        speedRight = 2;
        speedLeft = 0;
        if (rightCollision) {
            speedRight = 0;
            if(!downCollision) {
                fall();
            }
        } else {
            x += speedRight;
        }
    }

    public void left() {
        speedLeft = 2;
        speedRight = 0;
        if (leftCollision) {
            speedLeft = 0;
            if (!downCollision) {
                fall();
            }
        } else {
            x -= speedLeft;
        }
    }

    private void fall() {
        y += gravity;
    }
}
