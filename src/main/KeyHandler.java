package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.lang.Thread.sleep;

public class KeyHandler implements KeyListener {

    public boolean upPressed, leftPressed, rightPressed, space, player_1,
    player_2, player_3;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if(code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D) {
            rightPressed = true;
        }
        if (code == KeyEvent.VK_SPACE && !space){
            space = true;
        }
        if (code == KeyEvent.VK_1 && !player_1){
            player_1 = true;
        }
        if (code == KeyEvent.VK_2 && !player_2){
            player_2 = true;
        }
        if (code == KeyEvent.VK_3 && !player_3){
            player_3 = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if(code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D) {
            rightPressed = false;
        }
        if (code == KeyEvent.VK_SPACE){
            space = false;
        }
        if (code == KeyEvent.VK_1){
            player_1 = false;
        }
        if (code == KeyEvent.VK_2){
            player_2 = false;
        }
        if (code == KeyEvent.VK_3){
            player_3 = false;
        }
    }
}
