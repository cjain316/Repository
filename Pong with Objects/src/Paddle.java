import java.awt.Color;
import java.awt.Graphics;

public class Paddle {
    private int x, y;
    private int width, height;
    private Color c;
    private int vy;
    
    public Paddle(int newX, int newY) {
        x = newX;
        y = newY;
        width = 25;
        height = 100;
        c = Color.white;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public int getvY() {
        return vy;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    public void paint(Graphics g) {
        
        if ((y + vy) > 0 && (y+vy) < (564-height) ) {
            y += vy;
        }
        
        g.setColor(c);
        g.fillRect(x, y, width, height);
    
    }
    
    public void setVelocity(int newVy) {
        vy = newVy;
    }
    
    
}