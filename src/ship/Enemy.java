package ship;
import java.awt.Graphics;
import java.util.ArrayList;

import ship.weapons.*;
import ship.weapons.ammo.Bullet;

public abstract class Enemy extends Ship{
	public double tx, ty;
	public Enemy(double x, double y){
		super();
		super.x=x;
		super.y=y;
	}
	public void update(){
		double a=tx-x, b=ty-y;
		double hyp=Math.sqrt(a*a+b*b);
		dx=a*speed/hyp;
		dy=b*speed/hyp;
		super.update();
	}
	@Override
	public abstract void drawShip(Graphics g);
	public abstract void target(Ship user);
	public abstract void avoid(Ship user);
	public abstract void damage(Ship user);
}
