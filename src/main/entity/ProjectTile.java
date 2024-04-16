package main.entity;

//import main.CollisionUtil;
import main.GamePanel;

import java.awt.*;
import java.util.List;

public class ProjectTile extends Entity{
    public ProjectTile(Integer x, Integer y, Rectangle rectangle, Color color, Integer id,GamePanel gamePanel) {
        super(x, y, rectangle, color, id);
        this.gamePanel = gamePanel;
        speedX = 4;
    }

    @Override
    public void update() {
//        CollisionUtil.checkCollision(this,gamePanel.entities,gamePanel);
        super.update();
        searchCollision(gamePanel.entities, gamePanel);
        x += speedX;
    }

    @Override
    public void searchCollision(List<Entity> entities, GamePanel gamePanel) {
        this.clearCollision();
        for (Entity entity : entities) {
            if (entity instanceof Monsters) {
                continue;
            }
            if (entity instanceof Player) {
                continue;
            }
            checkCollisionBetweenEntities(this, entity);
        }
    }
}
