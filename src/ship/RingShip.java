package ship;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import ship.weapons.Weapon;
import ship.weapons.ammo.Bullet;

public class RingShip extends Enemy{
	public RingShip(double x, double y){
		super(x, y);
		speed=1;
		health=1;
	}
	@Override
	public void target(Ship user){
		tx=user.getX();
		ty=user.getY();
	}
	@Override
	public void avoid(Ship user){
		
	}
	@Override
	public void drawShip(Graphics g) {
		if(health<=0){
			g.setColor(Color.red);
			g.drawRect((int)x-size, (int)y-size, health*-1,health*-1);
			health--;
			return;
		}
		g.setColor(Color.yellow);
		g.drawOval((int)x-size, (int)y-size, size*2, size*2);
		g.setColor(Color.green);
		g.drawLine((int)(x-size*1.5), (int)y-6, (int)(x+size*1.5*health/10), (int)y-6);
	}
	@Override
	public void damage(Ship user) {
		ArrayList<Bullet> bullets=user.getWeapons().get(0).getBullets();
		if(user.getRect().intersects(this.getRect())){
			System.out.println(user.getHealth());
			user.setHealth(user.getHealth()-20);
			health=0;
		}
		for(int i=0;i<bullets.size();i++){
			if(bullets.get(i).getRect().intersects(this.getRect())){
				health--;
				bullets.remove(i);
				i--;
			}
			else if(bullets.get(i).getRect().x>1000||bullets.get(i).getRect().y>800||bullets.get(i).getRect().x<0||bullets.get(i).getRect().y<0){
				bullets.remove(i);
				i--;
			}
		}
	}
}
