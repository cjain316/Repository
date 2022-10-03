import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    //balls
    private int x;     
    private int y;
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    
    public int getSize() {
        return width;
    }
    
    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public Color getColor() {
        return color;
    }

    private int width;
    private Color color;
    private int vx, vy;
    

    public Ball() {
        
        x = (int)(Math.random()*(600-100+1))+100;
        y = (int)(Math.random()*(400-100+1))+100;
        
        width = 3;
        
        color = new Color(0, 0, 0);
        
        vx = 0;
        vy = 0;
                
    }
        
    public Ball(int newX, int newY, int newWidth) {
        x = newX;
        y = newY;
        width = newWidth;

        int red = 255;
        int green = 255;
        int blue = 255;
        color = new Color(red, green, blue);
    }
    
    public void setColor(Color c) {
        this.color = c;
    }
    public void setVelocityX(int vx) {
        this.vx = vx;
    }
    
    public void setVelocityY(int vy) {
        this.vy = vy;
    }
    

    public void paint(Graphics g) {
        

        x += vx;
        y += vy;
        

        g.setColor(color);
        

        g.fillRect(x, y, width, width);
        
    }
    
    
    
    
}