/**
 Shape Game
 A basic shape game
 Jonathan Xu
 February 6, 2019
 **/

//Graphics &GUI imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Color;

//Keyboard imports
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Util
import java.util.ArrayList;
import java.util.Random;

public class ShapeGame extends JFrame{
    //class variables
    static JFrame window;
    JPanel gamePanel;
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    Player character;
    private Random rand = new Random();
    final int MAX_WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    final int MAX_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    //Main
    public static void main(String[] args) {
        window = new ShapeGame();
    }

    //Constructor - this runs first
    ShapeGame() {
        super("My Game");

        //create enemies and player
        int spawnX, spawnY;
        spawnX = rand.nextInt(MAX_WIDTH-50);
        spawnY = rand.nextInt(MAX_HEIGHT-50);
        character = new Player(spawnX, spawnY, 15);

        //spawn 5 eneimies
        for(int i = 0; i < 5; i ++){
            spawnX = rand.nextInt(MAX_WIDTH-40);
            spawnY = rand.nextInt(MAX_HEIGHT-40);
            enemies.add(new Enemy(spawnX, spawnY, 40, 40));
        }

        // Set the frame to full screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        // this.setUndecorated(true);  //Set to true to remove title bar
        //frame.setResizable(false);


        //Set up the game panel (where we put our graphics)
        gamePanel = new GameAreaPanel();
        this.add(new GameAreaPanel());

        MyKeyListener keyListener = new MyKeyListener();
        this.addKeyListener(keyListener);

        this.requestFocusInWindow(); //make sure the frame has focus

        this.setVisible(true);



    } //End of Constructor

    /** --------- INNER CLASSES ------------- **/

    // Inner class for the the game area - This is where all the drawing of the screen occurs
    private class GameAreaPanel extends JPanel {
        public void paintComponent(Graphics g) {
            boolean moved = false;
            int choice;

            super.paintComponent(g); //required
            setDoubleBuffered(true);

            //move enemies
            for(int i = 0; i < enemies.size(); i++){
                choice = rand.nextInt(4);
                if(choice == 0 && enemies.get(i).getY() > 0){ //Move up
                    enemies.get(i).moveUp();
                } else if(choice == 1 && enemies.get(i).getY() < MAX_HEIGHT-40){ //Move down
                    enemies.get(i).moveDown();
                } else if(choice == 2 && enemies.get(i).getX() > 0){ //Move left
                    enemies.get(i).moveLeft();
                } else if(choice == 3 && enemies.get(i).getX() < MAX_WIDTH-40){ //Move right
                    enemies.get(i).moveRight();
                }
                //check for collision
                if(enemies.get(i).getBoundingBox().intersects(character.getBoundingBox())){
                    enemies.remove(i);
                    character.grow();
                }
            }

            //draw all squares
            g.setColor(Color.RED);
            for(int i = 0; i < enemies.size(); i++){
                g.fillRect((int)enemies.get(i).getX(),(int)enemies.get(i).getY(),(int)enemies.get(i).getWidth(),(int)enemies.get(i).getHeight());
            }

            //draw player circle
            g.setColor(Color.BLUE);
            g.fillOval((int)character.getX(),(int)character.getY(),(int)character.getRadius()*2,(int)character.getRadius()*2);

            //repaint
            repaint();
        }
    }

    // -----------  Inner class for the keyboard listener - this detects key presses and runs the corresponding code
    private class MyKeyListener implements KeyListener {

        public void keyTyped(KeyEvent e) {
        }

        public void keyPressed(KeyEvent e) {
            //System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));

            if (KeyEvent.getKeyText(e.getKeyCode()).equals("W")) {  //If 'W' is pressed
                character.moveUp();
            } else if (KeyEvent.getKeyText(e.getKeyCode()).equals("A")) {  //If 'A' is pressed
                character.moveLeft();
            } else if (KeyEvent.getKeyText(e.getKeyCode()).equals("S")) {  //If 'S' is pressed
                character.moveDown();
            } else if (KeyEvent.getKeyText(e.getKeyCode()).equals("D")) {  //If 'D' is pressed
                character.moveRight();
            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {  //If ESC is pressed
                System.out.println("Quitting!"); //close frame & quit
                window.dispose();

            }
        }

        public void keyReleased(KeyEvent e) {
        }
    } //end of keyboard listener
}
