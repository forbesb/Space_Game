package ship;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import ship.weapons.*;




public class Ship {
	private double angle;
	private double dx,dy;
	private double speed;
	private double x, y;
	private double sx, sy;
	private int size;
	private int accel;
	private int health;
	
	private ArrayList<Weapon> weapons=new ArrayList<Weapon>();
	
	public Ship(){
		angle=Math.toRadians(90);
		x=100;
		y=100;
		dx=0;
		dy=0;
		sx=0;
		sy=0;
		
		size=3;
		speed=3;
		accel=0;
		health=100;
		
		weapons.add(new MachineGun());
	}
	
	public void draw(Graphics g){
//		Attempts at rotation. 
//		Graphics2D g2d=(Graphics2D)g;
//		g2d.setColor(Color.red);
//		Rectangle rect1=new Rectangle((int)x-size,(int)y-size,size*2,size*2);
//		g2d.rotate(angle);
//		g2d.draw(rect1);
//		g2d.translate(rect1.x+(rect1.width/2), rect1.y+(rect1.height/2));
		
		
		
		drawShip(g);
		x+=dx;
		y+=dy;
		dx-=dx*0.01;
		dy-=dy*0.01;
		
		
	}
	
	public void drawShip(Graphics g){
		//Change to Weapons.draw(g);
		
		//Change to Chasis.draw(g);
				
		//Engine.draw(g);
		
		
		//Weapons
		for(Weapon i: weapons){
			i.draw(g, x, y, angle);
		}
		
		//Engine
		if(accel>0){
			g.setColor(Color.orange);
			g.drawLine((int)x,(int)y,(int)(x-2*size*Math.cos(angle+0.3)),(int)(y+2*size*Math.sin(angle+0.3)));
			g.drawLine((int)x,(int)y,(int)(x-2*size*Math.cos(angle-0.3)),(int)(y+2*size*Math.sin(angle-0.3)));
			accel--;
		}
		
		//Body
		g.setColor(Color.red);
		g.drawRect((int)x-size,(int)y-size,size*2,size*2);
		
		//Health
		g.setColor(Color.green);
		g.drawLine((int)(x-size*1.5), (int)y-6, (int)(x+size*1.5*health/100), (int)y-6);
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
	
	public void shoot(){
		for(Weapon i:weapons){
			i.fire(x-sx,y-sy,angle);
		}
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
	
	public Rectangle getRect(){
		return new Rectangle((int)x-size,(int)y-size,size*2,size*2);
	}
}
