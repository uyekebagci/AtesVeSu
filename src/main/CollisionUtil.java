//package main;
//
//import main.entity.Entity;
//import main.entity.Monsters;
//import main.entity.Player;
//import main.entity.ProjectTile;
//
//import java.util.List;
//
//public class CollisionUtil {
//    public static void checkCollision(Entity item, List<Entity> entities, GamePanel gamePanel) {
//        item.clearCollision();
//        if (item instanceof Monsters){
//            for (int i = 0; i < entities.size(); i++) {
//                Entity entity = entities.get(i);
//                //Check Player
//                if (entity instanceof Monsters) {
//                    continue;
//                }
//                //SIZE OF WALL AND PLAYER
//                //WALL POSITIONS
//                checkCollisionBetweenEntities(item, entity);
//                if (item.isAnyCollision() && entity instanceof Player){
//                    throw new RuntimeException("Game Over");
//                }
//            }
//        }else if (item instanceof Player){
//            for (int i = 0; i < entities.size(); i++) {
//                Entity entity = entities.get(i);
//                //Check Player
//                if (entity instanceof Player) {
//                    continue;
//                }
//                //SIZE OF WALL AND PLAYER
//                //WALL POSITIONS
//                checkCollisionBetweenEntities(item, entity);
//            }
//        }else if (item instanceof ProjectTile){
//            for (int i = 0; i < entities.size(); i++) {
//                Entity entity = entities.get(i);
//                //Check Player
//                if (entity instanceof ProjectTile) {
//                    continue;
//                }
//                //SIZE OF WALL AND PLAYER
//                //WALL POSITIONS
//                checkCollisionBetweenEntities(item, entity);
////                if (item.isAnyCollision() && entity instanceof Player){
////                    throw new RuntimeException("Game Over");
////                }
//                if (item.isAnyCollision() && entity instanceof Monsters){
//                    gamePanel.entitiesWillRemove.add(item);
//                    Monsters monster = ((Monsters) entity);
//                    int life = monster.getLife();
//                    life--;
//                    monster.setLife(life);
//                    if (monster.getLife() < 1) {
//                        gamePanel.entitiesWillRemove.add(monster);
//                    }
//                }
//            }
//        }
//    }
//
//
//}