import java.awt.*;
import java.util.Random;

public class Shape implements Runnable {
  private int maxX = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
  private int maxY = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
  private int x = maxX/2;
  private int y = maxY/2;

  private String text;
  private boolean alive = true;
  private Random rand = new Random();
  private double radians;

  private Color color;


  Shape(String value){
    this.text = value;
    this.radians = rand.nextDouble() * 2 * Math.PI;
    int r = rand.nextInt(256);
    int g = rand.nextInt(256);
    int b = rand.nextInt(256);
    this.color = new Color(r, g, b);
  }

  public void run(){
    while(this.alive){
      boolean valid = false;
      // Move
      x += (int) (Math.cos(radians) * 5);
      y += (int)(Math.sin(radians) * 5);

      // Bounce
      if(x < 0 || x+50 > maxX){
        radians = Math.PI - radians;
      }
      if(y < 0 || y+50 > maxY){
        radians = Math.PI * 2 - radians;
      }

      try{
        Thread.sleep(10);
      } catch (Exception e){
        System.out.println(e);
      }

    }
  }

  public void kill(){
    this.alive = false;
  }
  public Color getColor(){
    return this.color;
  }

  public int getX(){
    return this.x;
  }
  public int getY(){
    return this.y;
  }
  public String getChar(){
    return this.text;
  }
}
