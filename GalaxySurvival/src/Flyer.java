import java.awt.Graphics;


public class Flyer {
	
	double y, yVel;
	int x, xVel;
	boolean upAccel, downAccel, rightAccel, leftAccel;
	
	public Flyer(){
		upAccel = false;
		downAccel = false;
		rightAccel = false;
		leftAccel = false;
		y = 450;
		x = 350;
	}
	
	public void reset(){
		upAccel = false;
		downAccel = false;
		rightAccel = false;
		leftAccel = false;
		y = 450;
		x = 350;
	}
	
	public void draw(Graphics g){
		g.fill3DRect(x+15, (int)y+15, 30, 30, true);
	}
	
	public void move(){
		if(upAccel){
			yVel -= 2;
		}else if(downAccel){
			yVel += 2;
		}else if(rightAccel){
			xVel += 2;
		}else if(leftAccel){
			xVel -= 2;
		}else if(!upAccel && !downAccel && !rightAccel && !leftAccel){
			xVel*=0.12;
			yVel*=0.12;
		}

		if(yVel >= 5)
			yVel = 5;
		if(yVel <= -5)
			yVel = -5;
		if(xVel >= 5)
			xVel = 5;
		if(xVel <= -5)
			xVel = -5;
		
		y+=yVel;
		x+=xVel;
		
		if(x<0){
			x = 0;
		}else if(x>670){
			x = 670;
		}	
			
		if(y>470){
			y = 470;
		}else if(y<30){
			y = 30;
		}
	}
	
	public int getY(){
		return (int)y;
	}
	
	public int getX(){
		return x;
	}
	
	public void setUpAccel(boolean isUp){
		upAccel = isUp;
	}
	
	public void setDownAccel(boolean isDown){
		downAccel = isDown;
	}
	
	public void setRightAccel(boolean isRight){
		rightAccel = isRight;
	}
	
	public void setLeftAccel(boolean isLeft){
		leftAccel = isLeft;
	}
}
