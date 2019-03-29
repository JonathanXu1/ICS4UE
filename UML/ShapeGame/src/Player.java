public class Player extends Circle implements Scalable, Moveable{
    Player(double x, double y, double radius){
        super(x, y, radius);
    }

    public void moveUp(){
        setY(getY() - 10);
        boundingBox.setLocation((int)getX(), (int)getY());
    }
    public void moveDown(){
        this.setY(this.getY() + 10);
        boundingBox.setLocation((int)getX(), (int)getY());
    }
    public void moveLeft(){
        this.setX(this.getX() - 10);
        boundingBox.setLocation((int)getX(), (int)getY());
    }
    public void moveRight(){
        this.setX(this.getX() + 10);
        boundingBox.setLocation((int)getX(), (int)getY());
    }

    public void grow(){
        this.setRadius(this.getRadius() + 20);
    }
    public void shrink(){
        this.setRadius(this.getRadius() - 20);
    }
}
