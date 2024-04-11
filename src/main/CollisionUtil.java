package main;

import main.entity.Entity;
import main.entity.Monsters;
import main.entity.Player;
import java.util.List;

public class CollisionUtil {
    public static void checkCollision(Entity item, List<Entity> entities) {
        item.clearCollision();
        if (item instanceof Monsters){
            for (int i = 0; i < entities.size(); i++) {
                Entity entity = entities.get(i);
                //Check Player
                if (entity instanceof Monsters) {
                    continue;
                }
                //SIZE OF WALL AND PLAYER
                //WALL POSITIONS
                int wallLeft = entity.getX();
                int wallRight = entity.getX() + 24;
                int wallBottom = entity.getY();
                int wallTop = entity.getY() - 24;
                //PLAYER POSITIONS
                int playerLeft = item.getX();
                int playerRight = item.getX() + 24;
                int playerBottom = item.getY();
                int playerTop = item.getY() - 24;

                if (wallBottom == playerTop && wallTop < playerTop && wallRight > playerLeft && wallLeft < playerRight) {
                    System.out.println("up collision");
                    item.setUpCollision(true);
                }
                if (wallTop == playerBottom && wallBottom > playerTop && wallRight > playerLeft && wallLeft < playerRight) {
                    System.out.println("down collision");
                    item.setDownCollision(true);
                }
                if (wallRight >= playerLeft && wallLeft < playerRight && wallBottom > playerTop && wallTop < playerBottom) {
                    System.out.println("left collision");
                    item.setLeftCollision(true);
                }
                if (wallLeft <= playerRight && wallRight > playerRight && wallBottom > playerTop && wallTop < playerBottom) {
                    System.out.println("right collision");
                    item.setRightCollision(true);
                }
            }
        }else if (item instanceof Player){
            for (int i = 0; i < entities.size(); i++) {
                Entity entity = entities.get(i);
                //Check Player
                if (entity instanceof Player) {
                    continue;
                }
                //SIZE OF WALL AND PLAYER
                //WALL POSITIONS
                int wallLeft = entity.getX();
                int wallRight = entity.getX() + 24;
                int wallBottom = entity.getY();
                int wallTop = entity.getY() - 24;
                //PLAYER POSITIONS
                int playerLeft = item.getX();
                int playerRight = item.getX() + 24;
                int playerBottom = item.getY();
                int playerTop = item.getY() - 24;

                if (wallBottom == playerTop && wallTop < playerTop && wallRight > playerLeft && wallLeft < playerRight) {
                    System.out.println("up collision");
                    item.setUpCollision(true);
                }
                if (wallTop == playerBottom && wallBottom > playerTop && wallRight > playerLeft && wallLeft < playerRight) {
                    System.out.println("down collision");
                    item.setDownCollision(true);
                }
                if (wallRight >= playerLeft && wallLeft < playerRight && wallBottom > playerTop && wallTop < playerBottom) {
                    System.out.println("left collision");
                    item.setLeftCollision(true);
                }
                if (wallLeft <= playerRight && wallRight > playerRight && wallBottom > playerTop && wallTop < playerBottom) {
                    System.out.println("right collision");
                    item.setRightCollision(true);
                }
            }
        }
    }
}