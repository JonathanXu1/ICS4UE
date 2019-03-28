import java.awt.*;

public class Square extends Shape {
    private double height;
    private double width;
    Square(double x, double y, double height, double width){
        super(x, y);
        this.height = height;
        this.width = width;
        this.boundingBox = new Rectangle((int)x, (int)y, (int)width, (int)height);
    }

    public double getArea(){
        return height*width;
    }

    public void setArea(double newArea){
        this.height = Math.sqrt(newArea);
        this.width = this.height;
    }

    public double getHeight(){
        return this.height;
    }

    public void setHeight(double newHeight){
        this.height = newHeight;
    }

    public double getWidth(){
        return this.width;
    }

    public void setWidth(double newWidth){
        this.width = newWidth;
    }
}
