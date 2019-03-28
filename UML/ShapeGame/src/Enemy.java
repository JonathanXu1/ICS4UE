public class Enemy extends Square implements Moveable{
    Enemy(double x, double y, double height, double width){
        super(x, y, height, width);
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
}
