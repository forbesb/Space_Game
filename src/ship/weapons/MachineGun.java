package ship.weapons;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import ship.weapons.ammo.Bullet;

public class MachineGun extends Weapon{
	public MachineGun(){
		size=9;
		bullets=new ArrayList<Bullet>();
	}
	@Override
	public void draw(Graphics g, double x,double y, double angle) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.drawLine((int)x,(int)y,(int)(x+size*Math.cos(angle)),(int)(y-size*Math.sin(angle)));
		for(int i=0;i<bullets.size();i++){
			bullets.get(i).draw(g);
		}
	}
	@Override
	public void fire(double x, double y, double angle) {
		bullets.add(new Bullet(x, y, angle));
	}
	@Override
	public void update(double x, double y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<Bullet> getBullets() {
		// TODO Auto-generated method stub
		return bullets;
	}
	
}
