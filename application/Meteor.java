import java.awt.Color;
import java.awt.Graphics;


public class Meteor {
	
	int y, x, yVel, xVel, color;
	
	public Meteor(){
		y = 0;
		x = randomPos();
		yVel = randomSpeed();
		color = randomColor();
	}
	
	public void reset(){
		y = 0;
		x = randomPos();
		yVel = randomSpeed();
		color = randomColor();
	}
	
	private int randomPos(){
		return (int)(Math.random()*580 + 10);
	}
	
	private int randomSpeed(){
		return (int)(Math.random()*7 + 1);
	}
	
	private int randomColor(){
		return (int)(Math.random()*4 + 1);
	}
	
	public void draw(Graphics g){
		if(color == 1){
			g.setColor(Color.RED);
		}else if(color == 2){
			g.setColor(Color.BLUE);
		}else{
			g.setColor(Color.BLACK);
		}
		g.fillOval(x+25, y+25, 50, 50);
	}
	
	public void move(){
		y += yVel;
		
		if(y > 550){
			color = randomColor();
			y=0;
			yVel = randomSpeed();
			x=randomPos();
		}
	}
	//FIX!!!!!!!!!!!11
	public boolean checkCollision(Flyer f){
		if(x>f.getX()-50&&x<f.getX()+50){
			if(y>f.getY()-50&&y<f.getY()+50){
				return true;
			}
		}
		
		
		return false;
	}
}
