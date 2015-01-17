import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Ship {
	double angle;
	double dx,dy;
	double speed;
	double x, y;
	int size;
	int accel;
	
	public Ship(){
		angle=Math.toRadians(90);
		x=100;
		y=100;
		dx=0;
		dy=0;

		size=3;
		speed=3;
		accel=0;
	}
	
	public void draw(Graphics g){
//		Graphics2D g2d=(Graphics2D)g;
//		g2d.setColor(Color.red);
//		Rectangle rect1=new Rectangle((int)x-size,(int)y-size,size*2,size*2);
//		g2d.rotate(angle);
//		g2d.draw(rect1);
//		g2d.translate(rect1.x+(rect1.width/2), rect1.y+(rect1.height/2));
		g.setColor(Color.red);
		g.drawLine((int)x,(int)y,(int)(x+10*Math.cos(angle)),(int)(y-10*Math.sin(angle)));
		g.drawRect((int)x-size,(int)y-size,size*2,size*2);
		if(accel>0){
			g.setColor(Color.orange);
			g.drawLine((int)x,(int)y,(int)(x-5*Math.cos(angle+0.3)),(int)(y+5*Math.sin(angle+0.3)));
			g.drawLine((int)x,(int)y,(int)(x-5*Math.cos(angle-0.3)),(int)(y+5*Math.sin(angle-0.3)));
			accel--;
		}
		x+=dx;
		y+=dy;
		dx-=dx*0.01;
		dy-=dy*0.01;
	}
	
	public void accel(){
		accel=2;
		dx+=Math.cos(angle)/10;
		dy-=Math.sin(angle)/10;
		if(dx*dx+dy*dy>speed*speed){
			dy+=Math.sin(angle)/10;
			dx-=Math.cos(angle)/10;
		}
	}
	
	public void burners(){
		dx=Math.cos(angle)*speed;
		
		dy=-Math.sin(angle)*speed;
		
	}
	
	public void turn(double turn_rate){
		angle+=turn_rate;
	}
	
	//Getters and Setters
	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}
