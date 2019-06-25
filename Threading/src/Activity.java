import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Activity extends JFrame{
  static JFrame window;
  private JPanel gamePanel;
  private ArrayList<Shape> shapes = new ArrayList<>();
  private ArrayList<Shape> removeShapes = new ArrayList<>();
  private Random rand = new Random();

  public static void main(String[] args){
    window = new Activity();
  }

  Activity(){
    super("Circle Thing");

    // Set the frame to full screen
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
    // this.setUndecorated(true);

    //Set up the game panel (where we put our graphics)
    gamePanel = new GameAreaPanel();
    this.add(new GameAreaPanel());

    MyKeyListener keyListener = new MyKeyListener(this);
    this.addKeyListener(keyListener);

    this.requestFocusInWindow(); //make sure the frame has focus

    this.setVisible(true);
  }

  public void keyPressed(String key){
    Shape temp = new Shape(key);
    shapes.add(temp);
    Thread t = new Thread(temp);
    t.start();

  }

  private class GameAreaPanel extends JPanel {
    public void paintComponent(Graphics g) {
      boolean moved = false;
      int choice;

      super.paintComponent(g); //required
      setDoubleBuffered(true);

      // Draw shapes
      for(int i = 0; i < shapes.size(); i++){
        Shape circle = shapes.get(i);
        g.setColor(circle.getColor());
        g.fillOval(circle.getX(), circle.getY(), 50, 50);
        g.setColor(Color.BLUE);
        g.drawString(circle.getChar(), circle.getX(), circle.getY());
      }

      // Collision detection
      for(Shape i:shapes){
        for(Shape j:shapes){
          if(i != j && i.getChar().equals(j.getChar())){
            int xDist = Math.abs(i.getX() - j.getX());
            int yDist = Math.abs(i.getY() - j.getY());
            int distSquared = xDist * xDist + yDist * yDist;
            if(distSquared < 100){
              i.kill();
              j.kill();
              removeShapes.add(i);
              removeShapes.add(j);
            }
          }
        }
      }
      shapes.removeAll(removeShapes);
      removeShapes.clear();

      //repaint
      repaint();
    }
  }

  // -----------  Inner class for the keyboard listener - this detects key presses and runs the corresponding code
  private class MyKeyListener implements KeyListener {
    private Activity main;
    MyKeyListener(Activity main){
      this.main = main;
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
      //System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));

      main.keyPressed(KeyEvent.getKeyText(e.getKeyCode()));
    }

    public void keyReleased(KeyEvent e) {
    }
  } //end of keyboard listener
}
