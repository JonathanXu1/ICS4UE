import java.awt.Rectangle;

public class Circle extends Shape {
    private double radius;
    Circle (double x, double y, double radius){
        super(x, y);
        this. radius = radius;
        this.boundingBox = new Rectangle((int)x, (int)y,2*(int)radius, 2*(int)radius);
    }

    public double getArea(){
        return Math.pow(this.radius, 2) * Math.PI;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }

}
