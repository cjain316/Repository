import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Frame extends JPanel implements KeyListener, ActionListener{
    boolean singleplayer = false;
    boolean noplayer = false;
    Color green = java.awt.Color.green;
    Paddle leftPaddle = new Paddle(50,225);
    Paddle rightPaddle = new Paddle(700,225);
    Ball newBall = new Ball(676,-25,30);
    Score score = new Score(0,0);

    public void paint(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 600);
        
	        g.setColor(Color.white);
	        g.drawString((score.getLeftScore() + " | " + score.getRightScore()), 385, 100);
	        
	        boolean winner = false;
	        
	        if (score.getLeftScore() > 4) {
	            winner = true;
	            g.drawString("Left Player Wins!", 350, 150);
	        }
	        if (score.getRightScore() > 4) {
	            winner = true;
	            g.drawString("Right Player Wins!", 350, 150);
	        }
	        
	        if (winner == false) {
	            if (newBall.getX()>800) {
	                score.leftScores();
	                newBall.setVelocityX(0);
	                newBall.setX(676);
	                newBall.setY(-25);
	                if (singleplayer == true) {
	                    rightPaddle.setY(225);
	                }
	            }
	            if (newBall.getX()<-50) {
	                score.rightScores();
	                newBall.setVelocityX(0);
	                newBall.setX(676);
	                newBall.setY(-25);
	                if (singleplayer == true) {
	                    rightPaddle.setY(225);
	                }
	            }
	          
	            
	            if (singleplayer) {
	                if (winner == false) {
	                    if (newBall.getVx() > 0 && newBall.getX() > 350) {
	                        if (newBall.getY() > rightPaddle.getY()) {
	                            rightPaddle.setVelocity(7);
	                        }
	                        if (newBall.getY() < rightPaddle.getY()) {
	                            rightPaddle.setVelocity(-7);
	                        }
	                    } else {
	                        rightPaddle.setVelocity(0);
	                    }
	                }
	            }

	            if (newBall.getY()>505) {
	                newBall.setVelocityY(-7);
	            }
	            if (newBall.getY()<0) {
	                newBall.setVelocityY(7);
	            }
	            if (colliding(newBall,leftPaddle)) {
	                newBall.setVelocityX(11);
	                if (leftPaddle.getvY() > 0) {
	                	newBall.setVelocityY(7);
	                }
	                if (leftPaddle.getvY() < 0) {
	                	newBall.setVelocityY(-7);
	                }
	            }
	            if (colliding(newBall,rightPaddle)) {
	                newBall.setVelocityX(-11);
	                if (rightPaddle.getvY() > 0) {
	                	newBall.setVelocityY(7);
	                }
	                if (rightPaddle.getvY() < 0) {
	                	newBall.setVelocityY(-7);
	                }
	            }
	            
	            
	            leftPaddle.paint(g);
	            rightPaddle.paint(g);
	            newBall.paint(g);
	        }
	}
    
    
    public static void main(String[] arg) {
        Frame f = new Frame();
    }    
    
    @Override
    public void keyPressed(KeyEvent arg) {
            if (arg.getExtendedKeyCode() == 87) {
                    leftPaddle.setVelocity(-7);
            }
            if (arg.getExtendedKeyCode() == 83) {
                    leftPaddle.setVelocity(7);
            }
            if (singleplayer == false) {
                if (arg.getExtendedKeyCode() == 38) {
                        rightPaddle.setVelocity(-7);
                }
                if (arg.getExtendedKeyCode() == 40) {
                        rightPaddle.setVelocity(7);
                }
            }
        }

    @Override
    public void keyReleased(KeyEvent arg) {
            if (arg.getExtendedKeyCode() == 87) {
                leftPaddle.setVelocity(0);
            }
            if (arg.getExtendedKeyCode() == 83) {
                leftPaddle.setVelocity(0);
            }
            if (singleplayer == false) {
                if (arg.getExtendedKeyCode() == 38) {
                    rightPaddle.setVelocity(0);
                }
                if (arg.getExtendedKeyCode() == 40) {
                    rightPaddle.setVelocity(0);
                }
            }
        }
    

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    
    public static boolean colliding(Ball b, Paddle p){
        int ballposx = b.getX();
        int ballposy = b.getY();
        int minx = p.getX();
        int miny = p.getY();
        int maxx = p.getX() + p.getWidth();
        int maxy = p.getY() + p.getHeight();
        
        if (ballposx < maxx) {
            if (ballposy < maxy) {
                if (ballposx > minx) {
                    if (ballposy > miny) {
                        return true;
                    }
                }
            }
        }
        if (ballposx + b.getSize() < maxx) {
            if (ballposy + b.getSize() < maxy) {
                if (ballposx + b.getSize() > minx) {
                    if (ballposy + b.getSize() > miny) {
                        return true;
                    }
                }
            }
        }
        if (ballposx + b.getSize()/2 < maxx) {
            if (ballposy + b.getSize()/2 < maxy) {
                if (ballposx + b.getSize()/2 > minx) {
                    if (ballposy + b.getSize()/2 > miny) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        repaint();
    }
    
    Timer t;
    
    public Frame() {
        JFrame f = new JFrame("Pong");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800,600);
        f.add(this);
        f.addKeyListener(this);
        
        t = new Timer(7, this);
        t.start();
        f.setVisible(true);
       
        
    }
    
}
