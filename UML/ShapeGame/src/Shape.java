import java.awt.Rectangle;

public abstract class Shape {
    private double x;
    private double y;
    Rectangle boundingBox;
    Shape(double x, double y){
        this.x = x;
        this.y = y;
    }

    public abstract double getArea();

    public Rectangle getBoundingBox(){
        return this.boundingBox;
    }

    public void setX(double x){
        this.x = x;
    }

    public double getX(){
        return this.x;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getY(){
        return this.y;
    }
}
