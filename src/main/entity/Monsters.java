package main.entity;

//import main.CollisionUtil;
import main.GamePanel;

import java.awt.*;
import java.util.List;

public class Monsters extends Entity {

    Integer gravity = 1;
    Integer speedLeft = 1;
    Integer speedRight = 1;

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    Integer life;

    public Monsters(GamePanel gamePanel, Integer x, Integer y,
                    Rectangle rectangle,
                    Color color, Integer id, Integer life) {
        super(x, y, rectangle, color, id);
        this.gamePanel = gamePanel;
        this.life = life;
    }

    public void update() {
        gravity = 1;
        searchCollision(gamePanel.entities, gamePanel);
        //CollisionUtil.checkCollision(this, gamePanel.entities, gamePanel);
        if (isAnyCollision()) {
            if (downCollision) {
                gravity = 0;
            }
            if (rightCollision || leftCollision) {
                speedRight = -speedRight;
            }
        }
        x += speedRight;
        fall();

        if (life < 1){
            gamePanel.entitiesWillRemove.add(this);
        }
    }

    @Override
    public void searchCollision(List<Entity> entities, GamePanel gamePanel) {
        this.clearCollision();
        for (Entity entity : entities) {
            if (entity instanceof Monsters) {
                continue;
            }
            Boolean result = checkCollisionBetweenEntities(this, entity);
            if (result && this.isAnyCollision() && entity instanceof ProjectTile) {
//                this.life--;
                if (entity.getColor() == this.getColor()){
                    this.life--;
                    gamePanel.entitiesWillRemove.add(entity);
                    System.out.println(this.getColor() + " " + "Canavarın "+"Canı: "+life);
                }
                else {
                    this.life++;
                    gamePanel.entitiesWillRemove.add(entity);
                    System.out.println(this.getColor() + " " + "Canavarın "+"Canı: "+life);
                }
            }
        }
    }

    public void right() {
        speedRight = 2;
        speedLeft = 0;
        if (rightCollision) {
            speedRight = 0;
            if (!downCollision) {
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
