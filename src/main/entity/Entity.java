package main.entity;

import main.GamePanel;

import java.awt.*;
import java.util.List;

public class Entity {

    protected Integer x;
    protected Integer y;

    protected Integer id;

    protected Rectangle rectangle;
    protected Integer speedX;
    protected Integer speedY;

    protected Rectangle bounds;

    protected Color color;

    protected GamePanel gamePanel;

    protected Boolean downCollision =false;
    protected Boolean upCollision =false;
    protected Boolean leftCollision =false;
    protected Boolean rightCollision =false;

    protected Boolean rightDownCollision = false;

    protected Boolean leftDownCollision = false;


    public Boolean getRightDownCollision() {
        return rightDownCollision;
    }

    public void setRightDownCollision(Boolean rightDownCollision) {
        this.rightDownCollision = rightDownCollision;
    }

    public Boolean getLeftUpCollision() {
        return leftUpCollision;
    }

    public void setLeftUpCollision(Boolean leftUpCollision) {
        this.leftUpCollision = leftUpCollision;
    }
    protected Boolean leftUpCollision = false;


    public Boolean getLeftDownCollision() {
        return leftDownCollision;
    }

    public void setLeftDownCollision(Boolean leftDownCollision) {
        this.leftDownCollision = leftDownCollision;
    }

    public Entity(Integer x, Integer y, Rectangle rectangle, Color color, Integer id) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.rectangle = rectangle;
        this.color = color;
        this.bounds = rectangle;
    }

    public void update() {

    }

    public void searchCollision(List<Entity> entities, GamePanel gamePanel){

    }

    protected void down(){

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Integer getSpeedX() {
        return speedX;
    }

    public void setSpeedX(Integer speedX) {
        this.speedX = speedX;
    }

    public Integer getSpeedY() {
        return speedY;
    }

    public void setSpeedY(Integer speedY) {
        this.speedY = speedY;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public Boolean getDownCollision() {
        return downCollision;
    }

    public void setDownCollision(Boolean downCollision) {
        this.downCollision = downCollision;
    }

    public Boolean getUpCollision() {
        return upCollision;
    }

    public void setUpCollision(Boolean upCollision) {
        this.upCollision = upCollision;
    }

    public Boolean getLeftCollision() {
        return leftCollision;
    }

    public void setLeftCollision(Boolean leftCollision) {
        this.leftCollision = leftCollision;
    }

    public Boolean getRightCollision() {
        return rightCollision;
    }

    public void setRightCollision(Boolean rightCollision) {
        this.rightCollision = rightCollision;
    }

    public Boolean isAnyCollision(){
        return downCollision || upCollision|| rightCollision || leftCollision;
    }
    public void clearCollision(){
        downCollision =false;
        upCollision = false;
        rightCollision = false;
        leftCollision = false;
        leftDownCollision = false;
        rightDownCollision = false;
    }

    protected static Boolean checkCollisionBetweenEntities(Entity item, Entity entity) {
        int wallLeft = entity.getX();
        int wallRight = entity.getX() + 24;
        int wallBottom = entity.getY();
        int wallTop = entity.getY() - 24;
        //PLAYER POSITIONS
        int playerLeft = item.getX();
        int playerRight = item.getX() + 24;
        int playerBottom = item.getY();
        int playerTop = item.getY() - 24;

        Boolean result =false;

        if (wallBottom == playerTop && wallTop < playerTop && wallRight > playerLeft && wallLeft < playerRight) {
            //System.out.println("up collision");
            item.setUpCollision(true);
            result = true;
        }
        if (wallTop == playerBottom && wallBottom > playerTop && wallRight > playerLeft && wallLeft < playerRight) {
            //System.out.println("down collision");
            item.setDownCollision(true);
            result = true;
        }
        if (wallRight >= playerLeft && wallLeft < playerRight && wallBottom > playerTop && wallTop < playerBottom) {
            //System.out.println("left collision");
            item.setLeftCollision(true);
            result = true;
        }
        if (wallLeft <= playerRight && wallRight > playerRight && wallBottom > playerTop && wallTop < playerBottom) {
            //System.out.println("right collision");
            item.setRightCollision(true);
            result = true;
        }
        return result;
    }

}
