package main.entity;

import java.awt.*;

public class ProjectTile extends Entity{
    public ProjectTile(Integer x, Integer y, Rectangle rectangle, Color color, Integer id) {
        super(x, y, rectangle, color, id);

        speedX = 4;
    }

    @Override
    public void update() {
        super.update();

        x += speedX;
    }
}
