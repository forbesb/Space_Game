package ship.weapons.ammo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



public class Bullet {
	double x,y;
	double angle;
	double dx, dy;
	int speed;
	public Bullet(double x, double y, double angle){
		this.angle=angle;
		this.x=x;
		this.y=y;
		dx=Math.cos(angle)*6;
		dy=-Math.sin(angle)*6;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.white);
		g.drawRect((int)x, (int)y, 1, 1);
		x+=dx;
		y+=dy;
	}
	
	public Rectangle getRect(){
		return new Rectangle((int)x,(int)y,1,1);
	}
}
